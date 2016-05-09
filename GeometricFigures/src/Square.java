class Square extends Shape {

    private double heightSquare;
    private double widthSquare;

    Square(double widthSquare) {
        if (widthSquare >= 0) {
            this.widthSquare = widthSquare;
        } else {
            System.out.println("Размеры квадрата не могут быть отрицательными");
        }
    }

    public double getWidth() {
        return widthSquare;
    }

    public void setWidth(double widthSquare) {
        if (widthSquare < 0) {
            System.out.println("Размеры квадрата не могут быть отрицательными");
        } else {
            this.widthSquare = widthSquare;
        }
    }

    public double getHeight() {
        return heightSquare;
    }

    public void setHeight(double heightSquare) {
        if (heightSquare < 0) {
            System.out.println("Размеры квадрата не могут быть отрицательными");
        } else {
            this.heightSquare = heightSquare;
        }
    }

    double getArea() {
        return widthSquare * widthSquare;
    }
}