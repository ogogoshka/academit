import ru.academit.novikov.vector.Vector;

import java.util.Arrays;

import static ru.academit.novikov.vector.Vector.difference;
import static ru.academit.novikov.vector.Vector.scalarMultiplication;
import static ru.academit.novikov.vector.Vector.sum;

public class MainVector {
    public static void main(String[] args) {


        double[] array = {1, 2, 3, 4};

        Vector v44 = new Vector(4, array);
        System.out.println(v44.toString());

        Vector v30 = new Vector(4);
        System.out.println(v30.toString());
        //v30.add(v44);
        //v30.minus(v44);

        Vector v1 = new Vector(4);

        sum(v30, v44);
        sum(v30, v44).toString();

        System.out.println(Arrays.toString(sum(v30, v44)));
        System.out.println(sum(v30, v44).toString());

        Vector v2 = new Vector(4, array);
        Vector v3 = new Vector(4);
        System.out.println(Arrays.toString(difference(v2, v3)));


        scalarMultiplication(v2, v3);
        System.out.println(scalarMultiplication(v2, v3));

    }
}


/*

        int[] size = new int[5];
        String resultString = "";

        for (int n = 0; n < 4; n++) {
            size[n] = 0;
            if (n == 0) {
                resultString += size[n];
            } else {
                resultString += " , " + size[n];
            }
        }
        resultString = "{" + resultString + "}";
        System.out.println(resultString);



 */

/*

        int[] ar1 = {1, 2, 3, 4, 5, 6};
        int[] ar2 = {7, 8, 9};
        int[] ar3;

        System.out.println(Arrays.toString(ar1));
        System.out.println(Arrays.toString(ar2));

        if (ar2.length < ar1.length) {
            for (int i = 0; i < ar2.length; i++) {
                ar1[i] = ar1[i] + ar2[i];
            }

            for (int i = ar2.length; i < ar1.length; i++) {
                ar1[i] = ar1[i];
            }

        } else if (ar2.length > ar1.length) {
            for (int i = 0; i < ar1.length; i++) {
                ar2[i] = ar2[i] + ar1[i];
            }

            for (int i = ar1.length; i < ar2.length; i++) {
                ar2[i] = ar2[i];
            }

        } else {
            for (int i = 0; i < ar1.length; i++) {
                ar1[i] = ar1[i] + ar2[i];
            }
        }

        System.out.println(Arrays.toString(ar1));
        System.out.println(Arrays.toString(ar2));



 */