package com.vrpi.edtech.entity;

import com.vrpi.edtech.domain.PaymentMethod;
import com.vrpi.edtech.domain.PaymentStatus;

public record PaymentDetails(PaymentMethod paymentMethod, PaymentStatus status, String paymentId,
                             String razorpayPaymentLinkId, String razorpayPaymentLinkReferenceId,
                             String razorpayPaymentLinkStatus, String razorpayPaymentId) {

}