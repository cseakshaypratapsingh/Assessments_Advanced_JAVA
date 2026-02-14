package com.example;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "idcard")
public class IDCard {

    @Id
    private int id;

    private String cardNumber;

    private LocalDate issueDate;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public IDCard() {}

    public IDCard(int id, String cardNumber, LocalDate issueDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
