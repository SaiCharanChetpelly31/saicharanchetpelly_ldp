package com.spring.springassignment.service;

import com.spring.springassignment.repository.CustomerRepository;
import com.spring.springassignment.repository.ProductRepository;
import com.spring.springassignment.entity.Customer;
import com.spring.springassignment.entity.Product;
import com.spring.springassignment.exception.NotFoundException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
@NoArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    //constants
    private static final String CUSTOMERNOTFOUNDMSG = "Customer id not found - ";
    private static final String PRODUCTNOTFOUNDMSG = "Product id not found - ";

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //getting customer by id
    @Override
    public Customer findById(int theId) {
        Optional<Customer> theCustomer =  customerRepository.findById(theId);
        Customer tempCustomer = null;
        if(theCustomer.isPresent())
            tempCustomer = theCustomer.get();
        else
            throw new NotFoundException(CUSTOMERNOTFOUNDMSG + theId);
        return tempCustomer;
    }

    //save or update customer
    @Override
    public void save(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    //delete customer by id
    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }

    //assign a product(id) to customer(id)
    @Override
    public Customer assignProductToCustomer(int customerId, int productId) {
        List<Product> productSet = null;
        Optional<Customer> customer =  customerRepository.findById(customerId);
        Customer tempCust = null;
        if(customer.isPresent())
            tempCust = customer.get();
        else
            throw new NotFoundException(CUSTOMERNOTFOUNDMSG + customerId);
        Optional<Product> product =  productRepository.findById(productId);
        Product tempProduct = null;
        if(product.isPresent())
            tempProduct = product.get();
        else
            throw new NotFoundException(PRODUCTNOTFOUNDMSG+ productId);
        productSet =  tempCust.getProducts();
        productSet.add(tempProduct);
        tempCust.setProducts(productSet);
        return customerRepository.save(tempCust);
    }

    //deleting product(id) already assigned to customer(id)
    @Override
    public String deleteProductAssignedToCustomer(int customerId, int productId) {
        List<Product> productSet = null;
        Optional<Customer> customer =  customerRepository.findById(customerId);
        Customer tempCust = null;
        if(customer.isPresent())
            tempCust = customer.get();
        else
            throw new NotFoundException(CUSTOMERNOTFOUNDMSG+ customerId);
        Optional<Product> product = productRepository.findById(productId);
        Product theProduct = null;
        if(product.isPresent())
            theProduct=product.get();
        else
            throw new NotFoundException(PRODUCTNOTFOUNDMSG + productId);
        productSet =  tempCust.getProducts();
        if(!productSet.isEmpty()){
            productSet.remove(theProduct);
        }
        tempCust.setProducts(productSet);
        customerRepository.save(tempCust);
        return "Deleted product with id: "+productId+" for customer with id: "+customerId;
    }

    //adding user to database
    @Override
    public void addUser(Customer userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        customerRepository.save(userInfo);
    }
}
