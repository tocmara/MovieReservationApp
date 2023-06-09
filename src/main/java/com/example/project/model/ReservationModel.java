package com.example.project.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservations")
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movie")
    private int movieId;

    @Column(name = "room")
    private int roomId;

    @Column(name = "user")
    private int userId;

    @Column(name = "noOfTickets")
    private int noOfTickets;

    @Column(name = "screeningTime")
    private Date screeningTime;

    public ReservationModel(int id, int movieId, int roomId, int userId, int noOfTickets, Date screeningTime) {
        this.id = id;
        this.movieId = movieId;
        this.roomId = roomId;
        this.userId = userId;
        this.noOfTickets = noOfTickets;
        this.screeningTime = screeningTime;
    }

    public ReservationModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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