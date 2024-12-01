package com.jaoangeloni.newspaper.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaoangeloni.newspaper.domain.News;
import com.jaoangeloni.newspaper.repository.NewsRepository;
import com.jaoangeloni.newspaper.services.exception.ObjectNotFoundException;

@Service
public class NewsService {

	@Autowired
	private NewsRepository repo;
	
    private final Cloudinary cloudinary;

    public NewsService() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "",
            "api_key", "",
            "api_secret", ""
        ));
    }
	
	    
	public String uploadImage(MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return (String) uploadResult.get("public_id");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao fazer upload para o Cloudinary", e);
        }
    }

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
