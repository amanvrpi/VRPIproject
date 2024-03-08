package com.vrpigroup.payment.Repo;

import com.vrpigroup.payment.Model.PaymentDetailsRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRequestRepo extends JpaRepository<PaymentDetailsRequest, Long> {
}
