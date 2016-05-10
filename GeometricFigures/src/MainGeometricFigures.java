import Shapes.Triangle;

public class MainGeometricFigures {

    public static void main(String[] args) {

        Triangle triangle = new Triangle(2, 1, 2, 5, 6, 1);
        System.out.println(triangle.getArea());

        System.out.println(triangle.getWidth());
        System.out.println(triangle.getHeight());

        Triangle triangle2 = new Triangle(2, 1, 3, 1, 6, 1);

    }
}