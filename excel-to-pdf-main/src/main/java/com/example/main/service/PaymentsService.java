package com.example.main.service;

import com.example.main.model.Payments;
import com.example.main.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsService {
    @Autowired
    private PaymentsRepository paymentsRepository;

    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }

    public Payments createPayment(Payments payment) {
        return paymentsRepository.save(payment);
    }

    public Optional<Payments> getPaymentById(Long id) {
        return paymentsRepository.findById(id);
    }

    public Payments updatePayment(Long id, Payments payment) {
        return paymentsRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentsRepository.deleteById(id);
    }
}

