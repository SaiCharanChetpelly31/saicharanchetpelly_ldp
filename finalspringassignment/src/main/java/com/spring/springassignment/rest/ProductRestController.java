package com.spring.springassignment.rest;

import com.spring.springassignment.repository.ProductRepository;
import com.spring.springassignment.entity.Product;
import com.spring.springassignment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//REST API Endpoints for Product
@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    //get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return  productRepository.findAll();
    }

    //get product by id
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable int productId){
        Optional<Product> theProduct =  productRepository.findById(productId);
        Product tempProd = null;
        if(theProduct.isPresent())
            tempProd = theProduct.get();
        else
            throw new NotFoundException("Product id not found - " + productId);
        return tempProd;
    }

    //save or update product
    @PostMapping
    public Product postProduct(@RequestBody Product theProduct){
        return  productRepository.save(theProduct);
    }

    //delete product by id
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable int productId){
        productRepository.deleteById(productId);
        return "The product with id: "+productId+" is deleted succesfully";
    }
}
