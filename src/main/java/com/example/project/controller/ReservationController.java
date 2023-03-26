package com.example.project.controller;

import com.example.project.dto.ReservationInput;
import com.example.project.dto.ReservationOutput;
import com.example.project.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping("/reservation")
    private ReservationOutput create(@RequestBody ReservationInput reservationInput){
        return reservationService.createReservation(reservationInput);
    }

    @GetMapping("/reservation")
    public List<ReservationOutput> findAll(){
        return reservationService.findAll();
    }
    @DeleteMapping("/reservation/{reservationId}")
    public void delete(@PathVariable int reservationId) {
        reservationService.delete(reservationId);
    }

}
