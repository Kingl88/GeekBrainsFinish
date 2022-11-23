package ru.gb.homework_four.entities;

import java.time.LocalTime;

public class FilmSession {
    private int id;
    private LocalTime start;
    private Film film;
    private Price price;

    public FilmSession(LocalTime start, Film film, Price price) {
        this.start = start;
        this.film = film;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FilmSession{" +
                "id=" + id +
                ", start=" + start +
                ", film=" + film +
                ", price=" + price +
                '}';
    }
}
