package com.halfDev.my.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.halfdev.my.domain.mapper.UserMapper;
import com.halfdev.my.domain.mapper.UserRoleMapper;
import com.halfdev.my.domain.model.Role;
import com.halfdev.my.domain.model.User;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName(value = "권한 관련 테스트")
public class RoleMapperTest {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper roleMapper;
	private static List<Role> contacts;
	private static User user;

	@BeforeAll
	public static void setUp() {
	}

	@Test
	public void save() {
		contacts = new ArrayList<>();
		user = userMapper.findAll().get(0);
	}
}
