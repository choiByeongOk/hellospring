package com.naver.hellospring.redis;

import static org.assertj.core.api.Assertions.*;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.naver.hellospring.domain.User;
import com.naver.hellospring.domain.redisrepo.UserRedisRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserRedisRepository userRedisRepository;

	@After
	public void tearDown() throws Exception {
		userRedisRepository.deleteAll();
	}

	@Test
	public void test() throws FileNotFoundException {
		/*
		File file = new File("log.txt");
		PrintStream printStream = new PrintStream(new FileOutputStream(file));
		System.setOut(printStream);
		System.setErr(printStream);
		*/

		//given
		String id = "UserTest";
		String email = "Byeongok.choi@navercorp.com";
		String password = "pw11";
		LocalDateTime createdTime = LocalDateTime.now();

		User user = User.builder()
			.id(id)
			.email(email)
			.password(password)
			.createdTime(createdTime)
			.build();

		//when
		userRedisRepository.save(user);

		//then
		User savedUser = userRedisRepository.findById(id).get();
		assertThat(savedUser.getEmail()).isEqualTo(email);
		assertThat(savedUser.getPassword()).isEqualTo(password);
		assertThat(savedUser.getCreatedTime()).isEqualTo(createdTime);
	}
}
