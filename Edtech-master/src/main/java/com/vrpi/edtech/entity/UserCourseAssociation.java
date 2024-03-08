package com.vrpi.edtech.entity;
import jakarta.persistence.*;

@Entity
public  record UserCourseAssociation(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        Long userId, Long courseId){
    public UserCourseAssociation(Long userId, Long courseId) {
        this(null, userId, courseId);
    }
}