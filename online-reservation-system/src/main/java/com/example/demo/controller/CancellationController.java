package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cancellation;
import com.example.demo.services.CancellationService;

@RestController
@RequestMapping("users/cancellations")
public class CancellationController {
    @Autowired
    private CancellationService cancellationService;

    @PostMapping("/cancel")
    public Cancellation cancelReservation(@RequestParam String pnrNumber) {
        return cancellationService.cancelReservation(pnrNumber);
    }
}
