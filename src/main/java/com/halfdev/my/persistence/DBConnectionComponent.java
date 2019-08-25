package com.halfdev.my.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@Configuration
//@PropertySource("classpath:META-INF/db.properties")
public class DBConnectionComponent {

	@Value(value = "${spring.datasource.url}")
	public String url;
	@Value(value = "${spring.datasource.username}")
	public String username;
	@Value(value = "${spring.datasource.password}")
	public String password;

	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
