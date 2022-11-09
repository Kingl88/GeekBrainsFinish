package ru.gb.homework_one;

import java.util.ArrayList;
import java.util.List;

public class PartTwo {
    public static void main(String[] args) {
        List<Figure> figureList = new ArrayList<>();
        figureList.add(new Circle(5));
        figureList.add(new Triangle(2, 3));
        figureList.add(new Square(10));
        for(Figure figure : figureList){
            figure.calcPerimeter();
            figure.calcArea();
            figure.draw();
            System.out.println("---------------------------------------------");
        }

    }
}

interface Figure {
    void calcPerimeter();

    void calcArea();

    void draw();
}

class Square implements Figure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void calcPerimeter() {
        System.out.println("Периметр квадрата равен = " + side * 4);
    }

    @Override
    public void calcArea() {
        System.out.println("Площадь квадрата равна = " + side * side);
    }

    @Override
    public void draw() {
        System.out.println("Рисуем квадрат");
    }
}

class Triangle implements Figure {
    private double side1;
    private double side2;

    public Triangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public void calcPerimeter() {
        System.out.println("Периметр треугольника равен = " + (Math.sqrt(side1 * side1 + side2 * side2) + side1 + side2));
    }

    @Override
    public void calcArea() {
        System.out.println("Площадь треугольника равна = " + side1 * side2 / 2);
    }

    @Override
    public void draw() {
        System.out.println("Рисуем треугольник");
    }
}

class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calcPerimeter() {
        System.out.println("Периметр круга равен = " + 2 * Math.PI * radius);
    }

    @Override
    public void calcArea() {
        System.out.println("Площадь круга равна = " + Math.PI * radius * radius);
    }

    @Override
    public void draw() {
        System.out.println("Рисуем круг");
    }
}
