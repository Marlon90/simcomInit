package de.simcom.games.wargame.dao;

import java.sql.SQLException;

import de.simcom.games.wargame.nations.Nation;

public interface NationDao<E,T> {

	Nation getNation(int id) throws SQLException;
	
}
