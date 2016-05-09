public class Circle extends Shape {

    private double diameterCircle;

    public Circle(double diameterCircle) {
        this.diameterCircle = diameterCircle;
    }

    double getWidth() {
        return 0;
    }

    double getHeight() {
        return 0;
    }

    double getArea() {
        return 0;
    }

    /*
    @Override
    private double getWidth() {
        return diameterCircle / 2;
    }

    @Override
    private double getHeight() {
        return diameterCircle / 2;
    }

    @Override
    double getArea() {
        return Math.PI * getWidth() * getHeight();
    }
    */
}