package com.riwi.eventsApp.services;


import com.riwi.eventsApp.entities.Event;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {

    @Autowired
    private final EventRepository objEventRepository;

    @Override
    public Event save (Event objEvent){
        return this.objEventRepository.save(objEvent);
    }

    @Override
    public List<Event> getAll(){
        return this.objEventRepository.findAll();
    }
    @Override
    public Event getById(UUID id){
        return this.objEventRepository.findById(id).orElseThrow();
    }
    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public Event update(Event objEvent) {
        return this.objEventRepository.save(objEvent);
    }

}
