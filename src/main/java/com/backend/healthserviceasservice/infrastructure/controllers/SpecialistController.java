package com.backend.healthserviceasservice.infrastructure.controllers;

import com.backend.healthserviceasservice.application.services.SpecialistService;
import com.backend.healthserviceasservice.infrastructure.modelRequest.SpecialistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specialist")
@RequiredArgsConstructor
public class SpecialistController {

    private final SpecialistService specialistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSpecialist(@RequestBody SpecialistRequest specialistRequest) {
        specialistService.createSpecialist(specialistRequest);
    }
}
