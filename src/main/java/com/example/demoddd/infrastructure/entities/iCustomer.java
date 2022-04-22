package com.example.demoddd.infrastructure.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class iCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "iCustomer", fetch = FetchType.EAGER)
    private Set<iCargo> iCargos = Collections.emptySet();

    public iCustomer(String name) {
        this.name = name;
    }

}
