package ru.academit.novikov.shapes;

public class Triangle extends Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    private static double getLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = getLength(x1, y1, x2, y2);
        double b = getLength(x2, y2, x3, y3);
        double c = getLength(x1, y1, x3, y3);

        if (a + b <= c || a + c <= b || a + c <= b) {
            throw new IllegalArgumentException("Треугольник не существует");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    //ширина треугольника
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    //длина треугольника
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    public double getArea() {
        double a = getLength(x1, y1, x2, y2);
        double b = getLength(x2, y2, x3, y3);
        double c = getLength(x1, y1, x3, y3);
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}