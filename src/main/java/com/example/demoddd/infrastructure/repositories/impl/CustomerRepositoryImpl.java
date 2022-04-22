package com.example.demoddd.infrastructure.repositories.impl;

import com.example.demoddd.domain.entities.Customer;
import com.example.demoddd.domain.repositories.CustomerRepository;
import com.example.demoddd.infrastructure.mapper.DomainMapper;
import com.example.demoddd.infrastructure.repositories.iCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    iCustomerRepository iCustomerRepository;

    @Autowired
    DomainMapper domainMapper;
    @Override
    public Optional<Customer> findByName(String name) {
        return  domainMapper.mapCustomer(iCustomerRepository.findByName(name));
    }

    @Override
    public Optional<Customer> findByCargo_TrackingId(String trackingId) {
        return  domainMapper.mapCustomer(iCustomerRepository.findByCargo_TrackingId(trackingId));
    }

    public Optional<Customer> getById(Long id) {
        return  domainMapper.mapCustomer(Optional.of(iCustomerRepository.getById(id)));
    }
}
