import ru.academit.novikov.vector.Vector;

import static ru.academit.novikov.vector.Vector.difference;
import static ru.academit.novikov.vector.Vector.scalarMultiplication;
import static ru.academit.novikov.vector.Vector.sum;

public class MainVector {
    public static void main(String[] args) {

        double[] array = {1, 2, 3, 4};
        double[] array2 = {1, 2, 3, 4};

        Vector v1 = new Vector(6, array);
        System.out.println(v1.toString());

        Vector v2 = new Vector(6, array2);
        System.out.println(v2.toString());

        boolean bool = v1.equals(v2);
        System.out.println(bool);

        v1.multiplicationByScalar(2);
        System.out.println(v1.toString());

        Vector v3 = new Vector(6);
        Vector v4 = new Vector(v1);
        System.out.println(v3.toString());
        System.out.println(v4.toString());

        v3.add(v4);
        v1.minus(v4);
        v2.reverse();
        v1.getVectorLength();
        v1.getComponent(0);
        v1.setComponent(1, 11);
        scalarMultiplication(v1, v2);
        sum(v1, v2);
        difference(v1, v2);


    }
}