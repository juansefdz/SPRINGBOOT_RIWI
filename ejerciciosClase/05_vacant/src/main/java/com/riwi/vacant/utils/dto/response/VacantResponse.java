package com.riwi.vacant.utils.dto.response;

import com.riwi.vacant.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantResponse {
    private Long id;
    private String title;
    private String description;
    private CompanyToVacantResponse Company;
}
