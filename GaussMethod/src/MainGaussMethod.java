import ru.academit.novikov.gauss.GaussMethod;
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
        GaussMethod gauss = new GaussMethod(matrG, vecG);

        double[][] gaussM2 = {
                {0, 0},
                {2, 2}
        };
        double[] gaussV2 = {2, 4};

        Matrix matrG2 = new Matrix(gaussM2);
        Vector vecG2 = new Vector(gaussV2);
        GaussMethod gauss2 = new GaussMethod(matrG2, vecG2);

        double[][] gaussM3 = {
                {0, 0},
                {2, 2}
        };
        double[] gaussV3 = {0, 4};

        Matrix matrG3 = new Matrix(gaussM3);
        Vector vecG3 = new Vector(gaussV3);
        GaussMethod gauss3 = new GaussMethod(matrG3, vecG3);

        double[][] gaussM4 = {
                {1, 0},
                {2, 2}
        };
        double[] gaussV4 = {3, 4};

        Matrix matrG4 = new Matrix(gaussM4);
        Vector vecG4 = new Vector(gaussV4);
        GaussMethod gauss4 = new GaussMethod(matrG4, vecG4);


    }

}