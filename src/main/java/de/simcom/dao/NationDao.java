package de.simcom.dao;

import java.sql.SQLException;

import de.simcom.nations.Nation;

public interface NationDao<E,T> {

	Nation getNation(int id) throws SQLException;
	
}
