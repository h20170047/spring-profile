package com.svj.service;

import com.svj.dto.CustomerDto;
import com.svj.entity.Customer;
import com.svj.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile(value = {"dev", "stg", "prod"})
@Slf4j
public class CustomerService {
    private CustomerRepository repository;

    @Value("${application.message}")
    private String message;

    @PostConstruct
    public void init(){
        log.info("************************************************"+message);
    }

    public CustomerService(CustomerRepository repository){
        this.repository= repository;
    }

    public List<Customer> addNewCustomers(List<Customer> customers){
        return repository.saveAll(customers);
    }

    public List<CustomerDto> getCustomers(){
        List<Customer> customers = repository.findAll();
        return customers.stream().map(customer -> new CustomerDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone(), getDateFormat(customer.getDob()) ))
                .collect(Collectors.toList());
    }

    private String getDateFormat(Date date){
        return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }
}
