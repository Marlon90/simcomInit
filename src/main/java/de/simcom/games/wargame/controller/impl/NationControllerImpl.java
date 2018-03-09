package de.simcom.games.wargame.controller.impl;

import java.sql.SQLException;

import de.simcom.games.wargame.controller.NationController;
import de.simcom.games.wargame.dao.NationDao;
import de.simcom.games.wargame.dao.impl.NationDaoImpl;
import de.simcom.games.wargame.nations.Nation;

public class NationControllerImpl implements NationController {

	NationDao<Nation, Integer> dao = new NationDaoImpl();
	
	@Override
	public String getName(int id) throws SQLException {
		return dao.getNation(id).getName();
	}
}