package Shapes;

public class Circle extends Shape {

    private double diameterCircle;

    public Circle(double diameterCircle) {
        this.diameterCircle = diameterCircle;
    }

    public double getWidth() {
        return diameterCircle;
    }

    public void setWidth(double diameterCircle) {
        if (diameterCircle >= 0) {
            this.diameterCircle = diameterCircle;
        } else {
            System.out.println("Размеры круга не могут быть отрицательными");
        }
    }

    public double getHeight() {
        return diameterCircle;
    }

    public void setHeight(double diameterCircle) {
        if (diameterCircle >= 0) {
            this.diameterCircle = diameterCircle;
        } else {
            System.out.println("Размеры круга не могут быть отрицательными");
        }
    }

    public double getArea() {
        return Math.PI * diameterCircle * diameterCircle / 4;
    }
}