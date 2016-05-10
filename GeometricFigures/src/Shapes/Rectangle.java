package Shapes;

public class Rectangle extends Shape {

    private double heightRectangle;
    private double widthRectangle;

    public Rectangle(double heightRectangle, double widthRectangle) {
        if (heightRectangle >= 0 || widthRectangle >= 0) {
            this.heightRectangle = heightRectangle;
            this.widthRectangle = widthRectangle;
        } else {
            System.out.println("Размеры прямоугольника не могут быть отрицательными");
        }
    }

    public double getHeight() {
        return heightRectangle;
    }

    public void setHeight(double heightRectangle) {
        if (heightRectangle >= 0) {
            this.heightRectangle = heightRectangle;
        } else {
            System.out.println("Размеры прямоугольника не могут быть отрицательными");
        }
    }

    public double getWidth() {
        return widthRectangle;
    }

    public void setWidth(double widthRectangle) {
        if (widthRectangle >= 0) {
            this.widthRectangle = widthRectangle;
        } else {
            System.out.println("Размеры прямоугольника не могут быть отрицательными");
        }
    }

    public double getArea() {
        return heightRectangle * widthRectangle;
    }
}