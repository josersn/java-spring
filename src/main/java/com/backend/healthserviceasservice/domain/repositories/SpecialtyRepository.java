package com.backend.healthserviceasservice.domain.repositories;

import com.backend.healthserviceasservice.domain.entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, String> {
}
