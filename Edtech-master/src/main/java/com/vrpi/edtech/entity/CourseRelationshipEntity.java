package com.vrpi.edtech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRelationshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private InstructorEntity instructor;

    @ManyToOne
    @JoinColumn(name = "tools_and_technology_used_id")
    private ToolsAndTechnologyUsedEntity toolsAndTechnologyUsed;

    @ManyToOne
    @JoinColumn(name = "syllabus_id")
    private SyllabusEntity syllabus;

    @ManyToOne
    @JoinColumn(name = "course_content_id")
    private CourseContentEntity courseContent;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private ChapterEntity chapter;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity module;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicEntity topic;
}
