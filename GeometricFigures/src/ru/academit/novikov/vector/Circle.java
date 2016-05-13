package ru.academit.novikov.vector;

public class Circle extends Shape {

    private double diameter;

    public Circle(double diameter) {
        if (diameter < 0) {
            throw new IllegalArgumentException("Диаметр не могжет быть отрицательным");
        }
        this.diameter = diameter;
    }

    public double getWidth() {
        return diameter;
    }

    public double getHeight() {
        return diameter;
    }

    public double getArea() {
        return Math.PI * diameter * diameter / 4;
    }
}