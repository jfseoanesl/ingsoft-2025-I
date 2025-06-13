package com.design_pattern.adapter.services;

import com.design_pattern.adapter.model.PaymentRequest;
import com.design_pattern.adapter.model.PaymentSystem;
import com.design_pattern.adapter.model.adapter.ExternalPaymentAdapter;
import com.design_pattern.adapter.model.adapter.IPaymentAdapter;
import com.design_pattern.adapter.model.adapter.InternalPaymentAdapter;
import com.design_pattern.adapter.paymentSystem.legacy.InternalPaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

   private Map<PaymentSystem, IPaymentAdapter> adapters = new HashMap();

   public PaymentService() {

       adapters.put(PaymentSystem.EXTERNAL, new ExternalPaymentAdapter());
       adapters.put(PaymentSystem.LEGACY, new InternalPaymentAdapter());

   }


    public String process(PaymentRequest request) {

       IPaymentAdapter payment = this.adapters.get(request.getType());
       return payment.paymentProcessor(request);

    }
}
