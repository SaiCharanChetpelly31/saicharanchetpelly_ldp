package com.spring.springassignment.repository;

import com.spring.springassignment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    //to find Customer by username
    Optional<Customer> findByUsername(String username);
}
