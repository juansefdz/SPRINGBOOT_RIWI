package com.riwi.eventsApp.controllers;


import com.riwi.eventsApp.entities.Event;
import com.riwi.eventsApp.services.abastract_service.IEventService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/events")
@AllArgsConstructor
public class EventController {

    @Autowired
    private IEventService EventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "2") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventPage = EventService.getAll(pageable);
        return ResponseEntity.ok(eventPage.getContent());
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> get(@PathVariable UUID id) {
        return ResponseEntity.ok(this.EventService.findById(id));
    }


    @GetMapping(path = "/search")
    public ResponseEntity<List<Event>> get(@RequestParam String event) {
        return ResponseEntity.ok(this.EventService.search(event));

    }

    @PostMapping
    public Event insert(@RequestBody Event objEvent) {

        return  this.EventService.save(objEvent);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(
            @PathVariable UUID id,
            @RequestBody Event event)
    {
        return ResponseEntity.ok(this.EventService.update(id, event));

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.EventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

