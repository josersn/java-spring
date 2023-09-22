package com.backend.healthserviceasservice.application.services;

import com.backend.healthserviceasservice.application.dtos.specialty.SpecialtyDTO;
import com.backend.healthserviceasservice.domain.entities.Specialty;
import com.backend.healthserviceasservice.domain.repositories.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public Specialty createSpecialty(SpecialtyDTO specialtyDTO){
        Specialty specialty = Specialty.create(specialtyDTO.getName(), specialtyDTO.getDescription());

        specialtyRepository.save(specialty);

        return specialty;
    }

    @Cacheable("specialties")
    public List<SpecialtyDTO> listSpecialty() {
        List<Specialty> specialties = specialtyRepository.findAll();

        return specialties.stream().map(specialty -> SpecialtyDTO.fromEntity(specialty)).toList();
    }


}
