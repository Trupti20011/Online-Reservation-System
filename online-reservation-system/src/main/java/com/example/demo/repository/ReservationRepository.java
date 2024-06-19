package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByPnrNumber(String pnrNumber);
}
