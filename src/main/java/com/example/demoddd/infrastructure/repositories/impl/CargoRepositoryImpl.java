package com.example.demoddd.infrastructure.repositories.impl;

import com.example.demoddd.domain.entities.Cargo;
import com.example.demoddd.domain.repositories.CargoRepository;
import com.example.demoddd.infrastructure.mapper.DomainMapper;
import com.example.demoddd.infrastructure.repositories.iCargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CargoRepositoryImpl implements CargoRepository{

    @Autowired
    iCargoRepository cargoRepository;
    @Autowired
    DomainMapper domainMapper;

    @Override
    public Optional<Cargo> findByTrackingId(String trackingId) {
        return domainMapper.mapCargo(cargoRepository.findByTrackingId(trackingId));
    }

    public Optional<Cargo> findByCustomer_Id(Long customer_id) {
        return domainMapper.mapCargo(cargoRepository.findByiCustomer_Id(customer_id));

    }
}
