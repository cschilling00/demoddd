package com.example.demoddd.application.services;

import com.example.demoddd.domain.entities.Cargo;
import com.example.demoddd.infrastructure.repositories.impl.CargoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoService {
    @Autowired
    CargoRepositoryImpl cargoRepositoryImpl;

    public Optional<Cargo> getByTrackingId(String trackingId){
        return cargoRepositoryImpl.findByTrackingId(trackingId);
    }

    public Optional<Cargo> getByCustomerId(Long customer_id){
        return cargoRepositoryImpl.findByCustomer_Id(customer_id);
    }

}
