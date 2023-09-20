package com.backend.healthserviceasservice.infrastructure.controllers;

import com.backend.healthserviceasservice.application.services.SpecialistService;
import com.backend.healthserviceasservice.domain.entities.Specialist;
import com.backend.healthserviceasservice.infrastructure.modelRequest.SpecialistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/specialist")
@RequiredArgsConstructor
public class SpecialistController {

    private final SpecialistService specialistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createSpecialist(@RequestBody SpecialistRequest specialistRequest) {
        try {
            specialistService.createSpecialist(specialistRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (final RuntimeException exception) {
            Map<String, String> response = new HashMap<>();
            response.put("message", exception.getMessage());
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
}
