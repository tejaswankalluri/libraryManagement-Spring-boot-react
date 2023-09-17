package me.tejaswan.LibraryManagement.services;

import lombok.AllArgsConstructor;
import me.tejaswan.LibraryManagement.entities.Book;
import me.tejaswan.LibraryManagement.entities.Category;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;
import me.tejaswan.LibraryManagement.repositories.BookRepository;
import me.tejaswan.LibraryManagement.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Book> allBooks() {
        return repository.findAll();
    }

    @Override
    public Book bookById(UUID id) throws NotFoundException {
        Optional<Book> res = repository.findById(id);
        if (res.isEmpty()) {
            throw new NotFoundException("Book Not Found");
        }
        return res.get();
    }

    @Override
    public Book createBook(Book book) {
        List<Category> categories = new ArrayList<>();
        for (Category categoryRequest : book.getCategories()) {
            Category category;
            if (categoryRequest.getId() != null)
                category = categoryRepository.findById(categoryRequest.getId())
                        .orElse(null);
            else {
                category = categoryRepository.save(categoryRequest);
            }
            categories.add(category);
        }
        book.setCategories(categories);
        return repository.save(book);
    }

    @Override
    public long countBooks() {
        return repository.count();
    }
}
