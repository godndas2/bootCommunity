package com.halfDev.my.domain.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.halfdev.my.domain.mapper.WinnerMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName(value = "벌크 인서트 테스트")
public class WinnerMapperTest {

	@Autowired
	private WinnerMapper winnerMapper;

	@Test
	@DisplayName("벌크 인서트")
	public void insert() {

	}
}
