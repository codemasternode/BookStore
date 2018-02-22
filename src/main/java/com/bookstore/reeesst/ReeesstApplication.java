package com.bookstore.reeesst;

import com.bookstore.reeesst.enties.*;
import com.bookstore.reeesst.repositories.BookRepo;
import com.bookstore.reeesst.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ReeesstApplication implements CommandLineRunner{

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ReeesstApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... strings) throws Exception {
		mongoTemplate.getDb().dropDatabase();
		String st1 = "Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse a pellentesque dui, non felis. Maecenas malesuada elit lectus felis, malesuada ultricies. Curabitur et ligula. Ut molestie a, ultricies porta urna. Vestibulum commodo volutpat a, convallis ac, laoreet enim. Phasellus fermentum in, dolor. Pellentesque facilisis. Nulla imperdiet sit amet magna. Vestibulum dapibus, mauris nec malesuada fames ac turpis velit, rhoncus eu, luctus et interdum adipiscing wisi.  ";
		String st2 = "Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse a pellentesque dui, non felis. Maecenas malesuada elit lectus felis, malesuada ultricies. Curabitur et ligula. Ut molestie a, ultricies porta urna. Vestibulum commodo volutpat a, convallis ac, laoreet enim. Phasellus fermentum in, dolor. Pellentesque facilisis. Nulla imperdiet sit amet magna. Vestibulum dapibus, mauris nec malesuada fames ac turpis velit, rhoncus eu, luctus et interdum adipiscing wisi. ";
		User us1 = new User("Marcin","mar","mw@interia.pl");
		User us2 = new User("nap","mma","kubicz@gmail.com");
		userRepo.save(us1);
		userRepo.save(us2);
		Comment com1 = new Comment(us1,"Super partia", Mark.Good);
		Comment com2 = new Comment(us2,"taka średnia", Mark.Good);
		List<Comment> commentList = new ArrayList<>();
		commentList.add(com1);
		commentList.add(com2);
		Book book = new Book("Pan Tadeusz",new Author("Adam","Mickiewicz"),"0929",25.5,st1,"http://ecsmedia.pl/c/pan-tadeusz-b-iext44008692.jpg",commentList);
		Book book2 = new Book("Krzyżacy",new Author("Henryk","Sienkiewicz"),"0879",32.0,st2,"http://ecsmedia.pl/c/krzyzacy-b-iext38925527.jpg",commentList);
		bookRepo.save(book);
		bookRepo.save(book2);
	}

}
