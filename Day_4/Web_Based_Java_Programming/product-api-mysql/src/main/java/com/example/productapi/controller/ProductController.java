package com.example.productapi.controller;

import com.example.productapi.model.Product;
import com.example.productapi.service.ProductService;
import com.example.productapi.service.CategoryService;
import com.example.productapi.model.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    // a) Display all products with category information
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    // b) Insert new product.
    // Expecting JSON payload. If category.id present it will be used, otherwise category.name can be used.
    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {
        // If category is provided with only name, try to find existing category by name
        if (product.getCategory() != null) {
            Category cat = product.getCategory();
            if (cat.getId() == null && cat.getName() != null) {
                Category existing = categoryService.findByName(cat.getName()).orElse(null);
                if (existing != null) {
                    product.setCategory(existing);
                } else {
                    // save new category
                    Category saved = categoryService.save(new Category(cat.getName()));
                    product.setCategory(saved);
                }
            } else if (cat.getId() != null) {
                Category existing = categoryService.findById(cat.getId()).orElse(null);
                if (existing == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category id not found: " + cat.getId());
                }
                product.setCategory(existing);
            }
        }
        Product saved = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // c) Display products having price in the given range.
    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getByPriceRange(@RequestParam("min") BigDecimal min,
                                                         @RequestParam("max") BigDecimal max) {
        List<Product> list = productService.findByPriceRange(min, max);
        return ResponseEntity.ok(list);
    }

    // d) Update product of given product_id with new price.
    @PutMapping("/{id}/price")
    public ResponseEntity<?> updatePrice(@PathVariable("id") Long id,
                                         @RequestParam("price") BigDecimal price) {
        try {
            Product updated = productService.updatePrice(id, price);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // Extra: get single product
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found" + id));
    }
}
