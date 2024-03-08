package com.vrpi.edtech.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "chapter_entity")
public record ChapterEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        Long id,

        @NonNull
        String title,

        @OneToMany
        List<ModuleEntity> modules
) {
}