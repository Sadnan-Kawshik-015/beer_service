package com.example.test.controller;

import com.example.test.dto.BeerDTO;
import com.example.test.dto.CustomerDTO;
import com.example.test.service.CustomerService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable(name = "customer_id") UUID customerId)
    {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK );

    }
    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody CustomerDTO customerDTO)
    {
        CustomerDTO savedDTO = customerService.savedNewCustomer(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/api/v1/customer"+savedDTO.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{customer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable(name = "customer_id") UUID customerId,@RequestBody CustomerDTO customerDTO)
    {
        customerService.updateCustomer(customerId,customerDTO);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{customer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//returns empty body
    public void deleteCustomer(@PathVariable(name = "customer_id") UUID customerId)
    {
        customerService.deleteById(customerId);
    }



}
