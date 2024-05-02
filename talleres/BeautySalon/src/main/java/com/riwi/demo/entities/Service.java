package com.riwi.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;

    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column (precision = 10,scale = 2)
    private long price;
}
