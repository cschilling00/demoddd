package com.example.demoddd.domain.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cargo {
    private String trackingId;
    private Customer customer;

}
