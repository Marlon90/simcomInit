package de.simcom.games.arma.buildMachine.data;

import java.util.Map;

import de.simcom.games.arma.buildMachine.enums.ControlStructurType;

public interface Data {

    void setData(ControlStructurType cst, String condition, String statement);

    Map<String, Object> getData();
    
    Map<String, Object> getMappedData();
    
    String getCondition();

    String getStatement();

    ControlStructurType getControlStructurType();
}
