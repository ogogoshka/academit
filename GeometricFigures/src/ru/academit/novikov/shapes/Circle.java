package ru.academit.novikov.shapes;

public class Circle extends Shape {

    private double diameterCircle;

    public Circle(double diameterCircle) {
        if (diameterCircle < 0)
            throw new IllegalArgumentException("Диаметр не могжет быть отрицательным");
        this.diameterCircle = diameterCircle;
    }

    public double getWidth() {
        return diameterCircle;
    }

    public double getHeight() {
        return diameterCircle;
    }

    public double getArea() {
        return Math.PI * diameterCircle * diameterCircle / 4;
    }
}