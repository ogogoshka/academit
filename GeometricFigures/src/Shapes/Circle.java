package Shapes;

class Circle extends Shape {

    private double diameterCircle;

    Circle(double diameterCircle) {
        this.diameterCircle = diameterCircle;
    }

    double getWidth() {
        return diameterCircle;
    }

    void setWidth(double diameterCircle) {
        if (diameterCircle >= 0) {
            this.diameterCircle = diameterCircle;
        } else {
            System.out.println("Размеры круга не могут быть отрицательными");
        }
    }

    double getHeight() {
        return diameterCircle;
    }

    void setHeight(double diameterCircle) {
        if (diameterCircle >= 0) {
            this.diameterCircle = diameterCircle;
        } else {
            System.out.println("Размеры круга не могут быть отрицательными");
        }
    }

    double getArea() {
        return Math.PI * diameterCircle * diameterCircle / 4;
    }
}