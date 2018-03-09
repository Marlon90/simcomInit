package de.simcom.games.arma.buildMachine.constructor.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;

import de.simcom.games.arma.buildMachine.constructor.Constructor;
import de.simcom.games.arma.buildMachine.data.Data;
import de.simcom.games.arma.templateEngine.impl.TemplateEngineFactory;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class ConstructorImpl implements Constructor {

    private Configuration cfg;
    

    @Override
    public void doStatement(Data data) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException,
	    IOException, TemplateException {

	checkCfg();

	Template template = cfg.getTemplate(data.getControlStructurType().getPath());
	URL directory = ConstructorImpl.class.getResource("");
	File file = new File(directory.getPath() + "/output.sqf");
	Writer bw = new BufferedWriter(new FileWriter(file, true));

	template.process(data.getMappedData(), bw);

	bw.flush();
	bw.close();
    }

    @Override
    public void doStatementConsole(Data data) throws TemplateNotFoundException, MalformedTemplateNameException,
	    ParseException, IOException, TemplateException {
	checkCfg();
	Template template = cfg.getTemplate(data.getControlStructurType().getPath());

	Writer out = new OutputStreamWriter(System.out);

	template.process(data.getMappedData(), out);

	out.flush();
	out.close();

    }

    @Override
    public void setTemplateEngine() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException,
	    IOException, TemplateException {
	this.cfg = TemplateEngineFactory.getInstance("templates/");
    }

    private void checkCfg() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException,
	    IOException, TemplateException {
	if (cfg == null) {
	    setTemplateEngine();
	}
    }

}
