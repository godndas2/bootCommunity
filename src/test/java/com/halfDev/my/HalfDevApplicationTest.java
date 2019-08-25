package com.halfDev.my;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HalfDevApplicationTest {

	@Test
	@DisplayName(value = "Is it OK?")
	public void helloWorld() {
		
	}
}
