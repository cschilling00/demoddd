package com.example.demoddd.interfaces.controller;

import com.example.demoddd.domain.entities.Customer;
import com.example.demoddd.application.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/id")
    public ResponseEntity<Object> getById(@RequestParam Long id){
        Optional<Customer> object = customerService.getById(id);
        if(object.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(object.get());
        }
    }

    @GetMapping("/cargoId")
    public ResponseEntity<Object> getByCargoId(@RequestParam String cargoId){
        Optional<Customer> object = customerService.getByCargoId(cargoId);
        if(object.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(object.get());
        }
    }

    @GetMapping("/name")
    public ResponseEntity<Object>  getByName(@RequestParam String name){
        Optional<Customer> object = customerService.getByName(name);
        if(object.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(object.get());
        }
    }
}
