package com.example.multiTenancy.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;

    private String firstName;

    private String lastName;

    private Long age;

    private String country;
}