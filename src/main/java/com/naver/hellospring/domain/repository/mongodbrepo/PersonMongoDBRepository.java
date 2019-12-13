package com.naver.hellospring.domain.repository.mongodbrepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.naver.hellospring.domain.Person;

public interface PersonMongoDBRepository extends MongoRepository<Person, String>  {
	public Person findByName (String name);
}
