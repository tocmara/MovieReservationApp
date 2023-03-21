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
    private MovieModel movie;

    @Column(name = "room")
    private RoomModel room;

    @Column(name = "user")
    private UserModel user;

    @Column(name = "noOfTickets")
    private int noOfTickets;

    @Column(name = "screeningTime")
    private Date screeningTime;

    public ReservationModel(int id, MovieModel movie, RoomModel room, UserModel user, int noOfTickets, Date screeningTime) {
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

    public MovieModel getMovie() {
        return movie;
    }

    public void setMovie(MovieModel movie) {
        this.movie = movie;
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
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
