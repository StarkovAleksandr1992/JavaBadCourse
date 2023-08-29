package ru.starkov.stream_api.comparable;

import java.util.Objects;

public class Rectangle implements Comparable<Rectangle> {
    private int height;
    private int width;

    private int square;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
        this.square = height * width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public int compareTo(Rectangle o) {
        return this.square - o.square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return square == rectangle.square;
    }

    @Override
    public int hashCode() {
        return Objects.hash(square);
    }

    public int getSquare() {
       return square;
    }
}
