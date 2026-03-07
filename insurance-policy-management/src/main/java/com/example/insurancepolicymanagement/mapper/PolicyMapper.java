package com.example.insurancepolicymanagement.mapper;

import com.example.insurancepolicymanagement.dto.*;
import com.example.insurancepolicymanagement.entity.*;

public class PolicyMapper {

    public static PolicyResponseDTO toDTO(Policy p) {

        CustomerResponseDTO customerDTO =
                CustomerMapper.toDTO(p.getCustomer());

        return new PolicyResponseDTO(
                p.getId(),
                p.getPolicyNumber(),
                p.getPolicyType(),
                p.getPremiumAmount(),
                p.getCoverageAmount(),
                p.getStartDate(),
                p.getEndDate(),
                p.getStatus(),
                customerDTO
        );
    }
}