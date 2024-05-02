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
public class ClientResponse {
    private int client_id;

    private String first_name;

    private String last_name;

    private String email;

    private String phone;
}
