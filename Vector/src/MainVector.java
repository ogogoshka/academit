import ru.academit.novikov.vector.Vector;

public class MainVector {
    public static void main(String[] args) {


        Vector vector = new Vector(7);
        Vector v2 = new Vector(3);
        Vector v3 = new Vector(3);
        Vector v4 = new Vector(4);

        System.out.println(vector.getSize());

        System.out.println("vector = " + vector.toString());

        v2.getMultiplicationVectorByScalar(5);
        System.out.println("v2 = " + v2.toString());

        v3.getVectorReversal();
        System.out.println("v3 = " + v3.toString());

        System.out.println("v4 = " + v4.toString());
        v4.getAdditionOfVector(v4, v3);

        System.out.println("v4 = " + v4.toString());


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