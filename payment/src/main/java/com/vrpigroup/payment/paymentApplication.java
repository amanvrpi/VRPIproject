package com.vrpigroup.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class paymentApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(paymentApplication.class, args);
    }

}

/*
# Payment Service
payment.service.url=http://localhost:8080
payment.service.path=/payment
payment.service.method=POST
payment.service.content.type=application/json
payment.service.accept.type=application/json
payment.service.connection.timeout=10000
payment.service.read.timeout=10000
payment.service.retry.count=3
payment.service.retry.interval=1000
payment.service.retry.interval.multiplier=2
payment.service.retry.max.interval=10000
payment.service.retry.max.duration=30000
payment.service.retry.jitter=0.5
payment.service.retry.backoff=exponential
payment.service.retry.backoff.policy=exponential
payment.service.retry.backoff.policy.max.interval=10000
payment.service.retry.backoff.policy.max.duration=30000
payment.service.retry.backoff.policy.jitter=0.5
payment.service.retry.backoff.policy.multiplier=2
payment.service.retry.backoff.policy.interval=1000
payment.service.retry.backoff.policy.max.attempts=3*/