package com.backend.healthserviceasservice.application.dtos.customer;

import com.backend.healthserviceasservice.domain.enums.GenderEnum;
import com.backend.healthserviceasservice.infrastructure.modelRequest.CustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private String id;
    private String cpf;
    private String rg;
    private String name;
    private LocalDate birthDate;
    private String picture;
    private GenderEnum gender;
    private String email;
    private String password;
    private String phone;
    private Boolean isActive;
    private Instant createdAt;
    private Instant updatedAt;

    private CustomerDTO(
            final String cpf,
            final String rg,
            final String name,
            final String birthDate,
            final GenderEnum gender,
            final String email,
            final String password,
            final String phone
            ) {

        this.cpf = cpf;
        this.rg = rg;
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phone = phone;
    };

    public static CustomerDTO fromRequest(CustomerRequest customerRequest) {
        return  new CustomerDTO(
                customerRequest.getCpf(),
                customerRequest.getRg(),
                customerRequest.getName(),
                customerRequest.getBirthDate(),
                customerRequest.getGender(),
                customerRequest.getEmail(),
                customerRequest.getPassword(),
                customerRequest.getPhone()
        );
    }
}
