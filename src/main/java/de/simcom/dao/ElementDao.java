package de.simcom.dao;

import java.sql.SQLException;

import de.simcom.nations.Nation;

public interface ElementDao extends NationDao<Nation, Integer> {

	int getId();

	String getName(String name) throws SQLException;

	int getHp();

	String getSize();

	String getOptic();

	String getHealth();

	int getGroundSpeed();

	int getAmphibiousSpeed();

	int getAutonomy();

	int getService();

	int getRoadSpeed();

	int getArmor();

	int getNationId();

	int getPoints();

	int getCards();

	int getTransporterId();

	int getWeaponIdOne();

	int getWeaponIdTwo();

	int getWeaponIdThree();

	String getAirdetection();

	int getCat();

	int getThematic();

	String getTraining();
}
