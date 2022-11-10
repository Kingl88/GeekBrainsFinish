package ru.gb.homework_one;
/**
 * Добавил абстрактный класс Engine, что бы выполнялась инверсия зависимостей. Не все методы были переопределены. Так же скорее всего методы open, move, stop, start можно было бы вынести в общий интерфейс или лучше сделать их абстрактными
 * в классе Car, так это стандартные действия для автомобиля.
 * */
interface Moveable {
    void move();
}

interface Stopable {
    void stop();
}

abstract class Engine {
    private String type;
}

abstract class Car {
    private Engine engine;
    private String color;
    private String name;

    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }
    abstract void start();

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class LightWeightCar extends Car implements Moveable {
    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    void start() {
        System.out.println("LightWeightCar is start");
    }

    @Override
    void open() {
        System.out.println("LightWeightCar is open");
    }

    @Override
    public void move() {
        System.out.println("LightWeightCar is moving");
    }
}

class Lorry extends Car implements Moveable, Stopable {
    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move() {
        System.out.println("Lorry is moving");
    }

    @Override
    public void stop() {
        System.out.println("Lorry is stop");
    }

    @Override
    void start() {
        System.out.println("Lorry is start");
    }

    @Override
    void open() {
        System.out.println("Lorry is open");
    }
}
