package ru.gb.homework_four.entities;

public enum Duration {
    LOW(60), MEDIUM(90), LONG(120);
    private final int minute;

    public int getMinute() {
        return minute;
    }

    Duration(int minute) {
        this.minute = minute;
    }
}
