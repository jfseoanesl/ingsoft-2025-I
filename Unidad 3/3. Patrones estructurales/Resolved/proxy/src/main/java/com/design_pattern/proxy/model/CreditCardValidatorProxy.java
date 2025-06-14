package com.design_pattern.proxy.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CreditCardValidatorProxy implements ICreditCardValidation{

    @Autowired
    private CreditCardValidator creditCardValidator;
    private Map<String, Boolean> cache = new HashMap<String, Boolean>();

    @Override
    public boolean validateCard(String cardNumber) {
        if(cache.containsKey(cardNumber)){
            return cache.get(cardNumber);
        }

        boolean result = creditCardValidator.validateCard(cardNumber);
        cache.put(cardNumber, result);
        return result;
    }
}
