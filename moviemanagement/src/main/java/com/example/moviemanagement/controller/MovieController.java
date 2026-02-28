package com.example.moviemanagement.controller;

import com.example.moviemanagement.entity.Movie;
import com.example.moviemanagement.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movie-list";
    }

    @GetMapping("/new")
    public String showMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie-form";
    }

    @PostMapping
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return "redirect:/movies";
    }
}