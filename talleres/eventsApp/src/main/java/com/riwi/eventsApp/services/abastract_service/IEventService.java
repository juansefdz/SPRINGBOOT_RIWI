package com.riwi.eventsApp.services.abastract_service;

import com.riwi.eventsApp.entities.Event;

import java.util.List;
import java.util.UUID;

public interface IEventService {
    public Event save(Event objEvent);

    public List<Event> getAll();

    public Event getById(UUID id);

    public boolean delete(UUID id);

    public Event update(UUID id, Event objEvent);

    List<Event> search(String event);

    Event findById(UUID id);
}
