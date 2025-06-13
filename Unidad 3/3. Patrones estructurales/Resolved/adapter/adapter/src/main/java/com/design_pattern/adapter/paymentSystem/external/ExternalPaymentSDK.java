package com.design_pattern.adapter.paymentSystem.external;

import org.springframework.stereotype.Component;

@Component
public class ExternalPaymentSDK {

    public String pay(String account, double value, String currency) {

        return "Pago EXTERNO procesado para cuenta: " + account + ", monto: " + value + ", moneda: " + currency;

    }

}
