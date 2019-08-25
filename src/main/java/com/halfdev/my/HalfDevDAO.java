package com.halfdev.my;

import java.sql.ResultSet;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.halfdev.my.domain.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HalfDevDAO {

	 private final JdbcTemplate jdbcTemplate;
	    private final SqlSessionTemplate sqlSessionTemplate;

	    public User findById(long id) {
	        return jdbcTemplate.queryForObject("SELECT 1 AS id, '홍길동' as Name FROM DUAL WHERE 1 = ?", (ResultSet rs, int rowNum) -> User.builder().id(rs.getLong(1)).nickname(rs.getString(2)).build(), id);
	    }

	    public User findByName(String name) {
	        return sqlSessionTemplate.selectOne("SELECT 1 AS id, '홍길동' as Name FROM DUAL WHERE 'a' = #{name}", name);
	    }
}
