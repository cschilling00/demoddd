package com.example.demoddd.domain.repositories;

import com.example.demoddd.domain.entities.Cargo;

import java.util.Optional;

public interface CargoRepository {
    Optional<Cargo> findByCustomer_Id(Long customer_id);
    Optional<Cargo> findByTrackingId(String trackingId);
}
