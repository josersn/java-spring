package com.backend.healthserviceasservice.infrastructure.modelRequest;

import com.backend.healthserviceasservice.domain.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private String cpf;
    private String rg;
    private String name;
    private String birthDate;
    private String picture;
    private GenderEnum gender;
    private String email;
    private String password;
    private String phone;

}
