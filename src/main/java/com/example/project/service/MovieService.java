package com.example.project.service;

import com.example.project.dto.Movie;
import com.example.project.model.MovieModel;
import com.example.project.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Movie createMovie(Movie movie){
        MovieModel movieModel = convertToMovieModel(movie);

        MovieModel savedMovieModel = movieRepository.save(movieModel);
        Movie createdMovie = convertToMovie(savedMovieModel);

        return createdMovie;
    }

    public List<Movie> findAll(){
       return movieRepository.findAll()//lista de movie models
               .stream() // movie model
               .map(this::convertToMovie) //movie
               .toList(); // list movie
    }

    public void delete(int movieId){
        MovieModel movieModel = movieRepository.findById(movieId)
                .orElse( new MovieModel());

        movieRepository.deleteById(movieId);
    }

    private MovieModel convertToMovieModel(Movie movie){
        MovieModel movieModel = new MovieModel();

        movieModel.setName(movie.getName());
        movieModel.setGenre(movie.getGenre());
        movieModel.setPrice(movie.getPrice());
        movieModel.setDurationInMinutes(movie.getDurationInMinutes());

        return movieModel;
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
}
