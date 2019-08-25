package com.halfdev.my;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.halfdev.my.domain.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "com.halfdev.my")
public class HalfDevProperties {

	private String username;
    private String password;
    private String url;
    private List tables;
    private Map<String, String> params;
    private List<User> users;
}
