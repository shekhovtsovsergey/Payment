package com.example.payment.dao;

import com.example.payment.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Reservation findByAmountAndStatus(Double amount, String status);

}

