package com.example.payment.service;

public interface PaymentService {

    void reservePayment(Double amount);

    void makePayment(Double amount);

    void cancelPaymentReservation(Double amount);
}
