package com.example.productapi.service;

import com.example.productapi.model.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    List<Product> findByPriceRange(BigDecimal min, BigDecimal max);
    Product updatePrice(Long productId, BigDecimal newPrice);
    void deleteById(Long id);
}
