package com.vrpi.edtech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lesson_entity")
public record LessonEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        Long id,

        String title,

        String topics,

        @ManyToOne
        @JoinColumn(name = "module_entity_id")
        ModuleEntity moduleEntity
) {
}
