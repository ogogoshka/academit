import ru.academit.novikov.vector.Vector;

public class MainVector {
    public static void main(String[] args) {
/*
        String[] animals = {"Хаски", "Морж"};// массив строк 1
        String result1 = animals[0].concat(" ест ").concat(animals[1]);
        System.out.println(result1);

        StringBuffer output = new StringBuffer();
        output.append("Some text");
        for (int i = 0; i < 5; i++) {
            output.append(i);
        }
        System.out.println(output.toString());
 */


        //StringBuilder output3 = new StringBuilder(110);

        //output3.insert(1, "a");

        //StringBuilder output2 = new StringBuilder(111);
        //output2.append("Some text");
        //for (int i = 0; i < 5; i++) {
//            output2.append(i);
//        }
//        System.out.println(output2);
/*

        int[] ar1 = {1, 2};
        int[] ar2 = {3, 4, 5, 6};

        int[] temp = new int[ar2.length];
        //temp = ar1;
        System.out.println(Arrays.toString(temp));

        if (ar1.length < ar2.length) {

            for (int j = 0; j < ar2.length; j++) {
                temp[j] = temp[j] + ar2[j];
            }
            System.out.println(Arrays.toString(temp));

            for (int j = 0; j < ar1.length; j++) {
                temp[j] = temp[j] + ar1[j];
            }
            System.out.println(Arrays.toString(temp));
        }
 */

        int[] array = {1, 2, 3, 4};

        Vector v77 = new Vector(6, array);
        System.out.println(v77.toString());

        Vector v20 = new Vector(2);
        Vector v21 = new Vector(2);


        v20.add(v21);
        System.out.println(v20.toString());

        Vector v10 = new Vector(6);
        Vector v11 = new Vector(4);

        v10.deduct(v11);
        //v10.add(v10, v11);
        System.out.println(v10.toString());

        Vector v33 = new Vector(v10);
        System.out.println(v33.toString());


        System.out.println();

        v10.setComponent(11, 0);

        System.out.println(v10.getComponent(0));
        System.out.println(v10.getComponent(1));
        System.out.println(v10.getComponent(2));
        System.out.println(v10.getComponent(3));
        System.out.println(v10.getComponent(4));
        System.out.println(v10.getComponent(5));


        Vector vector = new Vector(7);
        Vector v2 = new Vector(3);
        //Vector v3 = new Vector(3);
        Vector v4 = new Vector(4);
        Vector v5 = new Vector(5);

        Vector v6 = new Vector(4);
        //Vector v7 = new Vector(3);

        System.out.println(vector.getSize());

        System.out.println("vector = " + vector.toString());

        //v2.getMultiplicationVectorByScalar(5);
        //System.out.println("v2 = " + v2.toString());

        //v3.getVectorReversal();
        //System.out.println("v3 = " + v3.toString());

        //System.out.println("v4 = " + v4.toString());
        //v4.getAdditionOfVector(v4, v3);

        System.out.println("v4 = " + v4.toString());

        System.out.println("v5 = " + v5.toString());

        v6.getVectorLength();
        System.out.println("v6 = " + v6.getVectorLength());

        v6.reverse();
        System.out.println("v6 = " + v6.toString());
        //v2.getSubtractAnotherVector(v2, v4);
        //System.out.println("v2 = " + v2.toString());

        v6.multiplicationByScalar(11);
        System.out.println("v6 = " + v6.toString());

        v2.reverse();
        System.out.println("v2 = " + v2.toString());

        v4.reverse2();
        System.out.println("v4 = " + v4.toString());

        //v2.multiplicationByScalar2(-7);
        System.out.println("v2 = " + v2.toString());

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