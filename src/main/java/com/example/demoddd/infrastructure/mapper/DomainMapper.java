package com.example.demoddd.infrastructure.mapper;


import com.example.demoddd.domain.entities.Cargo;
import com.example.demoddd.domain.entities.Customer;
import com.example.demoddd.infrastructure.entities.iCargo;
import com.example.demoddd.infrastructure.entities.iCustomer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class DomainMapper {

    public Optional<Customer> mapCustomer(Optional<iCustomer> iCustomer){
        return mapCustomer(iCustomer,false);
    }
    public Optional<Customer> mapCustomer(Optional<iCustomer> iCustomer, Boolean nested) {
        if(iCustomer.isEmpty()){
            return Optional.empty();
        }
        Customer customer = new Customer();
        customer.setId(Long.valueOf(iCustomer.get().getId()));
        customer.setName(iCustomer.get().getName());
        if(!nested) {
            customer.setCargo(iCustomer.get().getICargos().stream().map( cargo -> this.mapCargo(Optional.of(cargo), true).get()).collect(Collectors.toSet()));
        }
        return Optional.of(customer);
    }

    public Optional<Cargo> mapCargo(Optional<iCargo> iCargo){
        return mapCargo(iCargo,false);
    }

    public Optional<Cargo> mapCargo(Optional<iCargo> iCargo, Boolean nested) {
        if(iCargo.isEmpty()){
            return Optional.empty();
        }
        Cargo cargo = new Cargo();
        cargo.setTrackingId(iCargo.get().getTrackingId());
        if(!nested){
            cargo.setCustomer(this.mapCustomer(Optional.of(iCargo.get().getICustomer()),true).get());
        }
        return Optional.of(cargo);
    }
}
