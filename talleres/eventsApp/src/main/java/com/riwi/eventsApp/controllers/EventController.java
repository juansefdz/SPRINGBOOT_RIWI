package com.riwi.eventsApp.controllers;


import com.riwi.eventsApp.services.abastract_service.IEventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/events")
@AllArgsConstructor
public class EventController {

    @Autowired
    private final IEventService objIEventService;


}
