package com.example.productapi.service;

import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> findByPriceRange(BigDecimal min, BigDecimal max) {
        return repo.findByPriceRange(min, max);
    }

    @Override
    @Transactional
    public Product updatePrice(Long productId, BigDecimal newPrice) {
        Product p = repo.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));
        p.setPrice(newPrice);
        return repo.save(p);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
