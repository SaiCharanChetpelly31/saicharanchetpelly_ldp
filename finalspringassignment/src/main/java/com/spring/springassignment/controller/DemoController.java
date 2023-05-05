package com.spring.springassignment.controller;

import com.spring.springassignment.repository.CustomerRepository;
import com.spring.springassignment.entity.Customer;
import com.spring.springassignment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class DemoController {
    private static final String CUSTOMERNOTFOUNDMSG = "Customer id not found - " ;
    @Autowired
    public CustomerRepository customerRepository;

    //access-denied page for unauthorized roles
    @GetMapping("/access-denied")
    public String accessDeniedPage(){
        return "access-denied";
    }

    @GetMapping("/loginSuccess")
    public String loginHomePage(Authentication authentication, Model theModel){
        String username = authentication.getName();
        Optional<Customer> customer = customerRepository.findByUsername(username);
        Customer tempCust = null;
        int id = 0;
        if(customer.isPresent()){
            tempCust = customer.get();
            id = tempCust.getId();
        }
        else
            throw new NotFoundException(CUSTOMERNOTFOUNDMSG+ username);
        theModel.addAttribute("customerId",id);
        return "index";
    }
}
