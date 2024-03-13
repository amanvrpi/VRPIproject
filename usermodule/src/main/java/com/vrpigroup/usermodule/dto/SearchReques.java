package com.vrpigroup.usermodule.dto;

import lombok.Data;

@Data
public class SearchReques {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String occupation;
    private String aadharCardNumber;
    public boolean active;
}
