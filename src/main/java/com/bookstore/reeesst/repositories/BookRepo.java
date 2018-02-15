package com.bookstore.reeesst.repositories;

import com.bookstore.reeesst.enties.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book,String> {
}
