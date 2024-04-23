package com.riwi.eventsApp.controllers;


import com.riwi.eventsApp.entities.Event;
import com.riwi.eventsApp.services.abastract_service.IEventService;
import jdk.jfr.RecordingState;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/events")
@AllArgsConstructor
public class EventController {

    @Autowired
    private final IEventService EventService;

    @GetMapping
    public ResponseEntity<List<Event >> getAll() {
        return ResponseEntity.ok(this.EventService.getAll());
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
    public ResponseEntity<Event> insert(@RequestBody Event objEvent){
        return ResponseEntity.ok(this.EventService.save(objEvent));
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

