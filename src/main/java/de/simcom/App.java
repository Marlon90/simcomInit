package de.simcom;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import de.simcom.games.arma.commandMachine.impl.CommandList;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class App {

    public static void main(String[] args) throws SQLException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
	/*
	 * Tank a1 = new M1Abrams(); Tank a2 = new M1Abrams(); AttackMove attack
	 * = new AttackMove(a1, a2); attack.attack();
	 */

	// Application.launch(View.class, args);
	//Constructor c = new ConstructorImpl();
	//c.doStatement(new DataImpl(ControlStructurType.IF, "alive player", "hint 'test'"));
	
	CommandList cl = new CommandList();
	try {
	    cl.getCommands();
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
}
