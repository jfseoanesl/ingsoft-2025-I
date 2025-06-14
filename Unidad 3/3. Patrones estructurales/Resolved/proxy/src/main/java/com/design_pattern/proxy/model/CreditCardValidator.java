package com.design_pattern.proxy.model;

import org.springframework.stereotype.Component;

@Component
public class CreditCardValidator implements ICreditCardValidation{

    @Override
    public boolean validateCard(String cardNumber) {
        simulateExternalCall();
        System.out.println("Validating card: " + cardNumber);
        return cardNumber.startsWith("4"); // Visa dummy rule
    }

    private void simulateExternalCall() {
        try {
            Thread.sleep(3000); // Simula tiempo de red (3 seg)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
