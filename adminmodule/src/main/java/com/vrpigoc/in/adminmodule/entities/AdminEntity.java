package com.vrpigoc.in.adminmodule.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AdminEntity {
    @Id
    private Long aid;

    private String name;
    private String email;
    private String password;
    private String mobile;
    private String address;
    private String role;

    private String createdDate;
    private String updatedDate;



}
