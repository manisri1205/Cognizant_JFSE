package com.book.bookstoreapi.controller;

import com.book.bookstoreapi.dto.CustomerDTO;
import com.book.bookstoreapi.mapper.CustomerMapper;
import com.book.bookstoreapi.model.Customer;
import com.book.bookstoreapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(customerMapper.toDTO(savedCustomer), HttpStatus.CREATED);
    }

    @PostMapping(path = "/register", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<CustomerDTO> registerCustomer(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("address") String address) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(name);
        customerDTO.setEmail(email);
        customerDTO.setAddress(address);

        Customer customer = customerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(customerMapper.toDTO(savedCustomer), HttpStatus.CREATED);
    }
}
