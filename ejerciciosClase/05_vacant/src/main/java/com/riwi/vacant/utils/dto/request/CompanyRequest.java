package com.riwi.vacant.utils.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //patrón de diseño para crear clases.
@AllArgsConstructor
@NoArgsConstructor

public class CompanyRequest {
    @NotBlank(message = "company name is required")
    @Size(min = 0,max = 40,message = "the number of characters for the name exceeds what is allowed")
    private String name;
    @NotBlank(message = "company location is required")
    private String location;
    @Size(min=0,max = 15,message = "the number of characters for the location exceeds what is allowed")
    @NotBlank(message = "company contact is required")
    private String contact;

}
