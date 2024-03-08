package com.vrpi.edtech.controller;

import com.razorpay.RazorpayException;
import com.vrpi.edtech.entity.CourseEntity;
import com.vrpi.edtech.exception.CourseNotActiveException;
import com.vrpi.edtech.exception.CourseNotFoundException;
import com.vrpi.edtech.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    public CourseEntity getCourseById(Long id) {
        return courseService.getCourseDetails(id);
    }

    @PostMapping("/create-course")
    public String createCourse(CourseEntity courseEntity){
        return courseService.createCourse(courseEntity);
    }

    @PutMapping("/update-course/{id}")
    public String updateCourse(Long id) {
        return courseService.updateCourse(id);
    }

    @DeleteMapping("/delete-course/{id}")
    public String deleteCourse(Long id) {
        return courseService.deleteCourse(id);
    }

    @GetMapping("/all-courses")
    public String getAllCourses() {
        return courseService.getAllCourses().toString();
    }

    // Enroll for course by student by hitting payment Api
    @PostMapping("/enroll-course/{courseId}/{userId}")
    public String enrollCourse(@RequestParam Long courseId, @RequestParam Long userId) throws
            CourseNotActiveException, CourseNotFoundException, RazorpayException {
        return String.valueOf(courseService.enrollUserForCourse(courseId, userId));
    }

    // getCoursePrice
    @GetMapping("/course-price/{courseId}")
    public Integer getCoursePrice(Long courseId) {
        return courseService.getCoursePrice(courseId);
    }

    @PostMapping("/store-payment-details")
    public String storePaymentDetails(@RequestParam Long userId, @RequestParam Long courseId,
                                     @RequestParam String paymentLinkId, @RequestParam String paymentLinkUrl) {
        courseService.storePaymentDetails(userId, courseId, paymentLinkId, paymentLinkUrl);
        return "Payment details stored successfully";
    }
}
