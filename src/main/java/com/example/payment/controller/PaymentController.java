package com.example.payment.controller;

import com.example.payment.service.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    @PostMapping("/reserve")
    public ResponseEntity<String> reservePayment(@RequestBody Double amount) {
        paymentService.reservePayment(amount);
        return ResponseEntity.ok("Payment reserved.");
    }

    @PostMapping("/pay")
    public ResponseEntity<String> makePayment(@RequestBody Double amount) {
        paymentService.makePayment(amount);
        return ResponseEntity.ok("Payment made.");
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancelPaymentReservation(@RequestBody Double amount) {
        paymentService.cancelPaymentReservation(amount);
        return ResponseEntity.ok("Payment reservation canceled.");
    }

}