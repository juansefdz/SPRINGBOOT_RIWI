package com.riwi.demo.controllers;

import com.riwi.demo.services.interfaces.IClientService;
import com.riwi.demo.services.interfaces.IEmployeService;
import com.riwi.demo.utils.request.AppointmentRequest;
import com.riwi.demo.utils.request.EmployeeRequest;
import com.riwi.demo.utils.response.AppointmentResponse;
import com.riwi.demo.utils.response.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private final IEmployeService EmployeeService;



    @GetMapping
    public ResponseEntity<Page<IEmployeService>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(this.EmployeeService.getAll(page - 1, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity <EmployeeResponse> get (
            @PathVariable String id){
        return ResponseEntity.ok(this.EmployeeService.getByID(id));
    }
    @PostMapping
    public ResponseEntity<EmployeeResponse> insert(
            @Validated @RequestBody EmployeeRequest employee
    ) {
        return ResponseEntity.ok(this.EmployeeService.create(employee));

    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity <Void> delete (@PathVariable String id){
        this.EmployeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<AppointmentResponse> update(
            @PathVariable String id,
            @Validated@RequestBody AppointmentRequest employee) {

        return ResponseEntity.ok(this.EmployeeService.update(employee, id));
    }
}
