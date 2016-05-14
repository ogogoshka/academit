import ru.academit.novikov.vector.Vector;

import static ru.academit.novikov.vector.Vector.*;

public class MainVector {
    public static void main(String[] args) {

        double[] array = {1, 2, 3, 4};
        double[] array2 = {3, 2, 3, 4};

        Vector v1 = new Vector(2, array);
        System.out.println(v1.toString());

        Vector v2 = new Vector(3, array2);
        System.out.println(v2.toString());

        System.out.println(minus(v1, v2).toString());


    }
}