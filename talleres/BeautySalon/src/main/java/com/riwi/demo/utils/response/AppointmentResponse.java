package com.riwi.demo.utils.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

    private int appointment_id;
    private int client_id;
    private int employee_id;
    private int service_id;
    private Date date_time;
    private int duration;

    private String comments;
}
