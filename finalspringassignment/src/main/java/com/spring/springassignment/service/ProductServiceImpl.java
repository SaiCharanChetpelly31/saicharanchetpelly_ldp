package com.spring.springassignment.service;

import com.spring.springassignment.entity.Product;
import com.spring.springassignment.repository.ProductRepository;
import com.spring.springassignment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    //get all products
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //get product by id
    @Override
    public Product findById(int theId) {
        Optional<Product> result = productRepository.findById(theId);
        Product theProduct = null;
        if (result.isPresent())
            theProduct = result.get();

        else
            throw new NotFoundException("Product id not found - " + theId);
        return theProduct;
    }

    //save or update product
    @Override
    public void save(Product theProduct) {
        productRepository.save(theProduct);
    }

    //delete product by id
    @Override
    public void deleteById(int theId) {
        productRepository.deleteById(theId);
    }
}
