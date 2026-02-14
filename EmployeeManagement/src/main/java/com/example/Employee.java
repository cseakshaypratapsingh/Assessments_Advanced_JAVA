package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private int id;

    private String name;

    private String email;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private IDCard idCard;

    public Employee(){}

    public Employee(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
