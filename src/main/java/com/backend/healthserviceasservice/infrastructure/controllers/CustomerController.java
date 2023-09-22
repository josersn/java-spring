package com.backend.healthserviceasservice.infrastructure.controllers;

import com.backend.healthserviceasservice.application.dtos.customer.CustomerDTO;
import com.backend.healthserviceasservice.application.services.CustomerService;
import com.backend.healthserviceasservice.infrastructure.modelRequest.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private  final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCustomer(@RequestBody CustomerRequest customerRequest){

        try {
            customerService.createCustomer(CustomerDTO.fromRequest(customerRequest));

            return new ResponseEntity(HttpStatus.CREATED);
        } catch (final RuntimeException exception) {
            HashMap<String, String> body = new HashMap<>();
            body.put("message", exception.getMessage());
            return new ResponseEntity(body, HttpStatus.BAD_REQUEST);

        }
    }
}
