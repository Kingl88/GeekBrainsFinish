package ru.gb.homework_four;

import ru.gb.homework_four.db.DbHandler;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DbService service = new DbService();
        DbHandler dbHandler = DbHandler.getInstance();
        dbHandler.writeDB();
        service.findErrorInTable();
        service.findBreak();
        dbHandler.closeDB();
    }

}
