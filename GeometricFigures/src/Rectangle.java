public class Rectangle extends Shape {

    private double heightRectangle;
    private double widthRectangle;

    public double getHeightRectangle() {
        return heightRectangle;
    }

    public void setHeightRectangle(double heightRectangle) {
        this.heightRectangle = heightRectangle;
    }

    public double getWidthRectangle() {
        return widthRectangle;
    }

    public void setWidthRectangle(double widthRectangle) {
        this.widthRectangle = widthRectangle;
    }

    public Rectangle(double heightRectangle, double widthRectangle) {
        this.heightRectangle = heightRectangle;
        this.widthRectangle = widthRectangle;
    }


    double getWidth() {
        return widthRectangle;
    }


    double getHeight() {
        return heightRectangle;
    }


    double getArea() {
        return heightRectangle * widthRectangle;
    }
}