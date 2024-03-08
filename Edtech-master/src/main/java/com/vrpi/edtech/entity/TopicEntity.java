package com.vrpi.edtech.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "topic_entity")
public record TopicEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        Long id,

        String title,

        String content,

        @ManyToOne
        @JoinColumn(name = "syllabus_entity_id")
        SyllabusEntity syllabusEntity
) {
}
