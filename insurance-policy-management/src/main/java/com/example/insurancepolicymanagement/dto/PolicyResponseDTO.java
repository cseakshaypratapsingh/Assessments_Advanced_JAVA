package com.example.insurancepolicymanagement.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PolicyResponseDTO {

    private Long id;
    private String policyNumber;
    private String policyType;
    private Double premiumAmount;
    private Double coverageAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    private CustomerResponseDTO customer;
}