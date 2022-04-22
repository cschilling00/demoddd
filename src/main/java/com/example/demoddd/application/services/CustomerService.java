package com.example.demoddd.application.services;

import com.example.demoddd.domain.entities.Customer;
import com.example.demoddd.infrastructure.repositories.impl.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepositoryImpl customerRepositoryImpl;

    public Optional<Customer> getById(Long id) { return customerRepositoryImpl.getById(id); }

    public Optional<Customer> getByName(String name){
        return customerRepositoryImpl.findByName(name);
    }

    public Optional<Customer> getByCargoId(String cargoTrackingId){
        return customerRepositoryImpl.findByCargo_TrackingId(cargoTrackingId);
    }
}
