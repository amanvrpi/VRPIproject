package com.vrpi.edtech.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "syllabus_entity")
public record SyllabusEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "syllabus_Id", nullable = false)
        Long syllabusId,

        String description,

        @OneToMany
        List<TopicEntity> topics,

        @OneToMany
        Collection<CourseEntity> courseEntity
) {
}