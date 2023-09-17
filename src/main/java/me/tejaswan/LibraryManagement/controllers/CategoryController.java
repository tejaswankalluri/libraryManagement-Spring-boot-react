package me.tejaswan.LibraryManagement.controllers;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import me.tejaswan.LibraryManagement.entities.Category;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;
import me.tejaswan.LibraryManagement.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Api(tags = "Category")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    CategoryService service;

    @GetMapping
    public List<Category> getAllCategory(@RequestParam(required = false) UUID id) throws NotFoundException {
        if (id != null) {
            return Collections.singletonList(service.categoryById(id));
        }
        return service.allCategory();
    }

    @PostMapping
    public Category postCategory(@RequestBody Category category) {
        return service.createCategory(category);
    }
}
