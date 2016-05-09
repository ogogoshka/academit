class Rectangle extends Shape {

    private double heightRectangle;
    private double widthRectangle;

    Rectangle(double heightRectangle, double widthRectangle) {
        if (heightRectangle >= 0 || widthRectangle >= 0) {
            this.heightRectangle = heightRectangle;
            this.widthRectangle = widthRectangle;
        } else {
            System.out.println("Размеры прямоугольника не могут быть отрицательными");
        }
    }

    double getHeight() {
        return heightRectangle;
    }

    void setHeight(double heightRectangle) {
        if (heightRectangle >= 0) {
            this.heightRectangle = heightRectangle;
        } else {
            System.out.println("Размеры прямоугольника не могут быть отрицательными");
        }
    }

    double getWidth() {
        return widthRectangle;
    }

    void setWidth(double widthRectangle) {
        if (widthRectangle >= 0) {
            this.widthRectangle = widthRectangle;
        } else {
            System.out.println("Размеры прямоугольника не могут быть отрицательными");
        }
    }

    double getArea() {
        return heightRectangle * widthRectangle;
    }
}