package com.jaoangeloni.newspaper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jaoangeloni.newspaper.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
