package com.example.project.service;


import com.example.project.dto.Reservation;
import com.example.project.model.ReservationModel;
import com.example.project.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

//    public Reservation createReservation(Reservation reservation)
//    {
//
//    }


    private void convertToReservationModel(Reservation reservation)
    {

    }
}
