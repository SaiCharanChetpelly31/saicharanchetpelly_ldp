package com.spring.springassignment.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
    @Mock
    private Product product;
    @InjectMocks
    private Customer customer;

    @Before
    public void setUp() {
        List<Product> products = new ArrayList<>();
        products.add(product);
        customer.setId(1);
        customer.setUsername("Test name");
        customer.setPassword("pass");
        customer.setRole("USER");
        customer.setProducts(products);
    }

    @Test
    public void testGetId() {
        assertEquals(1, customer.getId());
    }

    @Test
    public void testGetUsername() {
        assertEquals("Test name", customer.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("pass", customer.getPassword());
    }

    @Test
    public void testGetRole() {
        assertEquals("USER", customer.getRole());
    }

    @Test
    public void testGetProducts() {
        when(product.getTitle()).thenReturn("Test Product");
        assertEquals("Test Product", customer.getProducts().get(0).getTitle());
    }

    @Test
    public void testAllArgsConstructor(){
        List<Product> products = new ArrayList<>();
        products.add(product);
        Customer customer1 = new Customer(1,"Test name","pass","USER",products);
        when(product.getTitle()).thenReturn("Test Product");
        assertEquals("Test Product", customer.getProducts().get(0).getTitle());
    }
}
