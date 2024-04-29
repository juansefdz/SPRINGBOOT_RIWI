package com.riwi.vacant.utils.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //patrón de diseño para crear clases.
@AllArgsConstructor
@NoArgsConstructor

public class CompanyRequest {
    private String name;
    private String location;
    private String contact;

}
