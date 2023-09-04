package com.backend.healthserviceasservice.domain.entities;

import com.backend.healthserviceasservice.domain.utils.TimeNowUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Specialist {

    @Id
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant updatedAt;
    private Specialist(final String name) {

        final var now = TimeNowUtils.now();

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.isActive = true;
        this.createdAt = now;
        this.updatedAt = now;
    }

    public static Specialist create(String name) {
        return  new Specialist(name);
    }
}
