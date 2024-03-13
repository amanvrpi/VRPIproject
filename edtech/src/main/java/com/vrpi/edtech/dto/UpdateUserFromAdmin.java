package com.vrpi.edtech.dto;

import jakarta.validation.constraints.Size;

public class UpdateUserFromAdmin //painding work due to unsufficient data designed by "susmita maidam"
{
    @Size(min = 3, max = 50, message = "Full Name must be between 3 and 50 characters")
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

}
