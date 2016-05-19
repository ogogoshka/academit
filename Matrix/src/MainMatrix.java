import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.*;

import static ru.academit.novikov.matrix.Matrix.multiplication;

public class MainMatrix {
    public static void main(String[] args) {

        double[] array = {1, 2, -1};
        double[][] array2 = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        double[][] array3 = {{1, 2, 3}, {4, 5, 6}};

        Matrix ar2 = new Matrix(array3);
        //System.out.println(ar2.toString());

        //Matrix ar3 = new Matrix(array3);
        //System.out.println(ar2.toString());

        //System.arraycopy(array2[0], 0, array3[0], 0, array2[0].length);
        Vector v5 = new Vector(4, array);
        ar2.MultiplicationByVector(v5);
        //Matrix m1 = new Matrix(3, 3);
        //System.out.println(m1.toString());
        //int[][] ages = new int[10][5];
        //double[][] arr1 = {{1, 2}, {5, 6}, {8, 9}};

        Matrix m2 = new Matrix(array3);
        //System.out.println(m2.toString());

        System.out.println(m2.getTranspose().toString());

        m2.multiplicationByScalar(2);

        m2.getSize();

        Matrix m3 = new Matrix(ar2);
        //System.out.println(m3.toString());

        m3.getVectorLine(0);
        m3.getVectorColumn(0);
        //System.out.println(m3.getVectorLine(0).toString());

        Matrix m11 = new Matrix();
        Matrix m22 = new Matrix(3, 3);
        //System.out.println(m22.toString());

        Vector v22 = new Vector(2, array);
        m22.setVectorLine(1, v22);

        //System.out.println(m22.toString());

        Matrix m30 = new Matrix(array3);
        Matrix m31 = new Matrix(array2);
        //System.out.println("m30 = " + m30.toString());
        //System.out.println("m31 = " + m31.toString());

        m30.add(m31);
        //System.out.println(m30.toString());

        double[][] array40 = {{1, 2}, {3, 4}, {5, 6}};
        double[][] array41 = {{1, 2}, {4, 5}};

        Matrix m40 = new Matrix(array41);
        Matrix m41 = new Matrix(array40);

        //System.out.println("m40 = " + m40.toString());
        //System.out.println("m41 = " + m41.toString());
        m40.minus(m41);
        //System.out.println("MIN = " + m40.toString());

        //m2.MultiplicationByVector(v5);

        //System.out.println(m2.MultiplicationByVector(v5).toString());

        //System.out.println(m2.toString());

        //double[][] temp = new double[arr1.length][arr1.length];

        //System.arraycopy(arr1, 0, temp, 0, arr1.length);

        //System.out.println(arr1.length + " x " + arr1[0].length);

        //Matrix m3 = new Matrix(m2);

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
        //System.out.println(m2.getSize2().toString());

        //m2.getVectorLine(1);
        //System.out.println(m2.getVectorLine(1).toString());

        m2.getTranspose();
        //System.out.println(m2.getTranspose().toString());
        //m2.multScalar(2);
        //System.out.println(m2.toString());

        //m2.getSize();
        //System.out.println(Arrays.toString(m2.getSize()));

        double[][] array50 = {{1}, {2}, {3}};
        double[][] array51 = {{1, 2}, {4, 5}};

        double[] array55 = {1, 2, -1};

        Vector v50 = new Vector(3, array55);

        Matrix m50 = new Matrix(array50);
        Matrix m51 = new Matrix(array51);

        //System.out.println(m50.MultiplicationByVector(v50));

        double[][] arr1 = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        double[] arr2 = {1, 2, -1};

        double[][] arr11 = {{-1, 1}, {2, 0}, {0, 3}};
        double[][] arr12 = {{3, 1, 2}, {0, -1, 4}};

        Matrix mm50 = new Matrix(arr1);
        Vector vv50 = new Vector(3, arr2);

        Matrix mmm1 = new Matrix(arr11);
        Matrix mmm2 = new Matrix(arr12);

        //System.out.println(mm50.MultiplicationByVector(vv50));

        //mm50.getVectorColumn(1);
        multiplication(mmm1, mmm2);
        //System.out.println(multiplication(mmm1, mmm2).toString());

    }
}
