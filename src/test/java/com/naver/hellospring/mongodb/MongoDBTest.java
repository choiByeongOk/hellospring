package com.naver.hellospring.mongodb;

import static org.assertj.core.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.naver.hellospring.domain.Person;
import com.naver.hellospring.domain.repository.mongodbrepo.PersonMongoDBRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MongoDBTest {

	@Autowired
	private PersonMongoDBRepository personMongoDBRepository;

	@After
	public void tearDown() throws Exception {
		personMongoDBRepository.deleteAll();
	}

	@Test
	public void test() {
		//given
		String id = "MongoDBTest";
		Person person = Person.builder()
			.id(id)
			.name("CBO")
			.job("ant")
			.build();

		//when
		personMongoDBRepository.save(person);

		//then
		Person savedPerson = personMongoDBRepository.findById(id).get();
		assertThat(savedPerson.getName()).isEqualTo("CBO");
		assertThat(savedPerson.getJob()).isEqualTo("ant");
	}
}
