import ru.academit.novikov.gauss.GaussMethodSolver;
import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

public class MainGaussMethod {
    public static void main(String[] args) {


        double[][] gaussM = {
                {1, 1},
                {2, 2}
        };
        double[] gaussV = {2, 4};

        Matrix matrG = new Matrix(gaussM);
        Vector vecG = new Vector(gaussV);
        GaussMethodSolver gauss = new GaussMethodSolver(matrG, vecG);
        //gauss.solve();

        double[][] gaussM2 = {
                {0, 0},
                {2, 2}
        };
        double[] gaussV2 = {2, 4};

        Matrix matrG2 = new Matrix(gaussM2);
        Vector vecG2 = new Vector(gaussV2);
        GaussMethodSolver gauss2 = new GaussMethodSolver(matrG2, vecG2);
        //gauss2.solve();

        double[][] gaussM3 = {
                {0, 0},
                {2, 2}
        };
        double[] gaussV3 = {0, 4};

        Matrix matrG3 = new Matrix(gaussM3);
        Vector vecG3 = new Vector(gaussV3);
        GaussMethodSolver gauss3 = new GaussMethodSolver(matrG3, vecG3);
        gauss3.solve();

        double[][] gaussM4 = {
                {1, 0},
                {2, 2}
        };
        double[] gaussV4 = {3, 4};

        Matrix matrG4 = new Matrix(gaussM4);
        Vector vecG4 = new Vector(gaussV4);
        GaussMethodSolver gauss4 = new GaussMethodSolver(matrG4, vecG4);
        gauss4.solve();

        double[][] arrM1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Matrix m1 = new Matrix(arrM1);
        System.out.println(m1.toString());

        m1.replaceLine(0, 2);
        System.out.println(m1.toString());

        double[][] test = {
                {0, 1, 1},
                {0, 0, 1},
                {2, 1, 0}
        };

        Matrix mtest = new Matrix(test);

        //System.out.println(GaussMethodSolver.isMatrixContainZeroLine(mtest));
        System.out.println(GaussMethodSolver.isMatrixContainZeroLineExceptLastElement(mtest));

        final double EPSILON = 1e-10;
        Matrix matrix = new Matrix(test);

        //boolean bool = false;
        int count = 0;
        //поиск хотя бы одной строки где все элементы НУЛИ кроме последнего элемента
        //public static boolean isMatrixContainZeroLineExceptLastElement(Matrix matrix) {
        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            for (int j = 0; j < matrix.getColumnsNumber() - 1; j++) {
                if (Math.abs(matrix.getVectorLine(i).getComponent(j)) > EPSILON) {
                    count = 0;
                    //return false;
                } else {
                    count++;
                }
            }
            if (Math.abs(matrix.getVectorLine(i).getComponent(matrix.getColumnsNumber() - 1)) >= EPSILON &&
                    count == matrix.getColumnsNumber() - 1) {
                //return true;
                boolean bool = true;
                System.out.println(true);
            } else {
                boolean bool = false;
                System.out.println(false);
            }
        }
        //return false;
        //}
        //System.out.println(bool);

    }

}