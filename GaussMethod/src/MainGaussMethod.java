import ru.academit.novikov.gauss.GaussMethod;
import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

public class MainGaussMethod {
    public static void main(String[] args) {

        double[] arr = {1, 2, -1};
        double[] arr2 = {1, 2, -1, 5, 7};
        double[] arr3 = {1, 2};


        Vector v1 = new Vector(3, arr2);
        Vector v2 = new Vector(4);
        //getExtendedMatrix(m10);
        //System.out.println(getExtendedMatrix(m10, v1).toString());
        //System.out.println(m10.getExtendedMatrix(v1).toString());
        Matrix m1 = new Matrix(3, 3);

        //m10.setVectorColumn(0, v1);
        //System.out.println(m10.toString());

        double[][] array10 = {{0, 0, 1, 2}, {0, 3, 4, 0}, {5, 6, 0, 0}, {7, 0, 0, 0}};
        double[][] array11 = {{0, 1, 2}, {3, 4, 0}, {6, 1, 2}};
        Matrix m10 = new Matrix(array10);
        Matrix m11 = new Matrix(array11);
        System.out.println(m11.toString());


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


        GaussMethod solves = new GaussMethod(m11, v1);
        solves.result();


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


    }

}