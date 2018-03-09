package de.simcom.games.arma.buildMachine.data.impl;

import java.util.HashMap;
import java.util.Map;

import de.simcom.games.arma.buildMachine.data.Data;
import de.simcom.games.arma.buildMachine.enums.ControlStructurType;

public class DataImpl implements Data {

    private String condition;
    private String statement;
    private ControlStructurType controlStructurType;

    public DataImpl(ControlStructurType cst, String condition, String statement) {
	this.condition = condition;
	this.statement = statement;
	this.controlStructurType = cst;
    }

    @Override
    public void setData(ControlStructurType cst, String condition, String statement) {
	this.condition = condition;
	this.statement = statement;
	this.controlStructurType = cst;
    }

    @Override
    public Map<String, Object> getData() {
	Map<String, Object> data = new HashMap<String, Object>();
	data.put("condition", condition);
	data.put("statement", statement);
	data.put("controlStructurType", controlStructurType);
	return data;
    }

    @Override
    public Map<String, Object> getMappedData() {
	Map<String, Object> dataMap = new HashMap<String, Object>();
	dataMap.put("data", this);
	return dataMap;
    }

    public String getCondition() {
	return condition;
    }

    public String getStatement() {
	return statement;
    }

    public ControlStructurType getControlStructurType() {
	return controlStructurType;
    }
}