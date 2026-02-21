package com.example.ordermanagement.config;

import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional   // THIS IS THE CRITICAL FIX
    public void run(String... args) throws Exception {

        System.out.println("===== Loading Customers and Orders =====");

        // Fetch all customers from database
        Iterable<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {

            // Print customer info
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Customer Name: " + customer.getCustomerName());
            System.out.println("Customer Email: " + customer.getEmail());

            System.out.println("Orders:");

            // This will now work because session is open
            for (Order order : customer.getOrders()) {

                System.out.println("   Order ID: " + order.getOrderId());
                System.out.println("   Order Date: " + order.getOrderDate());
                System.out.println("   Total Amount: " + order.getTotalAmount());

                System.out.println("------------------------");
            }

            System.out.println("=============================");
        }
    }
}