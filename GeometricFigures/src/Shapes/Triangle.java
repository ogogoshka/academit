package Shapes;

public class Triangle extends Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double b = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        double c = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        if (a + b <= c || a + c <= b || a + c <= b) {
            System.out.println("Треугольник не существует");
        } else {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }
    }

    //ширина треугольника
    public double getWidth() {
        if (x1 >= x2 && x2 >= x3) {
            return x1 - x3;
        } else if (x2 >= x3 && x3 >= x1) {
            return x2 - x1;
        } else {
            return x3 - x2;
        }
    }

    //длина треугольника
    public double getHeight() {
        if (y1 >= y2 && y2 >= y3) {
            return y1 - y3;
        } else if (y2 >= y3 && y3 >= y1) {
            return y2 - y1;
        } else {
            return y3 - y2;
        }
    }

    public double getArea() {
        double a = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double b = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        double c = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}