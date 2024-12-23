package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.service.PaymentService;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create-intent")
    public PaymentIntent createPaymentIntent(@RequestParam("amount") long amount){
        try {
            return paymentService.createPaymentIntent(amount);
        } catch (Exception e) {
            throw new RuntimeException("Error creating payment intent", e);
        }
    };

    @PostMapping(value = "/confirm-payemnt")
    public String confirmPayment(@RequestBody String paymentIntentId){
        return "Payment confirmed";
    }
}
