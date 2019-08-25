package com.halfDev.my.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceTest {

	public static final String USER_NAME = "bootcommunity";
	public static final String PASS_WORLD = "halfdev";
	public static final String CATALOG = "bootcommunity";
	private static HikariConfig configuration;

	@BeforeAll
	@DisplayName(value = "히카리 설정 초기화")
	public static void init() {
		configuration = new HikariConfig();
		configuration.setDriverClassName("com.mysql.jdbc.Driver");
		configuration.setJdbcUrl("jdbc:mysql://localhost:3306/bootcommunity?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
		configuration.setUsername(USER_NAME);
		configuration.setPassword(PASS_WORLD);
		configuration.setConnectionInitSql("SELECT 1 FROM DUAL");
	}

	@Test
	@DisplayName(value = "히카리를 이용해 데이터베이스에 커넥션")
	public void hikariDataSourceTest() throws SQLException {
		try (HikariDataSource hikariDataSource = new HikariDataSource(configuration)) /*var*/ {
			Connection connection = hikariDataSource.getConnection(); // var
			Assertions.assertEquals(CATALOG, connection.getCatalog());
		}
	}
}
