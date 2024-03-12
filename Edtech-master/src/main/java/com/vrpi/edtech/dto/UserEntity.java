package com.vrpi.edtech.dto;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class UserEntity {

    private Long id;
    private String firstName;
    private String lastName;

    private String fathersName;
    private String gender;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;

    private String email;
    private String createPassword;
    private String occupation;
    private String aadharCardNumber;
    private byte[] aadharFront;
    private byte[] aadharBack;
    private byte[] profilePic;
    private List<String> roles = new ArrayList<>();
    public boolean active;
    private String otp;
}
