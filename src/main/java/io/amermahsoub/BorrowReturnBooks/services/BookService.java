package io.amermahsoub.BorrowReturnBooks.services;

import io.amermahsoub.BorrowReturnBooks.entities.Book;
import io.amermahsoub.BorrowReturnBooks.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
