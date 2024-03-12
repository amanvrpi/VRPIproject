package com.vrpi.edtech.controller;

import com.vrpi.edtech.dto.UserDto;
import com.vrpi.edtech.service.CourseService;
import com.vrpi.edtech.service.client.IUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
@Autowired
private CourseService courseService;
@Autowired
public IUserClient userClient;

@GetMapping("/vrpi-admin/all")
public List<UserDto> gellAllUsers() {
    return userClient.getAllUser();

}
@GetMapping("/vrpi-admin/test")
public String test() {
    return "Admin test";
}
}
