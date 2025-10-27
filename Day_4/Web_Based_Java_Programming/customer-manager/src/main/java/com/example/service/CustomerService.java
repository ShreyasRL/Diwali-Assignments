package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Customer;

public interface CustomerService {
	List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    void deleteById(Long id);
}
