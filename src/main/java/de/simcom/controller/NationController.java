package de.simcom.controller;

import java.sql.SQLException;

public interface NationController {

	String getName(int id) throws SQLException;
}
