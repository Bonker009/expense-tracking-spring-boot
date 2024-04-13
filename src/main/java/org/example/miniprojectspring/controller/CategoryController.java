package org.example.miniprojectspring.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categories")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class CategoryController {
    @GetMapping
    public String getCategory() {
        return "get all category";
    }

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable String id) {
        return id;
    }

    @PostMapping
    public String createCategory() {
        return "Post new category";
    }

    @PutMapping("/{id}")
    public String updateCategoryById(@PathVariable String id) {
        return "update category ";
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable String id) {
        return "delete category by id";
    }
}
