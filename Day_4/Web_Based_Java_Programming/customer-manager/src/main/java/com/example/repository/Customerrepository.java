package com.example.repository;

import com.model.Customer;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository  extends SimpleJpaRepository<Customer, Long>{

}
