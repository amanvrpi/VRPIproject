package com.vrpi.edtech.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    @Size(min = 3, max = 50, message = "Full Name must be between 3 and 50 characters")
    private String firstName;
    private String lastName;
    @Size(min = 3, max = 50, message = "Father's name must be between 3 and 50 characters")
    private String fathersName;
    private String gender;
    @Past
    @Column(name = "DOB", nullable = false)
    private LocalDate dateOfBirth;
    private String phoneNumber;
    @Size(max = 255, message = "Address can't exceed 255 characters")
    private String address;
    private String email;
    private String createPassword;
    private String occupation;
    @Pattern(regexp = "\\d{12}", message = "Invalid Aadhar card format")
    private String aadharCardNumber;

}
