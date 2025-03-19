package org.lessons.java.spring.best_of_the_year.controllers;

import org.lessons.java.spring.best_of_the_year.Movie;
import org.lessons.java.spring.best_of_the_year.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

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
        String songsTitles = "";

        for (Song song : songs) {
            songsTitles += song.getTitle() + ", ";
        }

        model.addAttribute("songsTitles", songsTitles);
        return "songs";
    }

    @GetMapping("/movies")
    public String getMoviesPage(Model model) {
        Movie[] movies = getBestMovies();
        String moviesTitles = "";

        for (Movie movie : movies) {
            moviesTitles += movie.getTitle() + ", ";
        }

        model.addAttribute("moviesTitles", moviesTitles);
        return "movies";
    }

}
