package com.spring.springassignment.service;

import com.spring.springassignment.entity.Customer;
import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();
    public Customer findById(int theId);
    public void save(Customer theCustomer);
    public void deleteById(int theId);
    public Customer assignProductToCustomer(int customerId,int productId);
    public String deleteProductAssignedToCustomer(int customerId, int productId);
    void addUser(Customer userInfo);
}
