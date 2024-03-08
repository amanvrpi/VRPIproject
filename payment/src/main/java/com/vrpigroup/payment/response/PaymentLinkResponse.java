package com.vrpigroup.payment.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class PaymentLinkResponse {
    private String payment_link_url;
    private String payment_link_id;
}
