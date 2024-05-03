package com.riwi.vacant.controllers;

import com.riwi.vacant.services.interfaces.IVacantService;
import com.riwi.vacant.utils.dto.request.VacantRequest;
import com.riwi.vacant.utils.dto.response.VacantResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping (path = "/vacants")
@AllArgsConstructor

public class VacantController {
    @Autowired
    private final IVacantService vacantsService;
    @GetMapping
    public ResponseEntity<Page <VacantResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "7")int size
    ){
        return ResponseEntity.ok(this.vacantsService.getAll(page-1,size));
    }

    @GetMapping (path="/{id}")
    public ResponseEntity <VacantResponse>get(@PathVariable Long id){

        return ResponseEntity.ok(this.vacantsService.getByID(id));
    }
    @PostMapping
    public ResponseEntity<VacantResponse> insert(
            @Validated @RequestBody VacantRequest vacant) {
        return ResponseEntity.ok(this.vacantsService.create(vacant));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity <Map<String,String>>delete(@PathVariable Long id){
        //creamos el mapa
        Map<String,String> response = new HashMap<>();
        //llenamos el mapa
        this.vacantsService.delete(id);
        response.put("message","vacant deleted successfully");

        return ResponseEntity.ok(response);
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity<VacantResponse> update (
            @PathVariable Long id,
            @Validated @RequestBody VacantRequest vacant
    ){
        return ResponseEntity.ok(this.vacantsService.update(vacant,id));
    }
}
