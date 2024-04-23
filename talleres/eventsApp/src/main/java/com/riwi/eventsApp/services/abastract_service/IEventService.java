package com.riwi.eventsApp.services.abastract_service;

import com.riwi.eventsApp.entities.Event;

import java.util.List;

public interface IEventService {
    public Event save(Event objEvent);

    public List<Event> getAll();

    public Event getById(Long id);

    public boolean delete(Long id);

    public Event update(Event objEvent);
}
