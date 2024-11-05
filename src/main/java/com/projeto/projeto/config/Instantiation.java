package com.projeto.projeto.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projeto.projeto.domain.Post;
import com.projeto.projeto.domain.User;
import com.projeto.projeto.dto.AuthorDTO;
import com.projeto.projeto.repository.PostRepository;
import com.projeto.projeto.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));	
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User gabriel = new User(null, "Gabriel Sales", "gabriel@gmail.com");
		User vini = new User(null, "Vini Bila", "vini@gmail.com");
		User bruna = new User(null, "Bruna Nunes", "bruna@gmail.com");
		
		userRepository.saveAll(Arrays.asList(gabriel, vini, bruna));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(bruna));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(gabriel));

		postRepository.saveAll(Arrays.asList(post1, post2)); 
		
		bruna.getPosts().add(post1);
		gabriel.getPosts().add(post2);
		userRepository.saveAll(Arrays.asList(bruna, gabriel));
		}
	

}
