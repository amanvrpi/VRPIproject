package com.vrpi.edtech.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tools_and_technology_used_entity")
public class ToolsAndTechnologyUsedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "tech_stacks_id")
    private TechStackEntity techStacks;

    @ManyToOne
    @JoinColumn(name = "course_entity_course_id")
    private CourseEntity courseEntity;

}