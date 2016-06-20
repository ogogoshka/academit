import ru.academit.novikov.gauss.GaussMethod;
import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

public class MainGaussMethod {
    public static void main(String[] args) {

        double[] arr = {0, 0, 0};
        double[] arr2 = {1, 2, -1, 5, 7};
        double[] arr3 = {1, 2};

        Vector vS = new Vector(3, arr);
        Vector v1 = new Vector(3, arr2);
        Vector v2 = new Vector(4);
        //getExtendedMatrix(m10);
        //System.out.println(getExtendedMatrix(m10, v1).toString());
        //System.out.println(m10.getExtendedMatrix(v1).toString());
        Matrix m1 = new Matrix(3, 3);

        //m10.setVectorColumn(0, v1);
        //System.out.println(m10.toString());

        double[][] array10 = {{0, 0, 1, 2}, {0, 3, 4, 0}, {5, 6, 0, 0}, {7, 0, 0, 0}};
        double[][] array11 = {
                {1, 4, 9, 11},
                {0, 2, 6, 22},
                {0, 0, 3, 33}
        };
        Matrix m10 = new Matrix(array10);
        Matrix m11 = new Matrix(array11);
        //System.out.println(m11.toString());


        double[][] array22 = {
                {1, 1, 1, 11},
                {4, 2, 6, 22},
                {6, 4, 3, 33}
        };
        Matrix m22 = new Matrix(array22);

        //get bottom triangular matrix
        double diagonal2 = 0;
        double k3 = 0;

        System.out.println("m22.toString()=" + m22.toString());

        for (int i = 0; i < m22.getRowsNumber() - 1; i++) {
            double diagonalComponent = m22.getComponent(i, i);
            for (int j = i + 1; j < m22.getColumnsNumber() - 1; j++) {
                double k = m22.getComponent(j, i) / diagonalComponent;
                //double k = m22.components[j].getComponent(i) / diagonalComponent;
                m22.setVectorLine(j, m22.getVectorLine(j).minus(m22.getVectorLine(i).multiplicationByScalar2(k)));
            }
        }
                        /*
        for (int i = 0; i < m22.getRowsNumber() - 1; i++) {
            Vector v11 = new Vector(m22.getVectorLine(i));
            diagonal2 = m22.getComponent(i, i);
            v11.multiplicationByScalar2(1 / diagonal2);
            m22.setVectorLine(i, v11);
            v11 = m22.getVectorLine(i);
            for (int j = i; j < m22.getRowsNumber() - 1; j++) {



                Vector v12 = new Vector(m22.getVectorLine(j));
                k3 = m22.getComponent(j, i);
                v12.multiplicationByScalar2(1 / k3);
                v12.minus(v11);
                m22.setVectorLine(j, v12);
                //double k2 = m22.getComponent(j, i) / diagonal2;
                //m22.setVectorLine(j, m22.getVectorLine(j).minus(m22.getVectorLine(i).multiplicationByScalar2(k2)));
            }

        }
*/
        System.out.println("get bottom triangular matrix m22.toString()=" + m22.toString());


        //get diagonal matrix
        double diagonal = 0;
        double k2 = 0;
        for (int i = m22.getRowsNumber() - 1; i >= 0; i--) {
            Vector v11 = new Vector(m22.getVectorLine(i));
            diagonal = m22.getComponent(i, i);
            v11.multiplicationByScalar2(1 / diagonal);
            m22.setVectorLine(i, v11);
            v11 = m22.getVectorLine(i);
            for (int j = 0; j < i; j++) {
                Vector v12 = new Vector(m22.getVectorLine(j));
                k2 = m22.getComponent(j, i);
                v12.multiplicationByScalar2(1 / k2);
                v12.minus(v11);
                m22.setVectorLine(j, v12);
            }
        }


        //System.out.println(v11.toString());
        System.out.println("get diagonal matrix=" + m22.toString());


        //отсортировать перед прямым ходом

        //после прямого хода проверить есть ли нулевые строки
        //если есть то вычеркнуть
        //если нулевая строка кроме последнего элемента то решений нет
        //если 1 0 0 | 0 то х=0


        for (int i = 0; i < m10.getRowsNumber(); i++) {
            int max = i;

            for (int j = i + 1; j < m10.getRowsNumber(); j++) {
                if (Math.abs(m10.getComponent(j, i)) > Math.abs(m10.getComponent(i, i))) {
                    max = j;
                }
                m10.replaceLine(i, max);
            }

        }
        System.out.println(m10.toString());


        double[][] array33 = {
                {1, 4, 9},
                {0, 2, 6},
                {0, 0, 3}
        };

        Matrix m33 = new Matrix(array33);

        //GaussMethod solves = new GaussMethod(m11, vS);

        //solves.bottomTriangular();

        //Matrix m111 = new Matrix(solves.bottomTriangular());
        //System.out.println(m111.toString());

        //Matrix m222 = new Matrix(solves.diagonalMatrix());
        //System.out.println(m222.toString());

        //solves.result();
        //solves.getVectorSolves();
        //Vector mV = new Vector(solves.getVectorSolves());
        //System.out.println(mV.toString());
/*
        //прямой ход
        for (int i = 0; i < m10.getRowsNumber() - 1; i++) {

            if (m10.getComponent(i, i) == 0) {
                m10.replaceLine(i, i + 1);
                System.out.println(i);
                System.out.println(m10.toString());
                continue;
            }


            for (int j = i + 1; j < m10.getColumnsNumber() - 1; j++) {

                double diagonalComponent2 = m10.getComponent(i, i);
                //double k2 = m10.getComponent(j, i) / diagonalComponent2;

                //if (k2 == 0) {
                //continue;
                //}

                if (diagonalComponent2 == 0) {
                    //Vector temp = new Vector(m10.getVectorLine(i));
                    //m10.setVectorLine(i, m10.getVectorLine(i + 1));
                    //m10.setVectorLine(i + 1, temp);
                    //m10.replaceLine(i, i + 1);
                    //continue;
                    //System.out.println(temp.toString());
                    //Vector temp = new Vector();
                }

                //m10.setVectorLine(j, m10.getVectorLine(j).minus(m10.getVectorLine(i).multiplicationByScalar2(k2)));

            }
        }
        //System.out.println(m10.toString());

        //обратный ход
        for (int i = m10.getRowsNumber() - 1; i >= 0; i--) {
            double diagonalComponent2 = m10.getComponent(i, i);
            for (int j = i - 1; j >= 0; j--) {
                double k2 = m10.getComponent(j, i) / diagonalComponent2;
                m10.setVectorLine(j, m10.getVectorLine(j).minus(m10.getVectorLine(i).multiplicationByScalar2(k2)));
            }
        }
        System.out.println(m10.toString());

        //деление свободных членов на диагональные
        for (int i = 0; i < m10.getRowsNumber(); i++) {
            double diagonalComponent3 = 1 / m10.getComponent(i, i);
            m10.setVectorLine(i, m10.getVectorLine(i).multiplicationByScalar2(diagonalComponent3));
        }
        System.out.println(m10.toString());

        //getVectorSolves(m10, v1);
        System.out.println(getVectorSolves(m10, v1).toString());

        double[] arr4 = {0, 0, 0, 3};
        Vector v3 = new Vector(2, arr4);
        //v3.zeroElementsExceptLast();
        System.out.println(v3.zeroElementsExceptLast());

        System.out.println(v3.allZeroElements());

 */

        //isProportionalLines
        double[][] array44 = {
                {1, 2, 3},
                {4, 2, 6},
                {6, 4, 3}
        };

        double[] arr44 = {1, 2, 3};

        Matrix m44 = new Matrix(array44);
        Vector v44 = new Vector(arr44);
        GaussMethod solves2 = new GaussMethod(m44, v44);
        //System.out.println(solves2.getExtendedMatrix().toString());
        //solves.bottomTriangular();
        System.out.println("solves2.diagonalMatrix()=" + solves2.diagonalMatrix().toString());
        //Matrix m123 = new Matrix(solves2.bottomTriangular());
        //System.out.println(m123.toString());


        //GaussMethod solves3 = new GaussMethod(m123, vS);
        //System.out.println(solves3.diagonalMatrix().toString());

        double[][] array55 = {
                {1, 2, 3},
                {0, 2, 6},
                {0, 0, 3}
        };
        Matrix m55 = new Matrix(array55);
        System.out.println("m55.toString() = " + m55.toString());

        for (int i = 0; i < m55.getRowsNumber(); i++) {


        }

        for (int i = m55.getRowsNumber() - 1; i > 0; i--) {
            double diagonalComponent = m55.getComponent(i, i);
            for (int j = i - 1; j >= 0; j--) {
                double k = m55.getComponent(j, i);
                k = k / diagonalComponent;
                m55.setVectorLine(j, m55.getVectorLine(j).minus(m55.getVectorLine(i).multiplicationByScalar2(k)));
            }
        }

        System.out.println("m55.toString() = " + m55.toString());

/*
        for (int i = 0; i < this.getRowsNumber() - 1; i++) {
            double diagonalComponent = this.components[i].getComponent(i);
            for (int j = i + 1; j < this.getColumnsNumber(); j++) {
                double k = this.components[j].getComponent(i) / diagonalComponent;
                this.setVectorLine(j, this.getVectorLine(j).minus(this.getVectorLine(i).multiplicationByScalar2(k)));
            }
        }
 */


    }

}