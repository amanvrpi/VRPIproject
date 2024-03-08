package com.vrpi.edtech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EducationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String educationLevel;
    private String institutionName;
    private String degree;
    private String instituteLocation;
    @Past
    private LocalDate startDate;
    @FutureOrPresent
    private LocalDate endDate;
    private String grade;

}