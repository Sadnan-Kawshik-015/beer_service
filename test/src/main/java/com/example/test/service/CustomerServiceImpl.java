package com.example.test.service;

import com.example.test.dto.BeerDTO;
import com.example.test.dto.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Kawshik")
                .build();
    }

    @Override
    public CustomerDTO savedNewCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        log.debug("Updating Customer ...");

    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Delete a customer...");

    }
}
