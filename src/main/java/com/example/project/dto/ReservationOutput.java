package com.example.project.dto;

import java.util.Date;

public class ReservationOutput {

    private int reservationId;
    private Movie movie;
    private Room room;
    private User user;
    private int noOfTickets;
    private Date screeningTime;

    public ReservationOutput(int reservationId, Movie movie, Room room, User user, int noOfTickets, Date screeningTime) {
        this.reservationId = reservationId;
        this.movie = movie;
        this.room = room;
        this.user = user;
        this.noOfTickets = noOfTickets;
        this.screeningTime = screeningTime;
    }

    public ReservationOutput() {

    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
