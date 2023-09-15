package com.backend.healthserviceasservice.domain.entities;


import com.backend.healthserviceasservice.domain.utils.TimeNowUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Specialty {

    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;


    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant updatedAt;

    @OneToMany(mappedBy = "specialty")
    private List<Specialist> specialists;

    private Specialty(final String name, final String description) {

        final var now = TimeNowUtils.now();
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.isActive = true;
        this.createdAt = now;
        this.updatedAt = now;
    }

    public static Specialty create(final String name, final String description) {
        return new Specialty(
                name,
                description
        );
    }
}
