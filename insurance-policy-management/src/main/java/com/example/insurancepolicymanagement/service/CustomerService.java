package com.example.insurancepolicymanagement.service;

import com.example.insurancepolicymanagement.dto.*;
import com.example.insurancepolicymanagement.entity.Customer;
import com.example.insurancepolicymanagement.mapper.CustomerMapper;
import com.example.insurancepolicymanagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {

        Customer c = CustomerMapper.toEntity(dto);

        repository.save(c);

        return CustomerMapper.toDTO(c);
    }

    public List<CustomerResponseDTO> getAllCustomers() {

        return repository.findAll()
                .stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO getCustomer(Long id) {

        Customer c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return CustomerMapper.toDTO(c);
    }
}