package com.spring.springassignment.controller;

import com.spring.springassignment.entity.Customer;
import com.spring.springassignment.entity.Product;
import com.spring.springassignment.service.CustomerService;
import com.spring.springassignment.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {
    @Mock
    private CustomerService customerService;
    @Mock
    private ProductService productService;
    @Mock
    private Model model;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void testAddNewUser() {
        Customer customer = new Customer();
        customer.setUsername("sai");
        customer.setPassword("test123");
        customer.setRole("ROLE_USER");
        doNothing().when(customerService).addUser(customer);
        String result = customerController.addNewUser(customer);
        verify(customerService, times(1)).addUser(customer);
        assertEquals("User added to database succesfully", result);
    }

    @Test
    public void testFIndAllProductsForCustomers() {
        int customerId = 1;
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());
        Customer customer = new Customer();
        customer.setProducts(productList);
        when(customerService.findById(customerId)).thenReturn(customer);
        String view = customerController.findAllCustomerProducts(customerId, model);
        verify(model).addAttribute("products", productList);
        verify(model).addAttribute("customerId", customerId);
        assertEquals("customers/list-customer-products", view);
    }

    @Test
    public void testProductDelete() {
        int productId = 1;
        int customerId = 1;

        Product product1 = new Product();
        product1.setId(productId);
        Product product2 = new Product();
        product2.setId(2);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setProducts(products);
        when(customerService.findById(customerId)).thenReturn(customer);
        String viewName = customerController.productDelete(productId, customerId);
        verify(customerService).save(customer);
        assertEquals("redirect:/customers/" + customerId + "/mycart", viewName);
        assertEquals(1, customer.getProducts().size());
        assertEquals(product2, customer.getProducts().get(0));
    }

    @Test
    public void testShowAllProductsToCustomer() {
        int customerId = 1;
        List<Product> products = new ArrayList<Product>();
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer(1,"saicharan","pass","admin",products);
        customers.add(customer);
        products.add(new Product(1, "Product 1",1000,customers));
        products.add(new Product(2, "Product 2",100,customers));
        products.add(new Product(3, "Product 3",200,customers));
        when(productService.findAll()).thenReturn(products);
        String viewName = customerController.showAllProductsToCustomer(customerId, model);
        assertEquals("customers/list-products", viewName);
        verify(model).addAttribute("products", products);
        verify(model).addAttribute("customerId", customerId);
        verify(productService).findAll();
    }

    @Test
    public void testAssignProductToCustomer() {
        int customerId = 1;
        int productId = 2;
        String expectedUrl = "redirect:/customers/" + customerId + "/allproducts";
        String actualUrl = customerController.assignProductToCustomer(customerId, productId);
        verify(customerService).assignProductToCustomer(customerId, productId);
        assertEquals(expectedUrl, actualUrl);
    }
}
