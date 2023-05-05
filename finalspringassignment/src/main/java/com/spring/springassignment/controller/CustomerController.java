package com.spring.springassignment.controller;

import com.spring.springassignment.entity.Customer;
import com.spring.springassignment.entity.Product;
import com.spring.springassignment.service.CustomerService;
import com.spring.springassignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @PostMapping("/new")
    @ResponseBody
    public String addNewUser(@RequestBody Customer userInfo){
        customerService.addUser(userInfo);
        return "User added to database succesfully";
    }

    //find products in customer's cart
    @GetMapping("/{customerId}/mycart")
    public String findAllCustomerProducts(@PathVariable("customerId") int customerId, Model theModel){
        List<Product> theProducts = customerService.findById(customerId).getProducts();
        theModel.addAttribute("products",theProducts);
        theModel.addAttribute("customerId",customerId);
        return "customers/list-customer-products";
    }

    //delete product already assigned to customer
    @GetMapping("/{customerId}/delete/{productId}")
    public String productDelete(@PathVariable("productId") int theId,@PathVariable("customerId") int customerId) {
        Customer currCustomer = customerService.findById(customerId);
        List<Product> theProducts = currCustomer.getProducts();
        Iterator<Product> iterator = theProducts.iterator();
        while (iterator.hasNext()) {
            Product tempProduct = iterator.next();
            if (tempProduct.getId() == theId) {
                iterator.remove();
            }
        }

        currCustomer.setProducts(theProducts);
        customerService.save(currCustomer);
        return "redirect:/customers/" + customerId+"/mycart";
    }

    //displaying all available products to customer
    @GetMapping("/{customerId}/allproducts")
    public String showAllProductsToCustomer(@PathVariable("customerId") int customerId,Model theModel){
        List<Product> products = productService.findAll();
        theModel.addAttribute("products",products);
        theModel.addAttribute("customerId",customerId);
        return "customers/list-products";
    }

    //adding product into customer's cart
    @GetMapping("/{customerId}/product/{productId}")
    public String assignProductToCustomer(
            @PathVariable int customerId,
            @PathVariable int productId
    ){
        customerService.assignProductToCustomer(customerId,productId);
        return "redirect:/customers/" + customerId+"/allproducts";
    }
}