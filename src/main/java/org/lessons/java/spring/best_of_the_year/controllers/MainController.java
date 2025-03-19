package org.lessons.java.spring.best_of_the_year.controllers;

import org.lessons.java.spring.best_of_the_year.Movie;
import org.lessons.java.spring.best_of_the_year.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/")
public class MainController {

    private Song[] getBestSongs() {
        return new Song[] {
            new Song(1, "Bohemian Rhapsody"),
            new Song(2, "Take On Me"),
            new Song(3, "Figli Delle Stelle"),
            new Song(4, "Africa"),
            new Song(5, "Sweet Child O' Mine"),
            new Song(6, "Billie Jean"),
            new Song(7, "Maledetta Primavera"),
            new Song(8, "Stairway to Heaven"),
        };
    }

    private Movie[] getBestMovies() {
        return new Movie[] {
            new Movie(1, "Inception"),
            new Movie(2, "Pulp Fiction"),
            new Movie(3, "The Godfather"),
            new Movie(4, "The Matrix"),
            new Movie(5, "Forrest Gump"),
            new Movie(6, "Kill Bill"),
            new Movie(7, "Fight Club"),
            new Movie(8, "Avatar"),
        };
    }
    
    @GetMapping("/")
    public String getHomePage(Model model, @RequestParam(name = "name") String name) {
        model.addAttribute("name", name);
        return "homepage";
    }

    @GetMapping("/songs")
    public String getSongsPage(Model model) {
        Song[] songs = getBestSongs();

        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/movies")
    public String getMoviesPage(Model model) {
        Movie[] movies = getBestMovies();

        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/songs/{id}")
    public String getSongByIdPage(Model model, @PathVariable("id") int id) {
        Song[] songs = getBestSongs();
        String song = songs[id].toString();

        model.addAttribute("song", song);
        return "songbyid";
    }

    @GetMapping("/movies/{id}")
    public String getMoviesByIdPage(Model model, @PathVariable("id") int id) {
        Movie[] movies = getBestMovies();
        String movie = movies[id].toString();

        model.addAttribute("movie", movie);
        return "moviebyid";
    }

}
