package com.example.demoddd.interfaces.controller;

import com.example.demoddd.domain.entities.Cargo;
import com.example.demoddd.application.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @GetMapping("/tracking")
    public ResponseEntity<Object> getById(@RequestParam String trackingId){
        Optional<Cargo> object = cargoService.getByTrackingId(trackingId);
        if(object.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(object.get());
        }
    }

    @GetMapping("/customer")
    public ResponseEntity<Object> getByCargoId(@RequestParam Long customerId){
        Optional<Cargo> object = cargoService.getByCustomerId(customerId);
        if(object.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(object.get());
        }
    }

}
