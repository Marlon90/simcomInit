package de.simcom.controller.impl;

import java.sql.SQLException;

import de.simcom.controller.NationController;
import de.simcom.dao.NationDao;
import de.simcom.dao.impl.NationDaoImpl;
import de.simcom.nations.Nation;

public class NationControllerImpl implements NationController {

	NationDao<Nation, Integer> dao = new NationDaoImpl();
	
	@Override
	public String getName(int id) throws SQLException {
		return dao.getNation(id).getName();
	}
}