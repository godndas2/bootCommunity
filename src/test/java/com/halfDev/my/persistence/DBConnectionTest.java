package com.halfDev.my.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.halfdev.my.persistence.DBConnection;

@DisplayName(value = "데이터베이스 접속")
public class DBConnectionTest {

	public static final String URL = "jdbc:mysql://localhost:3306/bootcommunity?useSSL=false";

    @Test
    @DisplayName(value = "Socket 데이터베이스에 접속해보자")
    public void socketTest() {
        try {
            SocketChannel client = SocketChannel.open();
            client.connect(new InetSocketAddress("localhost", 3306));
            assertTrue(client.isConnected());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName(value = "데이터베이스에 접속해보자")
    public void connectionTest() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(URL, "bootcommunity", "halfdev");
            assertEquals("bootcommunity", connection.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName(value = "DatabaseConnection 클래스를 만들어서 데이터베이스에 접속해보자")
    public void DatabaseConnectionTest() throws SQLException {
        Connection connection = DBConnection.getConnection();
        assertEquals("bootcommunity", connection.getCatalog());
    }
}
