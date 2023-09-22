package com.backend.healthserviceasservice.domain.repositories;

import com.backend.healthserviceasservice.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findByCpf(String cpf);
    Optional<Customer> findByEmail(String email);
}
