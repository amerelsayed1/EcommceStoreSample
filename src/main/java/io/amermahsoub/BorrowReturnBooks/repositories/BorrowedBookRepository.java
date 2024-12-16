package io.amermahsoub.BorrowReturnBooks.repositories;


import io.amermahsoub.BorrowReturnBooks.entities.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    Optional<BorrowedBook> findByBookIdAndReturnDateIsNull(Long bookId);
}
