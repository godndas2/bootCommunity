package com.halfdev.my.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private DBConnection() {
		
	}
	public static final String URL = "jdbc:mysql://localhost:3306/bootcommunity?useSSL=false";
	
	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection(URL, "bootcommunity", "halfdev");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
