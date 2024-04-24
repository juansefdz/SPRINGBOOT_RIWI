package com.riwi.eventsApp.services.abastract_service;

import com.riwi.eventsApp.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IEventService {
    public Event save(Event objEvent);

    Page<Event> getAll(Pageable pageable);

    public Event getById(UUID id);

    public boolean delete(UUID id);

    public Event update(UUID id, Event objEvent);

    List<Event> search(String event);

    Event findById(UUID id);
}
