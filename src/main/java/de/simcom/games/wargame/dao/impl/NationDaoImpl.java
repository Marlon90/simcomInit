package de.simcom.games.wargame.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import de.simcom.games.wargame.dao.NationDao;
import de.simcom.games.wargame.factories.jdbc.ConnectorFactoryImpl;
import de.simcom.games.wargame.nations.Nation;
import de.simcom.games.wargame.nations.impl.NationImpl;

public class NationDaoImpl implements NationDao<Nation, Integer>, Serializable {

	JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ConnectorFactoryImpl conn;
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectorFactoryImpl.getInstance().getConnection();
		return conn;
	}

	@Override
	public Nation getNation(int id) throws SQLException {
		try {
			Nation nation = null;
			String sql = "SELECT * FROM nation WHERE nationId = ?";

			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setInt(1, id);
			resultSet = ptmt.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				System.out.println("No data");
			}

			while (resultSet.next()) {
				nation = new NationImpl();
				nation.setId(resultSet.getInt("nationId"));
				nation.setName(resultSet.getString("name"));
			}
			return nation;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}