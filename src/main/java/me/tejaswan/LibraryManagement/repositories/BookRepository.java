package me.tejaswan.LibraryManagement.repositories;

import me.tejaswan.LibraryManagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book,UUID> {
}
