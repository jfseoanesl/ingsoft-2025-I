package com.design_pattern.adapter.services;

import com.design_pattern.adapter.paymentSystem.legacy.InternalPaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private InternalPaymentProcessor paymentProcessor;

    public String process(String customerId, double amount) {

        return paymentProcessor.processPayment(customerId, amount);

    }
}
