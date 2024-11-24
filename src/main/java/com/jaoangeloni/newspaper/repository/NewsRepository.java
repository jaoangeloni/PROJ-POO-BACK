package com.jaoangeloni.newspaper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jaoangeloni.newspaper.domain.News;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {}
