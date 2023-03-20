package com.example.project.dto;

public class Movie {

    private String name;
    private String genre;
    private int durationInMinutes;
    private int price;

    public Movie(String name, String genre, int durationInMinutes, int price) {
        this.name = name;
        this.genre = genre;
        this.durationInMinutes = durationInMinutes;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
