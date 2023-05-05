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
public class ProductTest {
    @Mock
    private Customer customer;

    @InjectMocks
    private Product product;

    @Before
    public void setUp() {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        product.setId(1);
        product.setTitle("Test Product");
        product.setPrice(100);
        product.setCustomers(customers);
    }

    @Test
    public void testGetId() {
        assertEquals(1, product.getId());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Test Product", product.getTitle());
    }

    @Test
    public void testGetPrice() {
        assertEquals(100, product.getPrice());
    }

    @Test
    public void testGetCustomers() {
        when(customer.getUsername()).thenReturn("Test Customer");
        assertEquals("Test Customer", product.getCustomers().get(0).getUsername());
    }

    @Test
    public void testAllArgsConstructor(){
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        Product product1 = new Product(1,"mobile",10000,customers);
        when(customer.getUsername()).thenReturn("Test Customer");
        assertEquals("Test Customer", product.getCustomers().get(0).getUsername());
    }
}
