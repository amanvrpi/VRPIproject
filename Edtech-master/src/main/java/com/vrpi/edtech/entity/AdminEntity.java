package com.vrpi.edtech.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date; // Import java.util.Date for date/time type
import java.util.List;

@Entity
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid", nullable = false)
    private Long aid;

    private String name;
    private String email;

    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP) // Specify temporal type
    private Date created_at; // Change type to Date

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP) // Specify temporal type
    private Date updated_at; // Change type to Date

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<CourseEntity> courses = new ArrayList<>();

    // Constructors, getters, and setters
}
