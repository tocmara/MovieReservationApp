package com.example.project.dto;

import java.util.Date;

public class ReservationInput {

    private int reservationId;
    private int movieId;
    private int roomId;
    private int userId;
    private int noOfTickets;
    private Date screeningTime;

    public ReservationInput(int reservationId, int movieId, int roomId, int userId, int noOfTickets, Date screeningTime) {
        this.reservationId = reservationId;
        this.movieId = movieId;
        this.roomId = roomId;
        this.userId = userId;
        this.noOfTickets = noOfTickets;
        this.screeningTime = screeningTime;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public Date getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Date screeningTime) {
        this.screeningTime = screeningTime;
    }
}
