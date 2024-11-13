package com.jaoangeloni.newspaper.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jaoangeloni.newspaper.domain.News;
import com.jaoangeloni.newspaper.domain.User;
import com.jaoangeloni.newspaper.dto.AuthorDTO;
import com.jaoangeloni.newspaper.repository.NewsRepository;
import com.jaoangeloni.newspaper.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NewsRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));	
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User weslley = new User(null, "Weslley", "weslley@gmail.com");
		User rafael = new User(null, "Rafael", "rafael@gmail.com");
		User victor = new User(null, "Victor", "victor@gmail.com");
		
		userRepository.saveAll(Arrays.asList(weslley, rafael, victor));
		
		News postWeslley = new News(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(weslley));
		News postRafael = new News(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(rafael));
		News postVictor = new News(null, sdf.parse("25/03/2018"), "Bora estudar", "Partiu facul hoje!", new AuthorDTO(victor));

		postRepository.saveAll(Arrays.asList(postWeslley, postRafael, postVictor)); 
		
		weslley.getPosts().add(postWeslley);
		rafael.getPosts().add(postRafael);
		victor.getPosts().add(postVictor);
		userRepository.saveAll(Arrays.asList(weslley, rafael, victor));
		}
	

}
