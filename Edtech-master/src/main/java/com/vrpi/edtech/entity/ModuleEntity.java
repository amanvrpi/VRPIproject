package com.vrpi.edtech.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "module_entity")
public record ModuleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        Long id,

        String title,

        @OneToMany
        List<LessonEntity> lessons,

        @ManyToOne
        @JoinColumn(name = "chapter_entity_id")
        ChapterEntity chapterEntity
) {
}