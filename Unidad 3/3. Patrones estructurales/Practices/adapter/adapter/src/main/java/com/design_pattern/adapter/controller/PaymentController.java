package com.design_pattern.adapter.controller;

import com.design_pattern.adapter.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public String processPayment(@RequestParam String customerId, @RequestParam double amount) {

        String result=paymentService.process(customerId, amount);

        return "Resultado de operacion: " + result;
    }
}
