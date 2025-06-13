package com.design_pattern.adapter.model.adapter;

import com.design_pattern.adapter.model.PaymentRequest;
import com.design_pattern.adapter.paymentSystem.external.ExternalPaymentSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ExternalPaymentAdapter implements IPaymentAdapter{

    private ExternalPaymentSDK externalPaymentSDK;

    public ExternalPaymentAdapter() {
        this.externalPaymentSDK = new ExternalPaymentSDK();
    }

    @Override
    public String paymentProcessor(PaymentRequest request) {
        return externalPaymentSDK.pay(request.getAccount(),
                                    request.getAmount(),
                                    request.getCurrency());
    }
}
