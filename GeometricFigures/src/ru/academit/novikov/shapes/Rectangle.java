package ru.academit.novikov.shapes;

public class Rectangle extends Shape {

    private double heightRectangle;
    private double widthRectangle;

    public Rectangle(double heightRectangle, double widthRectangle) {
        if (heightRectangle < 0 || widthRectangle < 0)
            throw new IllegalArgumentException("Размеры прямоугольника не могут быть отрицательными");
        this.heightRectangle = heightRectangle;
        this.widthRectangle = widthRectangle;
    }

    public double getHeight() {
        return heightRectangle;
    }

    public double getWidth() {
        return widthRectangle;
    }

    public double getArea() {
        return heightRectangle * widthRectangle;
    }
}