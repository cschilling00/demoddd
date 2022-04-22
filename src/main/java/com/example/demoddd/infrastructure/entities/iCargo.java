package com.example.demoddd.infrastructure.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class iCargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String trackingId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private iCustomer iCustomer;

    public iCargo(iCustomer iCustomer) {
        this.iCustomer = iCustomer;
    }
}
