import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

public class MainMatrix {
    public static void main(String[] args) {

        double[] array = {1, 2, -1};
        double[][] array2 = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        double[][] array3 = {{1, 2, 3}, {4, 5, 6}};

        Matrix ar2 = new Matrix(array3);

        Vector v5 = new Vector(4, array);
        ar2.MultiplicationByVector(v5);

        Matrix m2 = new Matrix(array3);

        System.out.println(m2.getTranspose().toString());

        m2.multiplicationByScalar(2);

        m2.getSize();

        Matrix m3 = new Matrix(ar2);

        m3.getVectorLine(0);
        m3.getVectorColumn(0);

        Vector v22 = new Vector(2, array);

        Matrix m30 = new Matrix(array3);
        Matrix m31 = new Matrix(array2);

        m30.add(m31);

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


    }
}