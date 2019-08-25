package com.halfDev.my.interfaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;

import com.halfdev.my.application.HalfDevService;
import com.halfdev.my.domain.model.User;
@ExtendWith(SpringExtension.class)
@RestClientTest(HalfDevService.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private HalfDevService halfDevService;

	@Autowired
	private MockRestServiceServer serviceServer;

	@Test
	@DisplayName("User Test")
	public void userTest() {
		serviceServer.expect(requestTo("/users/1")).andRespond(withSuccess(new ClassPathResource("/user.json", getClass()), MediaType.APPLICATION_JSON));
		User user = halfDevService.getUser(1);
		assertThat(user.getId()).isEqualTo(1);
	}
}
