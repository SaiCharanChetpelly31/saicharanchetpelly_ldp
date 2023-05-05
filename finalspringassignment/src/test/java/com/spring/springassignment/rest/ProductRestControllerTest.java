package com.spring.springassignment.rest;

import com.spring.springassignment.repository.ProductRepository;
import com.spring.springassignment.entity.Customer;
import com.spring.springassignment.entity.Product;
import com.spring.springassignment.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRestControllerTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductRestController productRestController;

    @Test
    public void getAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());
        Customer customer = new Customer();
        customer.setProducts(productList);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        when(productRestController.getAllProducts()).thenReturn(productList);
        assertEquals(productList,productRestController.getAllProducts());

    }

    @Test
    public void testGetProduct() {
        Product product = new Product();
        product.setId(1);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        Product result = productRestController.getProduct(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testFindById_NotFound(){
        try {
            productRestController.getProduct(-1);
            fail("Expected CustomerNotFoundException to be thrown");
        } catch (NotFoundException e) {
            assertEquals("Product id not found - -1", e.getMessage());
        }
    }

    @Test
    public void testPostProduct() {
        Product product = new Product();
        product.setTitle("Test Product");
        product.setPrice(10);
        productRestController.postProduct(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testDeleteProduct() {
        int productId = 1;
        productRestController.deleteProduct(productId);
        verify(productRepository, times(1)).deleteById(productId);
    }
}
