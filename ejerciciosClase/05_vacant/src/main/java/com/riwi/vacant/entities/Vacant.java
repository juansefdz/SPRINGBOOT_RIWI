package com.riwi.vacant.entities;

import com.riwi.vacant.utils.enums.StatusVacant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity (name="vacant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacant {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING) //Especifica que el ENUM será de tipo String.

    private StatusVacant status;


    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")  //referenciación en SQL al FK
    private Company objCompany;
}
