package de.simcom.games.arma.templateEngine.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import de.simcom.games.arma.templateEngine.TemplateEngine;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

public class TemplateEngineFactory implements TemplateEngine {

    private static Configuration cfg;

    public TemplateEngineFactory() {

    }

    public static Configuration getInstance(String resources) throws TemplateNotFoundException,
	    MalformedTemplateNameException, ParseException, IOException, TemplateException {

	if (cfg == null) {

	    cfg = new Configuration(Configuration.VERSION_2_3_27);
	    URL directory = TemplateEngineFactory.class.getResource(resources);
	    cfg.setDirectoryForTemplateLoading(new File(directory.getPath()));
	    cfg.setDefaultEncoding("UTF-8");
	    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	    cfg.setLogTemplateExceptions(false);
	    cfg.setWrapUncheckedExceptions(true);
	}

	return cfg;

    }
}
