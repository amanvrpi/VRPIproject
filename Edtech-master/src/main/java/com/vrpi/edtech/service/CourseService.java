package com.vrpi.edtech.service;

import com.razorpay.RazorpayException;
import com.vrpi.edtech.entity.CourseEntity;
import com.vrpi.edtech.entity.PaymentEntity;
import com.vrpi.edtech.entity.UserCourseAssociation;
import com.vrpi.edtech.exception.*;
import com.vrpi.edtech.repo.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final Courserepo courserepo;
    private final RestTemplate restTemplate;
    private final userCourseAssociationRepo userCourseAssociationRepo;

    public List<CourseEntity> getAllCourses() {
        return courserepo.findAll();
    }

    public CourseEntity getCourseDetails(Long courseId) {
        return courserepo.findById(courseId).orElseThrow(() ->
                new CourseFoundException("Course not found with ID: " + courseId));
    }

    public boolean enrollUserForCourse(Long courseId, Long userId)
            throws CourseNotActiveException, CourseNotFoundException,
            RestClientException, RazorpayException {
        validateEnrollmentParameters(courseId, userId);
        CourseEntity course = getCachedCourseById(courseId);
        validateCourse(course, courseId);
        validateActiveCourse(course);
        ResponseEntity<Void> paymentResponse = initiatePayment(userId, courseId);
        if (paymentResponse.getStatusCode() == HttpStatus.CREATED) {
            enrollUser(userId, courseId);
            //sendConfirmationEmail(userId, courseId);
            return true;
        } else {
            throw new RazorpayException("Error initiating payment");
        }
    }

    private void validateEnrollmentParameters(Long courseId, Long userId) {
        if (courseId == null || userId == null) {
            throw new IllegalArgumentException("CourseId and userId cannot be null");
        }
    }

    private CourseEntity getCachedCourseById(Long courseId) {
        return courserepo.findById(courseId).orElse(null);
    }

    private void validateCourse(CourseEntity course, Long courseId) throws CourseNotFoundException {
        if (course == null) {
            throw new CourseNotFoundException("Course not found with ID: " + courseId);
        }
    }

    private void validateActiveCourse(CourseEntity course) throws CourseNotActiveException {
        if (!course.isActive()) {
            throw new CourseNotActiveException("Course is not active");
        }
    }

    private ResponseEntity<Void> initiatePayment(Long userId, Long courseId) {
        var orderId = generateRandomOrderId(userId, courseId);
        String paymentUrl = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8081/payment-vrpi/payments/{orderId}")
                .buildAndExpand(orderId)
                .toUriString();
        return restTemplate.postForEntity(
                paymentUrl,
                createPaymentEntity(userId, courseId),
                Void.class);
    }

    private Integer generateRandomOrderId(Long userId, Long courseId) {
        // generate unique orderID for each user and course
        return Math.toIntExact((userId + courseId + hashCode()));
    }

    private PaymentEntity createPaymentEntity(Long userId, Long courseId) {
        return new PaymentEntity(userId, courseId);
    }

    private void enrollUser(Long userId, Long courseId) {
        var userCourseAssociation = new UserCourseAssociation(userId, courseId);
        userCourseAssociationRepo.save(userCourseAssociation);
    }

    private void sendConfirmationEmail(Long userId, Long courseId) {
        /*restTemplate.postForEntity(
                "http://vrpigroup.com/email-service/send-email",
                createEmailEntity(userId, courseId),
                Void.class);*/
    }

    public String deleteCourse(Long id) {
        courserepo.deleteById(id);
        return "Course deleted successfully";
    }

    public String updateCourse(Long id) {
        return "Course updated successfully";
    }

    public String createCourse(CourseEntity courseEntity) {
        courserepo.save(courseEntity);
        return "Course created successfully";
    }

    public Integer getCoursePrice(Long courseId) {
        return courserepo.findById(courseId).map(CourseEntity::getPrice).orElseThrow(() ->
                new CourseFoundException("Course not found with ID: " + courseId));
    }

    public void storePaymentDetails(Long userId, Long courseId, String paymentLinkId, String paymentLinkUrl) {
        // store payment details in database

    }
}