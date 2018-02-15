package de.simcom.factories.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorFactoryImpl {

	//private String url = "jdbc:sqlite:" + new File("").getAbsolutePath() + "\\articleDB.db";
	private String url = "jdbc:sqlite:" + new File("").getAbsolutePath() + "\\dba.db";
	private static ConnectorFactoryImpl conn = null;

	public static ConnectorFactoryImpl getInstance() {
		
		if (conn == null) {
			conn = new ConnectorFactoryImpl();
		}
		return conn;
	}	
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}