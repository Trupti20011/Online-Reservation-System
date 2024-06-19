package com.example.demo.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cancellation;
import com.example.demo.Entity.Reservation;
import com.example.demo.repository.CancellationRepository;
import com.example.demo.repository.ReservationRepository;

@Service
public class CancellationService {
    @Autowired
    private CancellationRepository cancellationRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Cancellation cancelReservation(String pnrNumber) {
        Reservation reservation = reservationRepository.findByPnrNumber(pnrNumber);
        if (reservation != null) {
            Cancellation cancellation = new Cancellation();
            cancellation.setReservation(reservation);
            cancellation.setCancellationDate(new Date());
            cancellationRepository.save(cancellation);
            reservationRepository.delete(reservation);
            return cancellation;
        }
        return null;
    }
}
