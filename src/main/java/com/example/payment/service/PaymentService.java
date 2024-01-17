package com.example.payment.service;

import com.example.payment.dto.PaymentDtoResponse;
import com.example.payment.model.Payment;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    ResponseEntity<PaymentDtoResponse> reservePayment(Payment payment);
    void makePayment(Double amount);
    void cancelPaymentReservation(Double amount);
}
