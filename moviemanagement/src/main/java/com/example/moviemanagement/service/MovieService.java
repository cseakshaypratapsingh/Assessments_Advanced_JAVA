package com.example.moviemanagement.service;

import com.example.moviemanagement.entity.Movie;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    void saveMovie(Movie movie);
    Movie getMovieById(Long id);
    void deleteMovieById(Long id);
}