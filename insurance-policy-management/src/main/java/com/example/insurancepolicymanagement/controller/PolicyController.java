package com.example.insurancepolicymanagement.controller;

import com.example.insurancepolicymanagement.dto.PolicyRequestDTO;
import com.example.insurancepolicymanagement.dto.PolicyResponseDTO;
import com.example.insurancepolicymanagement.service.PolicyService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @PostMapping
    public PolicyResponseDTO createPolicy(@Valid @RequestBody PolicyRequestDTO dto) {
        return service.createPolicy(dto);
    }

    @GetMapping("/{id}")
    public PolicyResponseDTO getPolicyById(@PathVariable Long id) {
        return service.getPolicyById(id);
    }

    @PutMapping("/{id}")
    public PolicyResponseDTO updatePolicy(@PathVariable Long id,
                                          @Valid @RequestBody PolicyRequestDTO dto) {
        return service.updatePolicy(id, dto);
    }

    @DeleteMapping("/{id}")
    public String cancelPolicy(@PathVariable Long id) {
        service.cancelPolicy(id);
        return "Policy cancelled successfully";
    }

    @GetMapping("/type/{type}")
    public List<PolicyResponseDTO> getPoliciesByType(@PathVariable String type) {
        return service.getPoliciesByType(type);
    }

    @GetMapping("/premium")
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(
            @RequestParam double min,
            @RequestParam double max) {

        return service.getPoliciesByPremiumRange(min, max);
    }

    @GetMapping
    public Page<PolicyResponseDTO> getPolicies(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {

        return service.getPolicies(page, size, sortBy, direction);
    }
}