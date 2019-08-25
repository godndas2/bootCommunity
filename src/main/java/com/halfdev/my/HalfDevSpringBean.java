package com.halfdev.my;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HalfDevSpringBean {

	private String name;
	
	public HalfDevSpringBean(String name) {
		this.name = name;
	}
} 
