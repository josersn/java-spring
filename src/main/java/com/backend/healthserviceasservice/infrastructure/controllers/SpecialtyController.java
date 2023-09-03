package com.backend.healthserviceasservice.infrastructure.controllers;

import com.backend.healthserviceasservice.application.dtos.specialty.SpecialtyDTO;
import com.backend.healthserviceasservice.application.services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/specialty")
@RequiredArgsConstructor
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSpecialty(@RequestBody SpecialtyDTO specialtyDTO){
        specialtyService.createSpecialty(specialtyDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SpecialtyDTO> ListSpecialties(){
        return specialtyService.listSpecialty();
    }

}
