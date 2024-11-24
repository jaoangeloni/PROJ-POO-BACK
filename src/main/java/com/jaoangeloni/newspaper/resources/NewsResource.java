package com.jaoangeloni.newspaper.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaoangeloni.newspaper.domain.News;
import com.jaoangeloni.newspaper.services.NewsService;

@RestController
@RequestMapping(value="/news")
public class NewsResource {
	
	@Autowired
	private NewsService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody News news){
		News obj = service.insert(news);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

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
