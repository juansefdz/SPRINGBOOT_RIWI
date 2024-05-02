package com.riwi.demo.controllers;


import com.riwi.demo.services.interfaces.IClientService;
import com.riwi.demo.utils.request.AppointmentRequest;
import com.riwi.demo.utils.response.AppointmentResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/client")
@AllArgsConstructor
public class ClientController {

    @Autowired
    private final IClientService ClientService;

    @GetMapping
    public ResponseEntity<Page<IClientService>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(this.ClientService.getAll(page - 1, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity <AppointmentResponse> get (
            @PathVariable String id){
        return ResponseEntity.ok(this.ClientService.getByID(id));
    }
    @PostMapping
    public ResponseEntity<AppointmentResponse> insert(
            @Validated @RequestBody AppointmentRequest client
    ) {
        return ResponseEntity.ok(this.ClientService.create(client));

    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity <Void> delete (@PathVariable String id){
        this.ClientService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<AppointmentResponse> update(
            @PathVariable String id,
            @Validated@RequestBody AppointmentRequest client) {

        return ResponseEntity.ok(this.ClientService.update(client, id));
    }
}
