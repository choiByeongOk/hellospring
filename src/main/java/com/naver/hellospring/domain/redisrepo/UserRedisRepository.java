package com.naver.hellospring.domain.redisrepo;

import com.naver.hellospring.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRedisRepository extends CrudRepository<User, String> {
}