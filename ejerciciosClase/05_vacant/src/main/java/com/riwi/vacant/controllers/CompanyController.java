package com.riwi.vacant.controllers;

import com.riwi.vacant.services.interfaces.ICompanyService;
import com.riwi.vacant.utils.dto.errors.ErrorResponse;
import com.riwi.vacant.utils.dto.errors.ErrorsResponse;
import com.riwi.vacant.utils.dto.request.CompanyRequest;
import com.riwi.vacant.utils.dto.response.CompanyResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @ApiResponse(responseCode = "400",description = "When the ID not is valid",content = {
            @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorResponse.class))
    })
    @GetMapping("/{id}")
    public ResponseEntity <CompanyResponse> get (
            @PathVariable String id){
        return ResponseEntity.ok(this.CompanyService.getByID(id));
    }

    @ApiResponse(responseCode = "400",description = "When the request not is valid",content = {
            @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorsResponse.class))
    })
    @PostMapping
    public ResponseEntity<CompanyResponse> insert(
            @Validated @RequestBody CompanyRequest company
    ) {
        return ResponseEntity.ok(this.CompanyService.create(company));

    }
    @ApiResponse(responseCode = "400",description = "When the ID not is valid",content = {
            @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorResponse.class))
    })
    @DeleteMapping (path = "/{id}")
    public ResponseEntity <Void> delete (@PathVariable String id){
        this.CompanyService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @ApiResponse(responseCode = "400",description = "When the request not is valid",content = {
            @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorsResponse.class))
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<CompanyResponse> update(
            @PathVariable String id,
            @Validated@RequestBody CompanyRequest company) {

        return ResponseEntity.ok(this.CompanyService.update(company, id));
    }
}
