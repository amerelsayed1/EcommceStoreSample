package io.amermahsoub.BorrowReturnBooks.repositories;

import io.amermahsoub.BorrowReturnBooks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long userId);

}
