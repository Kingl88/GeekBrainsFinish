package ru.gb.homework_four.entities;

public class Price {
    private int id;
    private int cost;

    public Price(int id, int price) {
        this.id = id;
        this.cost = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", price=" + cost +
                '}';
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
