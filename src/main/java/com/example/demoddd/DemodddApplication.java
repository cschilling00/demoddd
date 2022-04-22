package com.example.demoddd;

import com.example.demoddd.infrastructure.entities.iCargo;
import com.example.demoddd.infrastructure.entities.iCustomer;
import com.example.demoddd.infrastructure.repositories.iCargoRepository;
import com.example.demoddd.infrastructure.repositories.iCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemodddApplication implements CommandLineRunner {
    @Autowired
    private iCustomerRepository customerRepository;
    @Autowired
    private iCargoRepository cargoRepository;

    @Override
    public void run(String... args) throws Exception {
        iCustomer iCustomer = new iCustomer("Cassandra");
        iCustomer iCustomer1 = new iCustomer("Max");
        iCargo iCargo = new iCargo(iCustomer);
        iCargo iCargo1 = new iCargo(iCustomer1);

        customerRepository.save(iCustomer);
        customerRepository.save(iCustomer1);
        cargoRepository.save(iCargo);
        cargoRepository.save(iCargo1);
        System.out.println(customerRepository.findByName("Cassandra").get());
    }

    public static void main(String[] args) {
        SpringApplication.run(DemodddApplication.class, args);
    }

}
