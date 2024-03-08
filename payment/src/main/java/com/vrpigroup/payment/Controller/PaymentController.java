package com.vrpigroup.payment.Controller;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.vrpigroup.payment.Service.PaymentDetailsService;
import com.vrpigroup.payment.response.PaymentLinkResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment-vrpi")
public class PaymentController {


    private final RazorpayClient razorpay;
    private final PaymentDetailsService paymentDetails;

    /*@Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;*/

    public PaymentController(
            PaymentDetailsService paymentDetails,
            @Value("${razorpay.api.key}") String apiKey,
            @Value("${razorpay.api.secret}") String apiSecret
    ) throws RazorpayException {
        this.paymentDetails = paymentDetails;
        if (apiKey == null || apiSecret == null) {
            throw new IllegalArgumentException("API key or API secret is null");
        }
        this.razorpay = new RazorpayClient(apiKey, apiSecret);
    }


    @PostMapping("/payments/{orderId}")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(
            @RequestParam Long userId,
            @RequestParam Long courseId,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String mobile,
            @RequestParam String email
    ) {
        try {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", paymentDetails.getCoursePrice(courseId));
            paymentLinkRequest.put("currency", "INR");
            JSONObject customer = new JSONObject();
            customer.put("name", firstName + " " + lastName);
            customer.put("contact", mobile);
            customer.put("email", email);
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", true);
            paymentLinkRequest.put("callback_url", "http://vrpigroup.com/payment-vrpi/payments?course_id=" + courseId);
            paymentLinkRequest.put("callback_method", "get");
            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            String paymentLinkId = payment.get("id");
            String paymentLinkUrl = payment.get("short_url");
            boolean isValid = paymentDetails.storePaymentDetails(userId, courseId, paymentLinkId, paymentLinkUrl);
            if (isValid) {
                PaymentLinkResponse response = new PaymentLinkResponse(paymentLinkUrl, paymentLinkId);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (RazorpayException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}