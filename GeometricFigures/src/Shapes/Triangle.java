package Shapes;

public class Triangle extends Shape {

    private double x1;
    private double y1;

    private double x2;
    private double y2;

    private double x3;
    private double y3;

    private double width;
    private double height;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.x3 = x3;
        this.y3 = y3;
    }



/*
    double getSquare(double a, double b, double c) {
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
*/

    private double maxX;
    private double minX;

    double getWidth() { //ширина
        if (x1 > x2 && x2 > x3) {
            maxX = x1;
            minX = x3;
        } else if (x2 > x3) {
            minX = x3;
        } else {
            minX = x3;
        }
        return maxX - minX;
    }

    public void setWidth(double x1, double x2, double x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    double getHeight() {
        return 0;
    }

    public void setHeight(double y1, double y2, double y3) {
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getArea() {
        double a = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double b = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        double c = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}
/*
    private static double getLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    private static double getSquare(double a, double b, double c) {
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

        double a = getLength(x1, y1, x2, y2);
        double b = getLength(x2, y2, x3, y3);
        double c = getLength(x1, y1, x3, y3);

        if (a + b <= c || a + c <= b || a + c <= b) {
            System.out.println("Треугольник не существует");
        } else {
            double square = getSquare(a, b, c);
            System.out.println("Площадь треугольника = " + square);
        }


 */
