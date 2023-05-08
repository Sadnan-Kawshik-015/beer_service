package com.example.test.service;

import com.example.test.dto.BeerDTO;
import com.example.test.dto.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);


    CustomerDTO savedNewCustomer(CustomerDTO customerDTO);

    void updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteById(UUID customerId);
}
