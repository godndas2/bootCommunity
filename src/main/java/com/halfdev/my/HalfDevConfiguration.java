package com.halfdev.my;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class HalfDevConfiguration {

	@Bean
	public HalfDevSpringBean annotationSpringBean() {
		return new HalfDevSpringBean("annotationSpringBean");
	}
}
