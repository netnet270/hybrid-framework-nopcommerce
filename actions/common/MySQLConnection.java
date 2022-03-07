package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection getMySQLConnection() {
		String hostName = "localhost";
		String dbName = "automation";
		String username = "root";
		String password = "123456";
		return getMySQLConnection(hostName, dbName, username, password);
	}
	
	public static Connection getMySQLConnection(String hostName, String dbName, String username, String password) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
