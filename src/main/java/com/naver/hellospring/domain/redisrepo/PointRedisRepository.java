package com.naver.hellospring.domain.redisrepo;

import com.naver.hellospring.domain.Point;
import org.springframework.data.repository.CrudRepository;

public interface PointRedisRepository extends CrudRepository<Point, String> {
}