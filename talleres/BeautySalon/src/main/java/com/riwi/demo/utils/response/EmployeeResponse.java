package com.riwi.demo.utils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

    private int employee_id;

    private String first_name;

    private String last_name;

    private String email;

    private String phone;

    private String role;
}
