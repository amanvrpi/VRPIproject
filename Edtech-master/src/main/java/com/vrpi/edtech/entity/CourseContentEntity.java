package com.vrpi.edtech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;



@Entity
@Table(name = "course_content_entity")
public record CourseContentEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        Long id,

        @NonNull
        String techStack,

        @OneToMany
        Collection<CourseEntity> courseEntity
) {
}