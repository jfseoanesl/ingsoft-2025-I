package com.design_pattern.adapter.model.adapter;

import com.design_pattern.adapter.model.PaymentRequest;

public interface IPaymentAdapter {

    String paymentProcessor(PaymentRequest request);

}
