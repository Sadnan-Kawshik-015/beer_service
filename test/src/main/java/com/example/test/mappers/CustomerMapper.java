package com.example.test.mappers;

import com.example.test.dto.BeerDTO;
import com.example.test.dto.CustomerDTO;
import com.example.test.model.Beer;
import com.example.test.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
