package org.lessons.java.spring.best_of_the_year;

public class Song {

    // # Variabili
    private int id;
    private String title;

    // # Costruttori
    public Song() {
    }

    public Song(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // # Getter / Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // # Metodi

    @Override
    public String toString() {
        return id + " - " + title;
    }

}
