package com.backend.healthserviceasservice.domain.entities;

import com.backend.healthserviceasservice.application.dtos.customer.CustomerDTO;
import com.backend.healthserviceasservice.domain.enums.GenderEnum;
import com.backend.healthserviceasservice.domain.utils.TimeNowUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String id;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "rg", nullable = false)
    private String rg;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "picture")
    private String picture;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant updatedAt;


    private Customer (
            final String cpf,
            final String rg,
            final String name,
            final LocalDate birthDate,
            final GenderEnum gender,
            final String email,
            final String password
            ) {
        final var now = TimeNowUtils.now();

        this.id = UUID.randomUUID().toString();
        this.cpf = cpf;
        this.rg = rg;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.isActive = true;
        this.createdAt = now;
        this.updatedAt = now;
    }

    public static Customer create(
            CustomerDTO customerDTO
    ) {
        return new Customer(
                customerDTO.getCpf(),
                customerDTO.getRg(),
                customerDTO.getName(),
                customerDTO.getBirthDate(),
                customerDTO.getGender(),
                customerDTO.getEmail(),
                customerDTO.getPassword()
        );
    }



}
