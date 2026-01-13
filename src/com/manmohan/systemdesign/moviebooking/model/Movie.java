package com.manmohan.systemdesign.moviebooking.model;

public class Movie {
    String movieId;
    String title;
    int durationMinutes;

    public Movie(String movieId, String title, int durationMinutes) {
        this.movieId = movieId;
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
