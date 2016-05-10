package ru.academit.novikov.shapes;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        if (height < 0 || width < 0) {
            throw new IllegalArgumentException("Размеры прямоугольника не могут быть отрицательными");
        }
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return height * width;
    }
}