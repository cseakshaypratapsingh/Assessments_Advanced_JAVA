package com.example.insurancepolicymanagement.controller;

import com.example.insurancepolicymanagement.dto.*;
import com.example.insurancepolicymanagement.service.CustomerService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerResponseDTO createCustomer(@Valid @RequestBody CustomerRequestDTO dto) {

        return service.createCustomer(dto);
    }

    @GetMapping
    public List<CustomerResponseDTO> getCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable Long id) {
        return service.getCustomer(id);
    }
}