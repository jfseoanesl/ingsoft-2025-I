package com.design_patterns.bridge.bridge.abstraction;

import com.design_patterns.bridge.bridge.implementation.PaymentProcessor;
import com.design_patterns.bridge.model.PaymentDetails;

public abstract class Payment {
    protected PaymentProcessor processor;

    public Payment(PaymentProcessor processor) {
        this.processor = processor;
    }

    public abstract String processPayment(PaymentDetails details);

    protected String executePayment(PaymentDetails details) {
        return processor.processPayment(details);
    }

    public String getProcessorName() {
        return processor.getName();
    }
}