package com.lgb.service;

import com.lgb.dto.CategoryDto;
import com.lgb.entity.Category;
import com.lgb.exception.ResourceNotFoundException;
import com.lgb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public Category updateCategory(Long id, CategoryDto categoryDto) {
        Category category = getCategoryById(id);
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

    public String deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found");
        }
        categoryRepository.deleteById(id);
        return "Category deleted successfully!";
    }

    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }
}
