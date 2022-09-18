package com.svj.controller;

import com.svj.dto.CustomerDto;
import com.svj.entity.Customer;
import com.svj.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService= customerService;
    }

    @PostMapping
    public List<Customer> saveCustomers(@RequestBody List<Customer> customers){
        return customerService.addNewCustomers(customers);
    }

    @GetMapping
    public List<CustomerDto> fetchAllCustomers(){
        return customerService.getCustomers();
    }

}
