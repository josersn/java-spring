package com.backend.healthserviceasservice.application.dtos.specialty;

import com.backend.healthserviceasservice.domain.entities.Specialty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecialtyDTO {
    private String id;
    private String name;
    private String description;


    static public SpecialtyDTO fromEntity(Specialty specialty) {
        SpecialtyDTO specialtyDTO = new SpecialtyDTO();
        specialtyDTO.setId(specialty.getId());
        specialtyDTO.setName(specialty.getName());
        specialtyDTO.setDescription(specialty.getDescription());

        return specialtyDTO;
    }
}

