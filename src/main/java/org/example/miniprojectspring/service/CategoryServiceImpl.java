package org.example.miniprojectspring.service;

import org.example.miniprojectspring.model.entity.Category;
import org.example.miniprojectspring.model.request.CategoryRequest;
import org.example.miniprojectspring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public Category getCategoryById(UUID categoryId) {
        return categoryRepository.getCategoryById(categoryId);
    }

    @Override
    public Category deleteCategoryById(UUID categoryId) {
        return categoryRepository.deleteCategoryById(categoryId);
    }

    @Override
    public Category updateCategoryById(UUID categoryId, CategoryRequest request) {
        return categoryRepository.updateCategoryById(categoryId,request);
    }

    @Override
    public Category postCategory(CategoryRequest request) {
        return categoryRepository.createNewCategory(request);
    }
}
