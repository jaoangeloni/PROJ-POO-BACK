package com.jaoangeloni.newspaper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaoangeloni.newspaper.domain.News;
import com.jaoangeloni.newspaper.repository.NewsRepository;
import com.jaoangeloni.newspaper.services.exception.ObjectNotFoundException;

@Service
public class NewsService {

	@Autowired
	private NewsRepository repo;
	
	public List<News> findAll(){
		return repo.findAll();
	}
	
	public News findById(String id) {
		Optional<News> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public News insert(News obj) {
		return repo.insert(obj);
	}


}
