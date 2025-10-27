package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService{

	
	 private final CustomerRepository repo;

	    public CustomerServiceImpl(CustomerRepository repo) {
	        this.repo = repo;
	    }
	    
	    
	@Override
	public List<Customer> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Customer save(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
