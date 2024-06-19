package com.example.demo.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Reservation;
import com.example.demo.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation save(Reservation reservation) {
        reservation.setPnrNumber(UUID.randomUUID().toString());
        return reservationRepository.save(reservation);
    }

    public Reservation findByPnrNumber(String pnrNumber) {
        return reservationRepository.findByPnrNumber(pnrNumber);
    }

    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}
