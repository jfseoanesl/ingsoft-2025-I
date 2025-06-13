package com.design_patterns.bridge.controller;

import com.design_patterns.bridge.dto.PaymentRequest;
import com.design_patterns.bridge.dto.PaymentResponse;
import com.design_patterns.bridge.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
//@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> processPayment(@Valid @RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/processors")
    public ResponseEntity<List<String>> getAvailableProcessors() {
        List<String> processors = List.of("PAYPAL", "STRIPE", "MERCADOPAGO", "PSE");
        return ResponseEntity.ok(processors);
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getPaymentTypes() {
        List<String> types = List.of("SIMPLE", "INSTALLMENT", "RECURRING");
        return ResponseEntity.ok(types);
    }
}
