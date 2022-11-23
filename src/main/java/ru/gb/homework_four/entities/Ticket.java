package ru.gb.homework_four.entities;

public class Ticket {
    private int id;
    private FilmSession session;

    public Ticket(int id, FilmSession session) {
        this.id = id;
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FilmSession getSession() {
        return session;
    }

    public void setSession(FilmSession session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", session=" + session +
                '}';
    }
}
