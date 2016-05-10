import Shapes.Triangle;

public class MainGeometricFigures {

    public static void main(String[] args) {

/*        Shapes.Square square = new Shapes.Square(5);
        System.out.println(square.getArea());

        square.setWidth(-10);
        square.setHeight(4);

        square.getHeight();
        square.getWidth();

        System.out.println(square.getHeight());
        System.out.println(square.getWidth());
        System.out.println(square.getArea());


        Shapes.Rectangle rectangle = new Shapes.Rectangle(5, 6);
        System.out.println(rectangle.getArea());

        rectangle.setHeight(5);
        rectangle.setWidth(7);

        System.out.println(rectangle.getHeight());
        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getArea());


        Shapes.Circle circle = new Shapes.Circle(6);
        System.out.println(circle.getArea());

        circle.setHeight(5);
        System.out.println(circle.getHeight());

        circle.setWidth(7);
        System.out.println(circle.getWidth());

        System.out.println(circle.getArea());
        */

        Triangle triangle = new Triangle(2, 1, 2, 5, 6, 1);
        System.out.println(triangle.getArea());

        System.out.println(triangle.getWidth());
        System.out.println(triangle.getHeight());

    }
}