package com.example.insurancepolicymanagement.repository;

import com.example.insurancepolicymanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}