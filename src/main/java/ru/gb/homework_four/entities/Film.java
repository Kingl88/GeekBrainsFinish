package ru.gb.homework_four.entities;

public class Film {
    private int id;
    private String name;
    private Duration duration;

    public Film(String name, Duration duration) {
        this.name = name;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration.getMinute();
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration.getMinute() +
                '}';
    }
}
