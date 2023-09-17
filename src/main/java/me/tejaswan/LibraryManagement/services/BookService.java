package me.tejaswan.LibraryManagement.services;

import me.tejaswan.LibraryManagement.entities.Book;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Book> allBooks();

    Book bookById(UUID id) throws NotFoundException;

    Book createBook(Book book);

    long countBooks();
}
