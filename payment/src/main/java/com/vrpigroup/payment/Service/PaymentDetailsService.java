package com.vrpigroup.payment.Service;

import com.vrpigroup.payment.Model.PaymentDetailsRequest;
import com.vrpigroup.payment.exceptions.GlobalExceptionHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PaymentDetailsService {

    /*private final PaymentDetailsRepo paymentDetails;
    private final PaymentDetailsRequest paymentDetailsRequest;
    private final PaymentInformation paymentInformation;*/
    private final RestTemplate restTemplate;


    public Double getCoursePrice(Long courseId) {
        ResponseEntity<Double> response = restTemplate.getForEntity(
                "course/course-price/{courseId}", Double.class, courseId);
        if (response.getBody() != null) {
            return response.getBody();
        } else {
            //throw new GlobalExceptionHandler("Error: Response body is null");
            return null;
        }
    }

    public boolean storePaymentDetails(Long userId, Long courseId, String paymentLinkId,
                                       String paymentLinkUrl) {
        var request = new PaymentDetailsRequest(
                userId, courseId, paymentLinkId, paymentLinkUrl);
        restTemplate.postForEntity("/course/store-payment-details", request, Void.class);
        return true;
    }
}
