import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

import static ru.academit.novikov.matrix.Matrix.minus;
import static ru.academit.novikov.matrix.Matrix.multiplication;

public class MainMatrix {
    public static void main(String[] args) {
        Matrix test = new Matrix();

        double[][] array = {{1, 2, -1}};
        double[][] array2 = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        double[][] array3 = {{1, 2, 3}, {4, 5, 6}};

        Matrix m1 = new Matrix(3, 3);
        System.out.println(m1.toString());

        Matrix m2 = new Matrix(array);
        Matrix m3 = new Matrix(array2);
        Matrix m4 = new Matrix(array3);
        Matrix m5 = new Matrix(m3);

        double[] arr = {1, 2, -1};

        Vector[] newVector = new Vector[2];
        newVector[0] = new Vector(3, arr);
        newVector[1] = new Vector(3, arr);

        Matrix m6 = new Matrix(newVector);
        System.out.println(m6.toString());

        double[] array6 = {6, 7, 8};
        Vector v6 = new Vector(3, array6);

        m6.setVectorLine(0, v6);
        System.out.println(m6.toString());
        m6.multiplicationByScalar(2);
        System.out.println(m6.toString());
        System.out.println(m3.toString());
        //System.out.println(m4.toString());
        //m6.add(m4);
        //System.out.println(m6.add(m3).toString());
        System.out.println(m6.minus(m3).toString());

        //m3.getVectorColumn(1);
        System.out.println(m3.getVectorColumn(1).toString());

        System.out.println(m6.transpose().toString());

        double[][] arrayTestM = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        double[] arrayTestV = {1, 2, -1};
        Vector v7 = new Vector(3, arrayTestV);
        Matrix m7 = new Matrix(arrayTestM);
        //m7.multiplicationByVector(v7);
        System.out.println(m7.multiplicationByVector(v7).toString());

        //add(m6, m7);
        minus(m6, m7);

        double[][] array8 = {{3, 1, 2}, {0, -1, 4}};
        double[][] array9 = {{-1, 1}, {2, 0}, {0, 3}};

        Matrix m8 = new Matrix(array8);
        Matrix m9 = new Matrix(array9);

        m8.getRowsNumber();
        m8.getNumbersOfColumn();
        m8.getVectorLine(0);

        System.out.println(multiplication(m8, m9).toString());

        double[][] array10 = {{-6, -3}, {-10, -4}};
        Matrix m10 = new Matrix(array10);
        System.out.println(m10.getDeterminant());

        System.out.println(m10.transpose().toString());

        Matrix m11 = new Matrix(m10);
        System.out.println(m11.toString());

        double[][] array12 = {{-6, -3, 2, 3}, {-10, -4}};
        Matrix m12 = new Matrix(array12);
        System.out.println(m12.toString());

        System.out.println(m11.add(m12).toString());

/*


        Matrix ar2 = new Matrix(array3);

        Vector v5 = new Vector(3, array);

        Matrix m2 = new Matrix(array2);
        System.out.println("row = " + m2.getRow() + "column = " + m2.getColumn());
        System.out.println("m2.getVectorLine(0) = " + m2.getVectorLine(0));
        System.out.println("m2.getVectorColumn(0) = " + m2.getVectorColumn(0));
        //System.out.println("ar2.transpose(0) = " + ar2.transpose());

        ar2.MultiplicationByVector(v5);

        ar2.setVectorLine(0, v5);

        add(ar2, m2);
        minus(ar2, m2);


        //System.out.println(m2.transpose().toString());

        m2.multiplicationByScalar(2);


        Matrix m3 = new Matrix(ar2);

        m3.getVectorLine(0);
        m3.getVectorColumn(0);

        Vector v22 = new Vector(2, array);

        Matrix m30 = new Matrix(array3);
        Matrix m31 = new Matrix(array2);

        double[][] array40 = {{1, 2}, {3, 4}, {5, 6}};
        double[][] array41 = {{1, 2}, {4, 5}};

        Matrix m40 = new Matrix(array41);
        Matrix m41 = new Matrix(array40);

        double[][] array50 = {{1}, {2}, {3}};
        double[][] array51 = {{1, 2}, {4, 5}};

        double[] array55 = {1, 2, -1};

        double[][] arr1 = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        double[] arr2 = {1, 2, -1};

        double[][] arr11 = {{-1, 1}, {2, 0}, {0, 3}};
        double[][] arr12 = {{3, 1, 2}, {0, -1, 4}};

 */
    }
}