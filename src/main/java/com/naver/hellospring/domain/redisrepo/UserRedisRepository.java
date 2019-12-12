package com.naver.hellospring.domain.redisrepo;

import org.springframework.data.repository.CrudRepository;

import com.naver.hellospring.domain.User;

public interface UserRedisRepository extends CrudRepository<User, String> {
}