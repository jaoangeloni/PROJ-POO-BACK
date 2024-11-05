package com.projeto.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projeto.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
