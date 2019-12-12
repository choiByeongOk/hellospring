package com.naver.hellospring.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Getter;

@Getter
@RedisHash("user")
public class User implements Serializable {

	@Id
	private String id;
	private String email;
	private String password;
	private LocalDateTime createdTime;

	@Builder
	protected User(String id, String email, String password, LocalDateTime createdTime) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.createdTime = createdTime;
	}
}
