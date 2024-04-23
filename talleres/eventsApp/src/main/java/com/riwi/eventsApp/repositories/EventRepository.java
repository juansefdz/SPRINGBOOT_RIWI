package com.riwi.eventsApp.repositories;

import com.riwi.eventsApp.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository <Event, UUID>{
}
