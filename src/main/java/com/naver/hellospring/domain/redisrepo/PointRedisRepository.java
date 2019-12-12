package com.naver.hellospring.domain.redisrepo;

import org.springframework.data.repository.CrudRepository;

import com.naver.hellospring.domain.Point;

public interface PointRedisRepository extends CrudRepository<Point, String> {
}