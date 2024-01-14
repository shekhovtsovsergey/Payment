package com.example.payment.service;

import com.example.payment.dao.PaymentRepository;
import com.example.payment.dao.ReservationRepository;
import com.example.payment.model.Payment;
import com.example.payment.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl {

    private final PaymentRepository paymentRepository;
    private final ReservationRepository reservationRepository;

    @Transactional
    public void reservePayment(Double amount) {
        Payment payment = new Payment(null, amount,"RESERVED");
        paymentRepository.saveAndFlush(payment);

        Reservation reservation = new Reservation(payment.getId(), payment, amount, "RESERVED");
        reservationRepository.save(reservation);
    }

    @Transactional
    public void makePayment(Double amount) {
        Payment payment = new Payment(null,amount, "PAID");
        paymentRepository.save(payment);

        Reservation reservation = new Reservation(payment.getId(), payment, amount, "PAID");
        reservationRepository.save(reservation);
    }

    @Transactional
    public void cancelPaymentReservation(Double amount) {
        Reservation reservation = reservationRepository.findByAmountAndStatus(amount, "RESERVED");
        if (reservation != null) {
            reservation.setStatus("CANCELED");
            reservationRepository.save(reservation);
        }
    }

}
