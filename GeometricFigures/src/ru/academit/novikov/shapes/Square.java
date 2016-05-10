package ru.academit.novikov.shapes;

public class Square extends Shape {

    private double sideOfSquare;

    public Square(double sideOfSquare) {
        if (sideOfSquare < 0)
            throw new IllegalArgumentException("Размеры квадрата не могут быть отрицательными");
        this.sideOfSquare = sideOfSquare;
    }

    public double getWidth() {
        return sideOfSquare;
    }

    public double getHeight() {
        return sideOfSquare;
    }

    public double getArea() {
        return sideOfSquare * sideOfSquare;
    }
}