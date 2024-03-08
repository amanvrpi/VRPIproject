package com.vrpigroup.payment.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class PaymentDetailsRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long userId;
    private Long courseId;
    private String paymentLinkId;
    private String paymentLinkUrl;

    public PaymentDetailsRequest(Long userId, Long courseId, String paymentLinkId, String paymentLinkUrl) {
        this.userId = userId;
        this.courseId = courseId;
        this.paymentLinkId = paymentLinkId;
        this.paymentLinkUrl = paymentLinkUrl;
    }

    public PaymentDetailsRequest() {

    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        PaymentDetailsRequest that = (PaymentDetailsRequest) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
