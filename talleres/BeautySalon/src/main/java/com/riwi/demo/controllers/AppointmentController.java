package com.riwi.demo.controllers;

import com.riwi.demo.services.interfaces.IAppointmentService;
import com.riwi.demo.utils.request.AppointmentRequest;
import com.riwi.demo.utils.response.AppointmentResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path = "/appointment")
@AllArgsConstructor
public class AppointmentController {
    @Autowired
    private final IAppointmentService AppointmentService;

    @GetMapping
    public ResponseEntity<Page<IAppointmentService>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(this.AppointmentService.getAll(page - 1, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity <AppointmentResponse> get (
            @PathVariable String id){
        return ResponseEntity.ok(this.AppointmentService.getByID(id));
    }
    @PostMapping
    public ResponseEntity<AppointmentResponse> insert(
            @Validated @RequestBody AppointmentRequest appointment
    ) {
        return ResponseEntity.ok(this.AppointmentService.create(appointment));

    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity <Void> delete (@PathVariable String id){
        this.AppointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<AppointmentResponse> update(
            @PathVariable String id,
            @Validated@RequestBody AppointmentRequest appointment) {

        return ResponseEntity.ok(this.AppointmentService.update(appointment, id));
    }



}
