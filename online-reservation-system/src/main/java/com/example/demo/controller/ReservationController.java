package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Reservation;
import com.example.demo.services.ReservationService;

@RestController
@RequestMapping("/users/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/book")
    public Reservation bookReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @GetMapping("/{pnrNumber}")
    public Reservation getReservation(@PathVariable String pnrNumber) {
        return reservationService.findByPnrNumber(pnrNumber);
    }
}
