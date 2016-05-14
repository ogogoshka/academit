import ru.academit.novikov.vector.Vector;

public class MainVector {
    public static void main(String[] args) {


        double[] array = {1, 2, 3, 4};

        Vector v44 = new Vector(4, array);
        System.out.println(v44.toString());

        Vector v30 = new Vector(3);
        v30.add(v44);
        //v30.minus(v44);

        System.out.println(v30.toString());




        Vector vSum = new Vector(1);
        System.out.println(vSum);


        Vector v10 = new Vector(6);
        Vector v11 = new Vector(4);

        //v10.add(v10, v11);
        System.out.println(v10.toString());

        Vector v33 = new Vector(v10);
        System.out.println(v33.toString());


        System.out.println();




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