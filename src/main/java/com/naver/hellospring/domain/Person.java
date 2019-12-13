package com.naver.hellospring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Document(collection = "person")
public class Person {
	@Id
	private String id;
	private String name;
	private String job;

	@Builder
	protected Person(String id, String name, String job) {
		this.id = id;
		this.name = name;
		this.job = job;
	}

	@Override
	public String toString() {
		return "name is " + name + " job is " + job;
	}
}
