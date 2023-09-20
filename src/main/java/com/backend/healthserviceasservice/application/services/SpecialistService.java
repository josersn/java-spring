package com.backend.healthserviceasservice.application.services;

import com.backend.healthserviceasservice.domain.entities.Specialist;
import com.backend.healthserviceasservice.domain.entities.Specialty;
import com.backend.healthserviceasservice.domain.repositories.SpecialistRepository;
import com.backend.healthserviceasservice.domain.repositories.SpecialtyRepository;
import com.backend.healthserviceasservice.infrastructure.modelRequest.SpecialistRequest;
import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Expectation;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialistService {
    private final SpecialistRepository specialistRepository;
    private final SpecialtyRepository specialtyRepository;

    public Specialist createSpecialist(SpecialistRequest specialistRequest)  {

        Optional<Specialty> specialty = specialtyRepository.findById(specialistRequest.getSpecialtyId());

        if(specialty.isEmpty()) {
            throw new RuntimeException("Especialidade não encontrada.");
        }

        Specialist specialist = Specialist.create(specialistRequest.getName());
        specialist.setSpecialty(specialty.get());
        specialistRepository.save(specialist);

        return specialist;
    }
}
