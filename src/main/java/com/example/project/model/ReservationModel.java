package com.example.project.model;

import com.example.project.dto.Movie;
import com.example.project.dto.Room;
import com.example.project.dto.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservations")
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movie")
    private Movie movie;

    @Column(name = "room")
    private Room room;

    @Column(name = "user")
    private User user;

    @Column(name = "noOfTickets")
    private int noOfTickets;

    @Column(name = "screeningTime")
    private Date screeningTime;

    public ReservationModel(int id, Movie movie, Room room, User user, int noOfTickets, Date screeningTime) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.user = user;
        this.noOfTickets = noOfTickets;
        this.screeningTime = screeningTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
