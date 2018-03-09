package de.simcom.games.arma.buildMachine.enums;

public enum ControlStructurType {

    IF("if.ftlh"), IFELSE("ifelse.ftlh"), WHILE("while.ftlh"), FOR("for.ftlh"), FOREACH("foreach.ftlh");

    private String template;

    ControlStructurType(String template) {
	this.template = template;
    }

    public String getType() {
	return template.split(".")[0];
    }

    public String getPath() {
	return template;
    }
}
