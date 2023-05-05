package com.spring.springassignment.controller;

import com.spring.springassignment.repository.CustomerRepository;
import com.spring.springassignment.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoControllerTest {
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private Model theModel;
    @Mock
    private Authentication authentication;

    @Mock
    private Model model;
    @Mock
    private DemoController demoController;

    @Before
    public void setUp() {
        demoController = new DemoController();
        when(authentication.getName()).thenReturn("testuser");
        MockitoAnnotations.openMocks(this);
        demoController = new DemoController();
        demoController.customerRepository = customerRepository;
    }

    @Test
    public void accessDeniedPage() {
        String result = demoController.accessDeniedPage();
        assertEquals("access-denied", result);
    }

    @Test
    public void testLoginHomePage() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("testuser");
        when(authentication.getName()).thenReturn("testuser");
        when(customerRepository.findByUsername("testuser")).thenReturn(Optional.of(customer));
        String result = demoController.loginHomePage(authentication, model);
        assertEquals("index", result);
    }
}
