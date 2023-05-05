package com.spring.springassignment.service;

import com.spring.springassignment.repository.CustomerRepository;
import com.spring.springassignment.repository.ProductRepository;
import com.spring.springassignment.entity.Customer;
import com.spring.springassignment.entity.Product;
import com.spring.springassignment.exception.NotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testConstructor() {
        assertNotNull(customerService);
    }

    @BeforeEach
    public void setUp() {
        passwordEncoder = new BCryptPasswordEncoder();
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
        when(customerService.findAll()).thenReturn(customers);
        assertEquals(customers,customerService.findAll());
    }

    @Test
    public void findById() {
        Customer customer = new Customer();
        customer.setId(1);
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
        Customer result = customerService.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testFindByIdNotFound(){
        int customerId = -1;
        try {
            customerService.findById(customerId);
            fail("Expected CustomerNotFoundException to be thrown");
        } catch (NotFoundException e) {
            assertEquals("Customer id not found - "+customerId, e.getMessage());
        }
    }

    @Test
    public void save() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());
        Customer customer = new Customer();
        customer.setProducts(productList);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customerService.save(customer);

        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void deleteById() {
        int customerId = 1;
        customerService.deleteById(customerId);
        verify(customerRepository).deleteById(customerId);
    }

    @Test
    public void assignProductToCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("saicharan");
        customer.setPassword("pass");
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setId(1);
        product.setTitle("Product 1");
        product.setPrice(10);
        products.add(product);
        customer.setProducts(products);

        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer result = customerService.assignProductToCustomer(1, 1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("saicharan", result.getUsername());
        assertEquals("pass", result.getPassword());
        assertNotNull(result.getProducts());
    }
    @Test
    public void testAssignProdToCustomer_CustomerIdNotFound(){
        int customerId = -1;
        int productId = 1;
        try {
            customerService.assignProductToCustomer(customerId,productId);
            fail("Expected CustomerNotFoundException to be thrown");
        } catch (NotFoundException e) {
            assertEquals("Customer id not found - "+customerId, e.getMessage());
        }
    }

    @Test
    public void deleteProductAssignedToCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("saicharan");
        customer.setPassword("chetpelly");
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setId(1);
        product.setTitle("Product 1");
        product.setPrice(10);
        products.add(product);
        customer.setProducts(products);
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        assertEquals("Deleted product with id: " + product.getId() + " for customer with id: " + customer.getId(),
                customerService.deleteProductAssignedToCustomer(customer.getId(), product.getId()));
    }

    @Test
    public void deleteProductAssignedToCustomer_CustomerNotFound() {
        int customerId = 1;
        int productId = 1;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> customerService.deleteProductAssignedToCustomer(customerId, productId));

        assertEquals("Customer id not found - " + customerId, exception.getMessage());
    }
}

