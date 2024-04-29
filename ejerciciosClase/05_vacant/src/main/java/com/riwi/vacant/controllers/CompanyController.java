package com.riwi.vacant.controllers;

import com.riwi.vacant.services.interfaces.ICompanyService;
import com.riwi.vacant.utils.dto.request.CompanyRequest;
import com.riwi.vacant.utils.dto.response.CompanyResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/company")
@AllArgsConstructor
public class CompanyController {

    @Autowired
    private final ICompanyService CompanyService;

    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(this.CompanyService.getAll(page - 1, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity <CompanyResponse> get (
            @PathVariable String id){
        return ResponseEntity.ok(this.CompanyService.getByID(id));
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> insert(
            @RequestBody CompanyRequest company
    ) {
        return ResponseEntity.ok(this.CompanyService.create(company));

    }

}
