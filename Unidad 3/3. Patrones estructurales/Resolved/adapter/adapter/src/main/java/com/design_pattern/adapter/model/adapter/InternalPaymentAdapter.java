package com.design_pattern.adapter.model.adapter;

import com.design_pattern.adapter.model.PaymentRequest;
import com.design_pattern.adapter.paymentSystem.legacy.InternalPaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class InternalPaymentAdapter implements IPaymentAdapter{

    private InternalPaymentProcessor internalPaymentProcessor;

    public InternalPaymentAdapter() {
        this.internalPaymentProcessor = new InternalPaymentProcessor();
    }

    @Override
    public String paymentProcessor(PaymentRequest request) {
        return internalPaymentProcessor.processPayment(request.getCustomId(), request.getAmount());
    }
}
