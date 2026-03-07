package com.example.insurancepolicymanagement.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PolicyRequestDTO {

    @NotBlank(message = "Policy number cannot be empty")
    private String policyNumber;

    @NotBlank(message = "Policy type cannot be empty")
    private String policyType;

    @Positive(message = "Premium amount must be positive")
    private Double premiumAmount;

    @Positive(message = "Coverage amount must be positive")
    private Double coverageAmount;

    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null")
    private LocalDate endDate;

    @NotNull(message = "Customer ID must be provided")
    private Long customerId;
}