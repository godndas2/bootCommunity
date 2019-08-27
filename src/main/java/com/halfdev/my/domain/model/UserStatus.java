package com.halfdev.my.domain.model;

import java.util.Optional;
import java.util.stream.Stream;

import com.halfdev.my.domain.TypeHandlerException;

import lombok.Getter;

@Getter
public enum UserStatus {

	ON(1),
	BLOCK(2),
	DORMANT(3),
	LEAVE(4);

	private int value;

	UserStatus(int value) {
		this.value = value;
	}
}
