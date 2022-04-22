package com.example.demoddd.infrastructure.repositories;


import com.example.demoddd.infrastructure.entities.iCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iCargoRepository extends JpaRepository<iCargo,Long> {
    public Optional<iCargo> findByiCustomer_Id(Long customerId);
    public Optional<iCargo> findByTrackingId(String trackingId);

}
