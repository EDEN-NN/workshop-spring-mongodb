package com.walison.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.walison.workshopmongo.domain.Post;
import com.walison.workshopmongo.domain.User;
import com.walison.workshopmongo.repository.PostRepository;
import com.walison.workshopmongo.repository.UserRepository;

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
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		postRepository.deleteAll();
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Viajando pra SP!", maria);
		Post post2 = new Post(null, sdf.parse("23/05/2018"), "Acordando!", "Bom dia!", maria);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
