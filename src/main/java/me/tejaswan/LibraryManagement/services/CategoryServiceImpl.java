package me.tejaswan.LibraryManagement.services;

import lombok.AllArgsConstructor;
import me.tejaswan.LibraryManagement.entities.Category;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;
import me.tejaswan.LibraryManagement.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository repository;
    @Override
    public List<Category> allCategory() {
        return repository.findAll();
    }

    @Override
    public Category categoryById(UUID id) throws NotFoundException {
        Optional<Category> res = repository.findById(id);
        if(res.isEmpty()){
            throw new NotFoundException("Category Not Found");
        }
        return res.get();
    }

    @Override
    public Category createCategory(Category category) {
        return repository.save(category);
    }

}
