package com.projeto.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.projeto.domain.Post;
import com.projeto.projeto.domain.User;
import com.projeto.projeto.dto.UserDTO;
import com.projeto.projeto.repository.PostRepository;
import com.projeto.projeto.repository.UserRepository;
import com.projeto.projeto.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}


}
