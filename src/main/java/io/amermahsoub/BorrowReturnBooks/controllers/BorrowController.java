package io.amermahsoub.BorrowReturnBooks.controllers;

import io.amermahsoub.BorrowReturnBooks.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestParam Long bookId, @RequestParam Long userId) {
        String message = borrowService.borrowBook(bookId, userId);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestParam Long bookId) {
        String message = borrowService.returnBook(bookId);
        return ResponseEntity.ok(message);
    }

}
