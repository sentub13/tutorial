package com.example.main.controller;

import com.example.main.model.Payments;
import com.example.main.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
    @Autowired
    private PaymentsRepository paymentsRepository;

    @GetMapping
    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }

    @PostMapping
    public Payments createPayment(@RequestBody Payments payment) {
        return paymentsRepository.save(payment);
    }

    @GetMapping("/{id}")
    public Payments getPaymentById(@PathVariable Long id) {
        return paymentsRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Payments updatePayment(@PathVariable Long id, @RequestBody Payments payment) {
        return paymentsRepository.save(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentsRepository.deleteById(id);
    }
}
