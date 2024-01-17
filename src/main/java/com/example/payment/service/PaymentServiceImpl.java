package com.example.payment.service;

import com.example.payment.dao.AccountRepository;
import com.example.payment.dao.PaymentRepository;
import com.example.payment.dto.PaymentDtoResponse;
import com.example.payment.model.Account;
import com.example.payment.model.Payment;
import com.example.payment.model.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl {

    private final PaymentRepository paymentRepository;
    private final AccountRepository accountRepository;


    @Transactional
    public PaymentDtoResponse reservePayment(Payment payment) {
        Payment paymentNew = new Payment(null, payment.getDebitAccount(), "30301", payment.getAmount(), PaymentStatus.PENDING);
        String debitAccountNumber = payment.getDebitAccount();

        Account debitAccount = accountRepository.findByNumber(debitAccountNumber);
        if (debitAccount == null) {
            throw new IllegalArgumentException("Счет debitAccount не найден в таблице.");
        }

        BigDecimal amount = BigDecimal.valueOf(payment.getAmount());

        if (debitAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Остаток по счету debitAccount недостаточен.");
        }

        paymentRepository.save(paymentNew);

        BigDecimal newBalance = debitAccount.getBalance().subtract(amount);
        debitAccount.setBalance(newBalance);

        PaymentDtoResponse paymentDtoResponse = new PaymentDtoResponse(paymentNew.getId(), "Payment reserved. New payment ID:");
        return paymentDtoResponse;
    }



//    public void makePayment(Double amount) {
//        Payment payment = new Payment(null,amount, COMPLETED);
//        paymentRepository.save(payment);
//    }



//    public void cancelPaymentReservation(Double amount) {
//        Reservation reservation = reservationRepository.findByAmountAndStatus(amount, "RESERVED");
//        if (reservation != null) {
//            reservation.setStatus("CANCELED");
//            reservationRepository.save(reservation);
//        }
//    }

}
