package com.backend.healthserviceasservice.application.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerEvent {
    public String cpf;
    public String email;

    @Override
    public String toString() {
        return "CustomerEvent{" +
                "cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
