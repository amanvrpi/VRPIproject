package com.vrpi.edtech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
public record InstructorEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        Long id,

        String name,

        String description,

        String image
) {
}