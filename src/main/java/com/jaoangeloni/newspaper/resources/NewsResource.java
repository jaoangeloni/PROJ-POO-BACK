package com.jaoangeloni.newspaper.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jaoangeloni.newspaper.domain.News;
import com.jaoangeloni.newspaper.services.NewsService;

@RestController
@RequestMapping(value="/news")
public class NewsResource {
	
	@Autowired
	private NewsService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<News>> findAll(){
		List<News> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<News> findById(@PathVariable String id){
		News obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
