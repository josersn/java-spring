package com.backend.healthserviceasservice.application.services;

import com.backend.healthserviceasservice.application.dtos.customer.CustomerDTO;
import com.backend.healthserviceasservice.domain.entities.Customer;
import com.backend.healthserviceasservice.domain.repositories.CustomerRepository;
import com.backend.healthserviceasservice.infrastructure.message.kafka.KafkaProducer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final KafkaProducer kafkaProducer;

    @Transactional
    public Customer createCustomer(CustomerDTO customerDTO) {

        Optional<Customer> customerAlreadyExists = customerRepository.findByCpf(customerDTO.getCpf());

        if(customerAlreadyExists.isPresent()) {
            throw new RuntimeException("CPF Already Used.");
        }

        Optional<Customer> EmailAlreadyUsed = customerRepository.findByEmail(customerDTO.getEmail());

        if(EmailAlreadyUsed.isPresent()) {
            throw  new RuntimeException("Email Already Used.");
        }

        Customer customer = Customer.create(customerDTO);

        customerRepository.save(customer);

        kafkaProducer.producer("email", customer.getEmail());

        return  customer;
    }

}