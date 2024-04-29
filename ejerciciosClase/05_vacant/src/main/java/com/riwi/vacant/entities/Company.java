package com.riwi.vacant.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="company")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 60,nullable = false)
    private String location;
    @Column(length = 15, nullable = false)
    private String contact;


    /*
    * SE DEBE EXCLUDE PARA EVITAR QUE EL GET Y SET SE GENERE DEL VACANT PARA EVITAR CICLOS EN LAS LISTAS DE ToSTRING.
    *   ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    *  @ToString.Exclude
    *  @EqualsAndHashCode.Exclude
    *  cascade = CascadeType.ALL   --> elimina en cascada
    *   orphanRemoval = true      --> si el objeto queda huérfano porque se elimina al papá entonces  se elimina
    * */
    @OneToMany(mappedBy = "objCompany",fetch=FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vacant> vacants;


}
