package com.spring.springassignment.rest;

import com.spring.springassignment.repository.CustomerRepository;
import com.spring.springassignment.repository.ProductRepository;
import com.spring.springassignment.dto.CustomerDto;
import com.spring.springassignment.dto.ProductDto;
import com.spring.springassignment.entity.Customer;
import com.spring.springassignment.entity.Product;
import com.spring.springassignment.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRestControllerTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerService customerService;

    @Mock
    private static ModelMapper modelMapper;

    @InjectMocks
    private CustomerRestController customerRestController;

    @Before
    public void setUp(){
        modelMapper = new ModelMapper();
    }
    @Test
    public void saveCustomerWithProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());
        Customer customer = new Customer();
        customer.setProducts(productList);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customerRestController.saveCustomerWithProducts(customer);

        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testFindAllCustomers() {
        Product product1 = new Product(1, "Product 1", 10,null);
        Product product2 = new Product(2, "Product 2", 20,null);
        Product product3 = new Product(3, "Product 3", 30,null);

        Customer customer1 = new Customer(1, "User 1", "pwd1", "ROLE_USER", Arrays.asList(product1, product2));
        Customer customer2 = new Customer(2, "User 2", "pwd2", "ROLE_ADMIN", Arrays.asList(product2, product3));
        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDto> actual = customerRestController.findAllCustomers();

        assertEquals(2, actual.size());

        CustomerDto actualCustomer1 = actual.get(0);
        assertEquals(customer1.getId(), actualCustomer1.getId());
        assertEquals(customer1.getUsername(), actualCustomer1.getUsername());
        assertEquals(customer1.getRole(), actualCustomer1.getRole());
        assertEquals(2, actualCustomer1.getProducts().size());

        ProductDto actualProduct1 = actualCustomer1.getProducts().get(0);
        assertEquals(product1.getId(), actualProduct1.getId());
        assertEquals(product1.getTitle(), actualProduct1.getTitle());
        assertEquals(product1.getPrice(), actualProduct1.getPrice());

        ProductDto actualProduct2 = actualCustomer1.getProducts().get(1);
        assertEquals(product2.getId(), actualProduct2.getId());
        assertEquals(product2.getTitle(), actualProduct2.getTitle());
        assertEquals(product2.getPrice(), actualProduct2.getPrice());

        CustomerDto actualCustomer2 = actual.get(1);
        assertEquals(customer2.getId(), actualCustomer2.getId());
        assertEquals(customer2.getUsername(), actualCustomer2.getUsername());
        assertEquals(customer2.getRole(), actualCustomer2.getRole());
        assertEquals(2, actualCustomer2.getProducts().size());

        ProductDto actualProduct3 = actualCustomer2.getProducts().get(0);
        assertEquals(product2.getId(), actualProduct3.getId());
        assertEquals(product2.getTitle(), actualProduct3.getTitle());
        assertEquals(product2.getPrice(), actualProduct3.getPrice());

        ProductDto actualProduct4 = actualCustomer2.getProducts().get(1);
        assertEquals(product3.getId(), actualProduct4.getId());
        assertEquals(product3.getTitle(), actualProduct4.getTitle());
        assertEquals(product3.getPrice(), actualProduct4.getPrice());
    }

    @Test
    public void findCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
        CustomerDto result = customerRestController.findCustomer(1);
        assertEquals(1, result.getId());
    }

    @Test(expected = RuntimeException.class)
    public void findCustomerNotFound() {
        customerRestController.findCustomer(-1);
    }
    @Test
    public void deleteCustomer() {
        int customerId = 1;
        String expected = customerRestController.deleteCustomer(customerId);
        String actual = "Customer with id: "+customerId+" is delted succesfully";
        verify(customerRepository).deleteById(customerId);
        assertEquals(expected,actual);

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
        when(customerRepository.save(ArgumentMatchers.any(Customer.class))).thenReturn(customer);

        Customer result = customerRestController.assignProductToCustomer(1, 1);

        assertNull(result);
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

        assertEquals(null,
                customerRestController.deleteProductAssignedToCustomer(customer.getId(), product.getId()));

    }
}
