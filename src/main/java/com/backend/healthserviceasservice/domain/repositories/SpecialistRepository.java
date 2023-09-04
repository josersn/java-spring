package com.backend.healthserviceasservice.domain.repositories;

import com.backend.healthserviceasservice.domain.entities.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepository extends JpaRepository<Specialist, String> {
}
