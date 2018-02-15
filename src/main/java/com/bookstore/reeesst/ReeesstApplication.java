package com.bookstore.reeesst;

import com.bookstore.reeesst.enties.Author;
import com.bookstore.reeesst.enties.Book;
import com.bookstore.reeesst.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReeesstApplication implements CommandLineRunner{

	@Autowired
	private BookRepo bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(ReeesstApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Book book = new Book("Pan Tadeusz",new Author("Adam","Mickiewicz"),"0929",25.5,"Jest to książka o panu Tadeuszu");
		bookRepo.save(book);
	}
}
