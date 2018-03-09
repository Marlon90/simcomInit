package de.simcom.games.wargame.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import de.simcom.games.wargame.dao.ElementDao;
import de.simcom.games.wargame.factories.jdbc.ConnectorFactoryImpl;
import de.simcom.games.wargame.models.unit.Unit;
import de.simcom.games.wargame.models.unit.impl.UnitImpl;
import de.simcom.games.wargame.nations.Nation;

public class ElementDaoImpl implements ElementDao {

	ConnectorFactoryImpl conn;
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	JdbcTemplate jdbcTemplate;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectorFactoryImpl.getInstance().getConnection();
		return conn;
	}

	/*
	 * private static Unit fromResult(ResultSet rs) throws SQLException {
	 * 
	 * return null; }
	 */

	public Unit get(String name) throws SQLException {

		String sql = "SELECT * FROM tank WHERE tank.name = ?;";

		connection = getConnection();
		ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, name);
		rs = ptmt.executeQuery();

		Unit unit = new UnitImpl();

		unit.setId(rs.getInt(rs.getString("type") + "Id"));
		unit.setName(rs.getString("name"));
		unit.setHp(rs.getInt("hp"));
		unit.setSize(rs.getString("sizes"));
		unit.setOptics(rs.getString("optics"));
		unit.setStealth(rs.getString("stealth"));
		unit.setGroundSpeed(rs.getInt("groundSpeed"));
		unit.setAmphibiousSpeed(rs.getInt("amphibiousSpeed"));
		unit.setAutonomy(rs.getInt("autonomy"));
		unit.setService(rs.getInt("service"));
		unit.setRoadSpeed(rs.getInt("roadSpeed"));
		unit.setArmor(rs.getString("armor"));
		unit.setNationId(rs.getInt("nationId"));
		unit.setPoints(rs.getInt("points"));
		unit.setCards(rs.getInt("cards"));
		unit.setTransporterId(rs.getInt("transporterId"));
		unit.setWeaponId(rs.getString("weaponId"));
		unit.setCat(rs.getInt("cat"));
		unit.setThematic(rs.getInt("thematic"));
		unit.setType(rs.getString("type"));

		return unit;

	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName(String name) throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement("SELECT 'name' FROM * WHERE name = ?");

		int i = stmt.executeUpdate();
		System.out.println(i + " records inserted");
		return "";
	}

	@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOptic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHealth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroundSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAmphibiousSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAutonomy() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getService() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRoadSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getArmor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNationId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCards() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTransporterId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWeaponIdOne() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWeaponIdTwo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWeaponIdThree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAirdetection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getThematic() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTraining() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nation getNation(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
