package com.riwi.demo.utils.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse {

    private int service_id;

    private String name;

    private String description;

    private long price;
}
