package de.simcom.games.arma.buildMachine;

public class ControlStructures {

    private String condition;
    private String statement;

    public ControlStructures() {

    }

    public ControlStructures(String condition, String statement) {
	this.condition = condition;
	this.statement = statement;
    }

    public String getCondition() {
	return condition;
    }

    public void setCondition(String condition) {
	this.condition = condition;
    }

    public String getStatement() {
	return statement;
    }

    public void setStatement(String statement) {
	this.statement = statement;
    }
}
