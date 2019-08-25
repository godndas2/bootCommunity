package com.halfdev.my.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.halfdev.my.HalfDevDAO;
import com.halfdev.my.domain.model.User;
import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HalfDevController {

	private final HikariDataSource dataSource;
    private final HalfDevDAO halfDevDAO;

    @GetMapping(value = {"/", "/index"})
    public String index() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection.getCatalog();
    }

    @GetMapping(value = "users/{id}")
    public User user(@PathVariable(value = "id") long id) {
    	halfDevDAO.findByName("a");
        return halfDevDAO.findById(id);
    }
}
