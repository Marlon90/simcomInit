package de.simcom.games.arma.commandMachine.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CommandList {
    Writer writer;

    public String getCommandList() throws IOException {
	System.out.println("---- Starting initializing list");

	Document doc = Jsoup.connect("https://community.bistudio.com/wiki/Category:Scripting_Commands_Arma_3").get();

	Elements allLists = doc.getElementsByClass("mw-category");

	String commands = allLists.get(0).text().replaceAll(" ", "_").replaceAll("_%", "_%25_");
	String returner = "";
	for (Element element : allLists.get(0).getAllElements()) {
	    for (Element e : element.getElementsByTag("li")) {
		if (e.tagName() != "ul") {
		    returner += e.wholeText() + "\n";
		}
	    }
	    ;
	}
	;
	return returner.replaceAll(" ", "_").replaceAll("_%", "_%25");

    }

    public void getCommands() throws IOException, URISyntaxException {
	List<String> list = new ArrayList<String>();

	for (String command : getCommandList().split("\n")) {
	    String url = "https://community.bistudio.com/wiki/" + command;
	    Document doc = Jsoup.connect(url).get();
	    writer = new BufferedWriter(new FileWriter(new File("commandList.txt"), true));
	    for (Element e : doc.getElementsByTag("dl")) {
		if (e.getElementsContainingText("Syntax:").size() > 0) {
		    String syntax = (e.getElementsContainingText("Syntax:").get(0).wholeText().replaceAll("\n",
			    "")) == null ? ""
				    : e.getElementsContainingText("Syntax:").get(0).wholeText();
					    //
		    if (syntax.contains("\n")) {
			syntax.replaceAll("\n", "");
		    }
		   // syntax = syntax.split("Syntax:")[1];
		    if (syntax.contains("Parameters")) {
			syntax = syntax.split("Parameters:")[0] + "\n";
		    }
		    writer.write(syntax);

		}

	    }
	    writer.flush();
	    writer.close();
	}
	;

	/*
	 * for (String t : getCommandList().split("\n")) { String url =
	 * "https://community.bistudio.com/wiki/" + t; Document doc =
	 * Jsoup.connect(url).get(); Elements elements =
	 * doc.getElementsByIndexEquals(0);
	 * list.add(elements.get(0).wholeText()); System.out.println(url); } for
	 * (String t : list) { System.out.println(t); }
	 */
    }
}
