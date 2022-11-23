package ru.gb.homework_four.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHandler {
    // Константа, в которой хранится адрес подключения
    private static final String CON_STR = "jdbc:sqlite:schedule.s3db";

    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }


    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private DbHandler() throws SQLException, ClassNotFoundException {
        // Регистрируем драйвер, с которым будем работать
        // в нашем случае Sqlite
        Class.forName("org.sqlite.JDBC");
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(CON_STR);
        createDB();
    }

    public void createDB() throws SQLException
    {
        Statement statement = this.connection.createStatement();
        statement.execute("CREATE TABLE if not exists 'durations' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'duration' INT);");
        statement.execute("CREATE TABLE if not exists 'films' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'duration_id' INT, FOREIGN KEY('duration_id') REFERENCES 'durations');");
        statement.execute("CREATE TABLE if not exists 'tickets' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'session_id' INT, FOREIGN KEY('session_id') REFERENCES 'sessions');");
        statement.execute("CREATE TABLE if not exists 'sessions' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'start' text, 'cost_id' INT, 'film_id' INT, FOREIGN KEY('cost_id') REFERENCES 'prices', FOREIGN KEY('film_id') REFERENCES 'films');");
        statement.execute("CREATE TABLE if not exists 'prices' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'cost' INT)  ;");

        System.out.println("Таблица products создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public void writeDB() throws SQLException
    {
        Statement statement = this.connection.createStatement();

        statement.execute("INSERT INTO 'films' ('name', 'duration_id') VALUES ('Аватар', 1); ");
        statement.execute("INSERT INTO 'films' ('name', 'duration_id') VALUES ('Властелин колец', 3); ");
        statement.execute("INSERT INTO 'films' ('name', 'duration_id') VALUES ('Черный адам', 2); ");
        statement.execute("INSERT INTO 'films' ('name', 'duration_id') VALUES ('Быстрее пули', 3); ");
        statement.execute("INSERT INTO 'films' ('name', 'duration_id') VALUES ('Мстители', 1); ");

        statement.execute("INSERT INTO 'prices' ('cost') VALUES ( 100); ");
        statement.execute("INSERT INTO 'prices' ('cost') VALUES ( 200); ");
        statement.execute("INSERT INTO 'prices' ('cost') VALUES ( 350); ");
        statement.execute("INSERT INTO 'prices' ('cost') VALUES ( 400); ");
        statement.execute("INSERT INTO 'prices' ('cost') VALUES ( 550); ");

        statement.execute("INSERT INTO 'durations' ('duration') VALUES (60); ");
        statement.execute("INSERT INTO 'durations' ('duration') VALUES (90); ");
        statement.execute("INSERT INTO 'durations' ('duration') VALUES (120); ");

        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (1); ");
        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (2); ");
        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (3); ");
        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (4); ");
        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (5); ");
        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (1); ");
        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (2); ");
        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (3); ");
        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (4); ");
        statement.execute("INSERT INTO 'tickets' ('session_id') VALUES (5); ");

        statement.execute("INSERT INTO 'sessions' ('start', 'cost_id', 'film_id') VALUES ('12:00:00', 1, 1); ");
        statement.execute("INSERT INTO 'sessions' ('start', 'cost_id', 'film_id') VALUES ('16:30:00', 4, 2); ");
        statement.execute("INSERT INTO 'sessions' ('start', 'cost_id', 'film_id') VALUES ('11:00:00', 3, 3); ");
        statement.execute("INSERT INTO 'sessions' ('start', 'cost_id', 'film_id') VALUES ('13:00:00', 5, 5); ");
        statement.execute("INSERT INTO 'sessions' ('start', 'cost_id', 'film_id') VALUES ('10:30:00', 2, 4); ");
        statement.execute("INSERT INTO 'sessions' ('start', 'cost_id', 'film_id') VALUES ('13:30:00', 5, 3); ");

        System.out.println("Таблица заполнена");
    }

    // -------- Вывод таблицы--------

    // --------Закрытие--------
    public void closeDB() throws ClassNotFoundException, SQLException
    {
        connection.close();

        System.out.println("Соединения закрыты");
    }


}
