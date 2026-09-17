package com.educandoweb.course.service;


import com.educandoweb.course.model.Category;
import com.educandoweb.course.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
