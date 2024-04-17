package org.example.miniprojectspring.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.miniprojectspring.model.entity.Category;
import org.example.miniprojectspring.model.request.CategoryRequest;

import java.util.List;
import java.util.UUID;

@Mapper
public interface CategoryRepository {

    List<Category> getAllCategories();

    Category getCategoryById(UUID categoryId);

    Category deleteCategoryById(UUID categoryId);

    Category updateCategoryById(UUID categoryId, CategoryRequest request);

    Category createNewCategory(CategoryRequest request);
}
