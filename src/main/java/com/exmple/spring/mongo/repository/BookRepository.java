package com.exmple.spring.mongo.repository;

import com.exmple.spring.mongo.bean.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
}
