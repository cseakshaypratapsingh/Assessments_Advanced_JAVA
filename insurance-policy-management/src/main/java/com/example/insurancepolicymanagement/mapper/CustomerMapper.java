package com.example.insurancepolicymanagement.mapper;

import com.example.insurancepolicymanagement.dto.*;
import com.example.insurancepolicymanagement.entity.Customer;

public class CustomerMapper {

    public static Customer toEntity(CustomerRequestDTO dto) {

        Customer c = new Customer();

        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        c.setPhoneNumber(dto.getPhoneNumber());
        c.setAddress(dto.getAddress());

        return c;
    }

    public static CustomerResponseDTO toDTO(Customer c) {

        return new CustomerResponseDTO(
                c.getId(),
                c.getName(),
                c.getEmail(),
                c.getPhoneNumber(),
                c.getAddress()
        );
    }
}