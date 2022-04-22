package com.example.demoddd.domain.entities;

import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
    private Long id;
    private String name;
    private Set<Cargo> cargo;

}
