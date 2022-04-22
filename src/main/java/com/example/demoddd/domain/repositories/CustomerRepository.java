package com.example.demoddd.domain.repositories;

import com.example.demoddd.domain.entities.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findByName(String name);
    Optional<Customer> findByCargo_TrackingId(String trackingId);

}
