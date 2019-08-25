package com.halfdev.my.application;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.halfdev.my.domain.model.User;

public interface HalfDevService {

	User save(User user);

	User update(User user);

	User findByEmail(String email);

	User signUp(UserConnection userConnection);
}
