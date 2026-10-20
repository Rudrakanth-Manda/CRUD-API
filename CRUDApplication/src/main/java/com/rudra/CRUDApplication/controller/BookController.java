package com.rudra.CRUDApplication.controller;

import com.rudra.CRUDApplication.model.Book;
import com.rudra.CRUDApplication.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        try{
            List<Book> bookList = new ArrayList<>();
            bookRepo.findAll().forEach(bookList::add);
            if(bookList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        }catch (Exception ex){
            return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        try {
            Optional<Book> bookData = bookRepo.findById(id);
            if(bookData.isPresent()){
                return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
            Book bookObject = bookRepo.save(book);
            return new ResponseEntity<>(bookObject, HttpStatus.OK);
    }

    @PutMapping("updateBookById/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("id") Long id, @RequestBody Book newBookData) {
        try {
            Optional<Book> oldBookData = bookRepo.findById(id);
            if(oldBookData.isPresent()){
                Book updatedBook = oldBookData.get();
                updatedBook.setTitle(newBookData.getTitle());
                updatedBook.setAuthor(newBookData.getAuthor());
                Book bookObject = bookRepo.save(updatedBook);
                return new ResponseEntity<>(bookObject, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable("id") Long id) {
        bookRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
