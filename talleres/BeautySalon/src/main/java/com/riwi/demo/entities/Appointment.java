package com.riwi.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity(name="appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointment_id;
    private int client_id;
    private int employee_id;
    private int service_id;
    private Date date_time;
    private int duration;
    @Column(columnDefinition = "TEXT")
    private String comments;
}
