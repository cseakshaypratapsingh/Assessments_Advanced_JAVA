package com.example;

import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("John");
        emp.setEmail("john@example.com");

        IDCard card = new IDCard();
        card.setId(101);
        card.setCardNumber("IDC101");
        card.setIssueDate(LocalDate.now());

        emp.setIdCard(card);
        card.setEmployee(emp);

        em.persist(emp);

        em.getTransaction().commit();

        System.out.println("Employee Created Successfully");

        Employee foundEmp = em.find(Employee.class, 1);

        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + foundEmp.getId());
        System.out.println("Name: " + foundEmp.getName());
        System.out.println("Email: " + foundEmp.getEmail());

        System.out.println("\nID Card Details:");
        System.out.println("Card Number: " + foundEmp.getIdCard().getCardNumber());

        System.out.println("Issue Date: " + foundEmp.getIdCard().getIssueDate());

        IDCard foundCard = em.find(IDCard.class, 101);

        System.out.println("\nEmployee from IDCard:");
        System.out.println("Name: " + foundCard.getEmployee().getName());

        em.close();
        emf.close();
    }
}
