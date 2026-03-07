package com.example.insurancepolicymanagement.service;

import com.example.insurancepolicymanagement.dto.PolicyRequestDTO;
import com.example.insurancepolicymanagement.dto.PolicyResponseDTO;
import com.example.insurancepolicymanagement.entity.Customer;
import com.example.insurancepolicymanagement.entity.Policy;
import com.example.insurancepolicymanagement.exception.CustomerNotFoundException;
import com.example.insurancepolicymanagement.exception.PolicyNotFoundException;
import com.example.insurancepolicymanagement.mapper.PolicyMapper;
import com.example.insurancepolicymanagement.repository.CustomerRepository;
import com.example.insurancepolicymanagement.repository.PolicyRepository;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;
    private final CustomerRepository customerRepository;

    public PolicyService(PolicyRepository policyRepository,
                         CustomerRepository customerRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
    }

    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        Policy policy = new Policy();

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setStatus("ACTIVE");
        policy.setCustomer(customer);

        policyRepository.save(policy);

        return PolicyMapper.toDTO(policy);
    }

    public PolicyResponseDTO getPolicyById(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        return PolicyMapper.toDTO(policy);
    }

    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        policyRepository.save(policy);

        return PolicyMapper.toDTO(policy);
    }

    public void cancelPolicy(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        policy.setStatus("CANCELLED");

        policyRepository.save(policy);
    }

    public List<PolicyResponseDTO> getPoliciesByType(String type) {

        return policyRepository.findByPolicyType(type)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max) {

        return policyRepository.findByPremiumAmountBetween(min, max)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Page<PolicyResponseDTO> getPolicies(int page,
                                               int size,
                                               String sortBy,
                                               String direction) {

        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return policyRepository.findAll(pageable)
                .map(PolicyMapper::toDTO);
    }
}