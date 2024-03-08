package com.vrpigroup.payment.Repo;

import com.vrpigroup.payment.Model.PaymentInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInformationRepo extends JpaRepository<PaymentInformation, Long> {
}
