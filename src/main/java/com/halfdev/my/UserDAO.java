package com.halfdev.my;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO {

	private JdbcTemplate jdbcTemplate;

	public UserDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveUser(String email, String password, String nickname, String status, LocalDateTime regDate) {
		return jdbcTemplate.update("INSERT INTO USER (EMAIL, PASSWORD, NICKNAME, STATUS, REG_DT) VALUES (? ,?, ?, ?, ?)", email, password, nickname, status, regDate);
	}

	public List<String> getUsers() {
		return jdbcTemplate.query("SELECT PASSWORD FROM USER", (rs) -> {
			List<String> result = new ArrayList<String>(); // var
			while (rs.next()) {
				result.add(rs.getString("PASSWORD"));
			}
			return result;
		});
	}

	public int deleteAll() {
		return jdbcTemplate.update("DELETE FROM USER");
	}
}
