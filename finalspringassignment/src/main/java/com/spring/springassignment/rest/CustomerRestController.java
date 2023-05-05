package com.spring.springassignment.rest;

import com.spring.springassignment.repository.CustomerRepository;
import com.spring.springassignment.repository.ProductRepository;
import com.spring.springassignment.dto.CustomerDto;
import com.spring.springassignment.dto.ProductDto;
import com.spring.springassignment.entity.Customer;
import com.spring.springassignment.entity.Product;
import com.spring.springassignment.exception.NotFoundException;
import com.spring.springassignment.service.CustomerService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//REST API End points for Customer
@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    //saving products and customers
    @PostMapping
    @Transactional
    public Customer saveCustomerWithProducts(@RequestBody Customer theCustomer) {
        productRepository.saveAll(theCustomer.getProducts());
        return customerRepository.save(theCustomer);
    }

    //find all customers - converting to customerDTO
    @GetMapping()
    public List<CustomerDto> findAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            List<ProductDto> productDtos = new ArrayList<>();
            for (Product product : customer.getProducts()) {
                ProductDto productDto = modelMapper.map(product, ProductDto.class);
                productDtos.add(productDto);
            }
            customerDto.setProducts(productDtos);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    //find customer using id  - convert to DTO
    @GetMapping("/{customerId}")
    public CustomerDto findCustomer(@PathVariable int customerId){
        Optional<Customer> theCustomer =  customerRepository.findById(customerId);
        Customer tempCust = null;
        if(theCustomer.isPresent())
            tempCust = theCustomer.get();
        else
            throw new NotFoundException("Customer id not found - " + customerId);
        return modelMapper.map(tempCust, CustomerDto.class);
    }

    //delete customer from database
    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        customerRepository.deleteById(customerId);
        return "Customer with id: "+customerId+" is delted succesfully";
    }

    //assign product(id) to customer(id)
    @PutMapping("/{customerId}/product/{productId}")
    public Customer assignProductToCustomer(
            @PathVariable int customerId,
            @PathVariable int productId
    ){
        return customerService.assignProductToCustomer(customerId,productId);
    }

    //delete product(id) to customer(id)
    @DeleteMapping("/{customerId}/product/{productId}")
    public String deleteProductAssignedToCustomer(@PathVariable int customerId,
                                                  @PathVariable int productId){
        return customerService.deleteProductAssignedToCustomer(customerId,productId);
    }
}
