package com.example.demoddd.infrastructure.repositories;

import com.example.demoddd.infrastructure.entities.iCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iCustomerRepository extends JpaRepository<iCustomer,Long> {
    Optional<iCustomer> findByName(String name);

    @Query(value = "select * from i_Customer, i_Cargo where i_Cargo.tracking_Id = :trackingId and i_Customer.id = i_Cargo.Customer_id", nativeQuery = true)
    Optional<iCustomer> findByCargo_TrackingId(@Param("trackingId") String trackingId);

}
