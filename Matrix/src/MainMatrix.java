import ru.academit.novikov.matrix.Matrix;

import java.util.Vector;

public class MainMatrix {
    public static void main(String[] args) {

        double[] array = {1, 2, 5, 6};
        Vector v5 = new Vector(3, array);


        Matrix m1 = new Matrix(3, 3);
        //System.out.println(m1.toString());


        int[][] ages = new int[10][5];
        double[][] arr1 = {{1, 2}, {5, 6}, {8, 9}};


        Matrix m2 = new Matrix(arr1);
        System.out.println(m2.toString());

        //double[][] temp = new double[arr1.length][arr1.length];

        //System.arraycopy(arr1, 0, temp, 0, arr1.length);

        //System.out.println(arr1.length + " x " + arr1[0].length);

        Matrix m3 = new Matrix(m2);

        //System.out.println(m3.toString());

        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(temp));

        //System.out.println("ages.length = " + ages.length);
        //System.out.println("ages[0].length = " + ages[0].length);

        //int[][] temp2;
        //temp2 = m1.getSize();

        //System.out.println(Arrays.toString(m1.getSize()));
        //System.out.println(Arrays.toString(temp2));
        //m1.getSize2();
        System.out.println(m2.getSize2().toString());

        //m2.getVectorLine(1);
        //System.out.println(m2.getVectorLine(1).toString());

        //m2.getTranspose();
        //System.out.println(m2.getTranspose().toString());

        //m2.multScalar(2);
        System.out.println(m2.multScalar(3).toString());

        System.out.println(m2.getVectorLine2(1).toString());


    }
}
