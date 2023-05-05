package com.spring.springassignment.service;

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

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testConstructor() {
        assertNotNull(productService);
    }

    @Test(expected = RuntimeException.class)
    public void testFindByIdFailure() {
        productService.findById(2);
    }

    @Test
    public void findAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());
        Customer customer = new Customer();
        customer.setProducts(productList);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        when(productService.findAll()).thenReturn(productList);
        assertEquals(productList,productService.findAll());
    }

    @Test
    public void findById() {
        Product product = new Product();
        product.setId(1);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        Product result = productService.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void findById_CustomerNotFound() {
        int productId = 1;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> productService.findById(productId));

        assertEquals("Product id not found - " + productId, exception.getMessage());

    }

    @Test
    public void testFindById_NotFound(){
        try {
            productService.findById(-1);
            fail("Expected CustomerNotFoundException to be thrown");
        } catch (NotFoundException e) {
            assertEquals("Product id not found - -1", e.getMessage());
        }
    }

    @Test
    public void testSave() {
        Product product = new Product();
        product.setTitle("Test Product");
        product.setPrice(10);
        productService.save(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testDeleteById() {
        int productId = 1;
        productService.deleteById(productId);
        verify(productRepository, times(1)).deleteById(productId);
    }
}
