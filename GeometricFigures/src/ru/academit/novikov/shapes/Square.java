package ru.academit.novikov.shapes;

public class Square extends Shape {

    private double width;

    public Square(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Размеры квадрата не могут быть отрицательными");
        }
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return width;
    }

    public double getArea() {
        return width * width;
    }
}