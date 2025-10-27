package com.example.productapi.service;

import com.example.productapi.model.Category;
import com.example.productapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Category save(Category category) {
        return repo.save(category);
    }
}
