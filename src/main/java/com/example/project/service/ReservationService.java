package com.example.project.service;


import com.example.project.dto.*;
import com.example.project.model.MovieModel;
import com.example.project.model.ReservationModel;
import com.example.project.model.RoomModel;
import com.example.project.model.UserModel;
import com.example.project.repository.MovieRepository;
import com.example.project.repository.ReservationRepository;
import com.example.project.repository.RoomRepository;
import com.example.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public ReservationOutput createReservation(ReservationInput reservationInput)
    {
        ReservationModel reservationModel = convertToReservationModel(reservationInput);
        ReservationModel savedReservationModel = reservationRepository.save(reservationModel);
        ReservationOutput createdReservationOutput = convertToReservationOutput(savedReservationModel);

        return createdReservationOutput;
    }

    public List<ReservationOutput> findAll()
    {
        return reservationRepository.findAll()
                .stream()
                .map(this::convertToReservationOutput)
                .toList();
    }
    public void delete(int reservationId) {reservationRepository.deleteById(reservationId);}

    private ReservationModel convertToReservationModel(ReservationInput reservationInput)
    {
        ReservationModel reservationModel = new ReservationModel();

        reservationModel.setNoOfTickets(reservationInput.getNoOfTickets());
        reservationModel.setMovieId(reservationInput.getMovieId());
        reservationModel.setScreeningTime(reservationInput.getScreeningTime());
        reservationModel.setRoomId(reservationInput.getRoomId());
        reservationModel.setUserId(reservationInput.getUserId());

        return reservationModel;
    }

    private ReservationOutput convertToReservationOutput(ReservationModel reservationModel)
    {
        ReservationOutput reservationOutput = new ReservationOutput();

        RoomModel roomModel = roomRepository.findById(reservationModel.getRoomId())
                .orElse(new RoomModel());
        MovieModel movieModel =movieRepository.findById(reservationModel.getMovieId())
                .orElse( new MovieModel());
        UserModel userModel = userRepository.findById(reservationModel.getUserId())
                .orElse(new UserModel());


        reservationOutput.setReservationId(reservationModel.getId());
        reservationOutput.setRoom(convertToRoom(roomModel));
        reservationOutput.setMovie(convertToMovie(movieModel));
        reservationOutput.setUser(convertToUser(userModel));
        reservationOutput.setNoOfTickets(reservationModel.getNoOfTickets());
        reservationOutput.setScreeningTime(reservationModel.getScreeningTime());

        return reservationOutput;
    }

    private Room convertToRoom(RoomModel roomModel)
    {
        Room room = new Room();
        room.setName(roomModel.getName());
        room.setCapacity(roomModel.getCapacity());

        return room;
    }

    private Movie convertToMovie(MovieModel movieModel)
    {
        Movie movie = new Movie();

        movie.setName(movieModel.getName());
        movie.setGenre(movieModel.getGenre());
        movie.setPrice(movieModel.getPrice());
        movie.setDurationInMinutes(movieModel.getDurationInMinutes());

        return movie;

    }

    private User convertToUser(UserModel usermodel)
    {
        User user = new User();
        user.setName(usermodel.getName());
        user.setDate(usermodel.getDateOfBirth());
        user.setEmail(usermodel.getEmail());

        return user;
    }
}
