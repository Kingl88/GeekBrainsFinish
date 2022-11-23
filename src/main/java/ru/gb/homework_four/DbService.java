package ru.gb.homework_four;

import ru.gb.homework_four.db.DbHandler;
import ru.gb.homework_four.entities.Duration;
import ru.gb.homework_four.entities.Film;
import ru.gb.homework_four.entities.FilmSession;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DbService {
    private Connection connection;
    ResultSet resultSet;
    Statement statement;

    public DbService() throws SQLException, ClassNotFoundException {
        this.connection = DbHandler.getInstance().getConnection();
    }

    public void findErrorInTable() throws SQLException {
        FilmSession temp = null;
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT name, duration, start FROM films " +
                "LEFT JOIN durations ON films.duration_id = durations.id " +
                "LEFT JOIN sessions ON films.id = sessions.film_id ORDER BY start");
        while (resultSet.next()) {
            Duration tempDur = getDuration(resultSet.getInt("duration"));
            if (temp == null) {
                temp = new FilmSession(LocalTime.parse(resultSet.getString("start")), new Film(resultSet.getString("name"), tempDur), null);
            } else {
                FilmSession filmSession = new FilmSession(LocalTime.parse(resultSet.getString("start")), new Film(resultSet.getString("name"), tempDur), null);
                if (temp.getStart().plusMinutes(temp.getFilm().getDuration()).isAfter(filmSession.getStart())) {
                    System.out.println("Ошибка в расписании!!! Фильм " + filmSession.getFilm().getName() + " начинается слишком рано!!!");
                    System.out.println();
                }
                temp = filmSession;
            }
            System.out.println("Фильм " + temp.getFilm().getName() + " длиться " + temp.getFilm().getDuration() + " минут " + " начало фильма в " + temp.getStart());
            System.out.println();
        }
        statement.close();
    }

    public void findBreak() throws SQLException {
        class Break implements Comparable<Break> {
            final String filmName;
            final LocalTime startTime;
            final Duration duration;
            final LocalTime startSecondFilm;
            final LocalTime breakTime;

            public Break(String filmName, LocalTime startTime, Duration duration, LocalTime startSecondFilm, LocalTime breakTime) {
                this.filmName = filmName;
                this.startTime = startTime;
                this.duration = duration;
                this.startSecondFilm = startSecondFilm;
                this.breakTime = breakTime;
            }

            @Override
            public int compareTo(Break o) {
                return this.breakTime.compareTo(o.breakTime);
            }

            @Override
            public String toString() {
                return  "Название фильма = '" + filmName + '\'' +
                        ", начало фильма = " + startTime +
                        ", длительность фильма = " + duration.getMinute() +
                        ", начало следующего фильма = " + startSecondFilm +
                        ", время между фильмами =" + breakTime;
            }
        }
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT films.name, duration, start FROM films " +
                "LEFT JOIN durations ON films.duration_id = durations.id " +
                "LEFT JOIN sessions ON films.id = sessions.film_id ORDER BY start");
        FilmSession temp = null;
        List<Break> breaks = new ArrayList<>();
        while (resultSet.next()) {
            Duration tempDur = getDuration(resultSet.getInt("duration"));
            if (temp == null) {
                temp = new FilmSession(LocalTime.parse(resultSet.getString("start")), new Film(resultSet.getString("name"), tempDur), null);
            } else {
                FilmSession filmSession = new FilmSession(LocalTime.parse(resultSet.getString("start")), new Film(resultSet.getString("name"), tempDur), null);
                int breakTime = (filmSession.getStart().getHour() * 60 + filmSession.getStart().getMinute()) - (temp.getStart().getHour() * 60 + temp.getStart().getMinute() + temp.getFilm().getDuration());
                if (breakTime >= 30) {
                    breaks.add(new Break(temp.getFilm().getName(), temp.getStart(), getDuration(temp.getFilm().getDuration()), filmSession.getStart(), LocalTime.of(breakTime / 60, breakTime % 60)));
                }
                temp = filmSession;
            }
        }
        Collections.reverse(breaks);
        for(Break b : breaks){
            System.out.println(b);
        }
    }
    private Duration getDuration(int duration) throws SQLException {
        Duration tempDur = null;
        switch (duration) {
            case 60 -> tempDur = Duration.LOW;
            case 90 -> tempDur = Duration.MEDIUM;
            case 120 -> tempDur = Duration.LONG;
        }
        return tempDur;
    }
}


