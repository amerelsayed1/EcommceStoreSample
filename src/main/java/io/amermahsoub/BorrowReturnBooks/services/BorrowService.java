package io.amermahsoub.BorrowReturnBooks.services;

import io.amermahsoub.BorrowReturnBooks.entities.Book;
import io.amermahsoub.BorrowReturnBooks.entities.BorrowedBook;
import io.amermahsoub.BorrowReturnBooks.entities.User;
import io.amermahsoub.BorrowReturnBooks.repositories.BookRepository;
import io.amermahsoub.BorrowReturnBooks.repositories.BorrowedBookRepository;
import io.amermahsoub.BorrowReturnBooks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class BorrowService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;


    public String borrowBook(Long bookId, Long userId) {
        Book book = bookRepository.findBookById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));


        User user = userRepository.findUserById(userId).orElseThrow(()->new RuntimeException("User not found"));

        // Create a new BorrowedBook entry
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        borrowedBook.setUser(user);
        borrowedBookRepository.save(borrowedBook);

        // Mark the book as unavailable
        book.setAvailable(false);
        bookRepository.save(book);
        return "Book borrowed successfully!";
    }

    public String returnBook(Long bookId) {
        BorrowedBook borrowedBook = borrowedBookRepository.findByBookIdAndReturnDateIsNull(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        borrowedBook.setReturnDate(LocalDate.now());
        borrowedBookRepository.save(borrowedBook);

        Book book = borrowedBook.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        return "Book returned successfully!";
    }

}
