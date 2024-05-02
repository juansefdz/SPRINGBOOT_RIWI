package com.riwi.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int employee_id;
    @Column(length = 100)
    private String first_name;
    @Column(length = 100)
    private String last_name;
    @Column(length = 100)
    private String email;
    @Column(length = 100)
    private String phone;
    @Column(length = 50)
    private String role;
}
