package com.design_pattern.proxy.controller;

import com.design_pattern.proxy.service.CreditCardValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**| Problema              | Descripción                                                                                                                |
 | --------------------- | -------------------------------------------------------------------------------------------------------------------------- |
 | Costoso               | Cada validación siempre accede al sistema externo (aunque sea la misma tarjeta)                                            |
 | Sin cache             | No hay optimización para validaciones repetidas                                                                            |
 | Sin control de acceso | El controlador no controla si debe o no consultar al proveedor                                                             |
 | Alto acoplamiento     | El controlador conoce directamente la clase que accede al sistema externo                                                  |
 */


@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private CreditCardValidationService validationService;

    @PostMapping("/validate")
    public String validateCard(@RequestParam String cardNumber) {
        boolean valid = validationService.validateCard(cardNumber);
        return valid ? "Card is valid" : "Invalid card";
    }
}
