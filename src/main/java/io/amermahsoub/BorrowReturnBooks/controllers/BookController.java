package io.amermahsoub.BorrowReturnBooks.controllers;

import io.amermahsoub.BorrowReturnBooks.entities.Book;
import io.amermahsoub.BorrowReturnBooks.services.BookService;
import io.amermahsoub.BorrowReturnBooks.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    ResponseEntity<List<Book>> getAllBooks() {
        List<Book> createdBook = bookService.getBooks();
        return ResponseEntity.status(200).body(createdBook);
    }
}
