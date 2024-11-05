package com.projeto.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projeto.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
