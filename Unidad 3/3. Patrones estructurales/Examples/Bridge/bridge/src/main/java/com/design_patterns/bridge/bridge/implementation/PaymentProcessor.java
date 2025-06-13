package com.design_patterns.bridge.bridge.implementation;

import com.design_patterns.bridge.model.PaymentDetails;

public interface PaymentProcessor {
    String processPayment(PaymentDetails details);
    String getName();
    boolean isAvailable();
}
