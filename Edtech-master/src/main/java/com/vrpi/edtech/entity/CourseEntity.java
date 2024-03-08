package com.vrpi.edtech.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long courseId;

        private String name;
        private String courseLink;
        private boolean isActive;
        private String type;
        private String content;
        private Integer price;
        private String buttonContent;
        private String image;
        private String language;
        private String rating;
        private String reviewsCount;

        @ElementCollection
        private List<String> studentsEnrolled;

        private String updatedDate;

        @ManyToOne
        @JoinColumn(name = "tools_and_technology_used_id")
        private ToolsAndTechnologyUsedEntity toolsAndTechnologyUsed;

        @ManyToOne
        @JoinColumn(name = "course_content_id")
        private CourseContentEntity courseContent;

        @ManyToOne
        @JoinColumn(name = "syllabus_id")
        private SyllabusEntity syllabus;

        @ManyToOne
        @JoinColumn(name = "instructor_id")
        private InstructorEntity instructor;
}