package com.riwi.eventsApp.services;


import com.riwi.eventsApp.entities.Event;
import com.riwi.eventsApp.repositories.EventRepository;
import com.riwi.eventsApp.services.abastract_service.IEventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService implements IEventService{

    @Autowired
    private final EventRepository objEventRepository;

    @Override
    public Event save(Event objEvent){

        if (objEvent.getDate().before(new Date())) {
            throw new IllegalArgumentException("date cannot be earlier than current date");
        }
        if (objEvent.getCapacity() <=0) {
            throw new IllegalArgumentException("The event capacity cannot be less than or equal to 0");
        }
        return this.objEventRepository.save(objEvent);
    }

    @Override
    public Page<Event> getAll(Pageable pageable) {
        return objEventRepository.findAll(pageable);
    }
    @Override
    public Event getById(UUID id){
        return this.objEventRepository.findById(id).orElseThrow();
    }
    @Override
    public boolean delete(UUID id) {
        objEventRepository.deleteById(id);
        return true;
    }

    @Override
    public Event update(UUID id, Event objEvent) {
        return this.objEventRepository.save(objEvent);
    }

    @Override
    public List<Event> search(String event) {
        return List.of();
    }

    @Override
    public Event findById(UUID id) {
        return null;
    }

}
