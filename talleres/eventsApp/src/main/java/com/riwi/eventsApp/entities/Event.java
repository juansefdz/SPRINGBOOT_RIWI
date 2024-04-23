package com.riwi.eventsApp.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Entity(name="events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;
    private String name; //nombre del evento
    private Date date; //fecha del evento
    private String ubication;
    private int capacity;



}
