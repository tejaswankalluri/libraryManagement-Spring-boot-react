package me.tejaswan.LibraryManagement.controllers;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import me.tejaswan.LibraryManagement.entities.Book;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;
import me.tejaswan.LibraryManagement.services.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.UUID;

@Api(tags = "Books")
@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {
    private BookService service;

    @GetMapping
    public List<Book> getBooks(@RequestParam UUID id) throws NotFoundException {
        if (id != null) {
            return Collections.singletonList(service.bookById(id));
        }
        return service.allBooks();
    }

    @GetMapping("/count")
    public ResponseEntity<?> countBooks() {
        Map<String, Long> Res = new HashMap<>();
        Res.put("count", service.countBooks());
        return ResponseEntity.ok(Res);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.createBook(book);
    }
}
