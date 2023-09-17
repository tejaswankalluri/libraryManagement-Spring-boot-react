package me.tejaswan.LibraryManagement.services;

import me.tejaswan.LibraryManagement.entities.Category;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
   List<Category> allCategory();
   Category categoryById(UUID id) throws NotFoundException;
   Category createCategory(Category category);
}
