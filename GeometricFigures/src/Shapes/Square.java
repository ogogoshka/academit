package Shapes;

public class Square extends Shape {

    private double sideOfSquare;

    public Square(double sideOfSquare) {
        if (sideOfSquare >= 0) {
            this.sideOfSquare = sideOfSquare;
        } else {
            System.out.println("Размеры квадрата не могут быть отрицательными");
        }
    }

    public double getWidth() {
        return sideOfSquare;
    }

    public void setWidth(double sideOfSquare) {
        if (sideOfSquare < 0) {
            System.out.println("Размеры квадрата не могут быть отрицательными");
        } else {
            this.sideOfSquare = sideOfSquare;
        }
    }

    public double getHeight() {
        return sideOfSquare;
    }

    public void setHeight(double sideOfSquare) {
        if (sideOfSquare < 0) {
            System.out.println("Размеры квадрата не могут быть отрицательными");
        } else {
            this.sideOfSquare = sideOfSquare;
        }
    }

    public double getArea() {
        return sideOfSquare * sideOfSquare;
    }
}