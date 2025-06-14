package com.design_pattern.proxy.service;

import com.design_pattern.proxy.model.CreditCardValidatorProxy;
import com.design_pattern.proxy.model.ICreditCardValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidationService {

    private ICreditCardValidation validator;

    @Autowired
    public CreditCardValidationService(CreditCardValidatorProxy validator) {
        this.validator = validator;
    }

    public boolean validateCard(String cardNumber) {
       return validator.validateCard(cardNumber);
    }


}
