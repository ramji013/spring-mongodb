package com.exmple.spring.mongo.resource;

import com.exmple.spring.mongo.bean.Book;
import com.exmple.spring.mongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody  Book book){
        try {
            bookRepository.save(book);
        }catch (Exception exp){
            exp.printStackTrace();
            return "Exception occurred...";
        }
        return "Added book with id " + book.getId();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/findAllBooks/{id}")
    public Optional<Book> getBookById(@PathVariable int id){
        return bookRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepository.deleteById(id);
        return "Book deleted with the Id : "+ id;
    }

}
