package com.example.project.controller;

import com.example.project.dto.Movie;
import com.example.project.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @PostMapping("/movie")
    public Movie create(@RequestBody Movie movie){
        return movieService.createMovie(movie);// returnează createMovie din movieService
    }
    @GetMapping("/movie")
    public List<Movie> findAll() {
        return movieService.findAll();
    }
    @DeleteMapping("/movie/{movieId}")
    public void delete(@PathVariable int movieId){
        movieService.delete(movieId);
    }

}
