package com.halfDev.my.datasource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.halfdev.my.domain.model.User;


@JdbcTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class SpringJdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Order(1)
    @DisplayName("jdbcTemplate test 😱")
    public void jdbcTemplateTest() {
        String select = jdbcTemplate.queryForObject("SELECT 'BOOTCOMMUNITY' AS ID", String.class);
        Assertions.assertEquals("BOOTCOMMUNITY", select);
    }

    @Test
    @Order(2)
    @DisplayName("jdbcTemplate RowMapper test 😱")
    public void jdbcTemplateRowMapperTest() {
        User user = jdbcTemplate.queryForObject("SELECT '1' AS ID, 'halfdev' AS EMAIL", (rs, rowNum) -> User.builder().id(rs.getLong("ID")).email(rs.getString("EMAIL")).build());
        Assertions.assertEquals("halfdev", user.getEmail());
    }
}
