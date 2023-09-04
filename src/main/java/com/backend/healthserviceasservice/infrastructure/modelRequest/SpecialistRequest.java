package com.backend.healthserviceasservice.infrastructure.modelRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialistRequest {
    private String name;
    private String specialtyId;
}
