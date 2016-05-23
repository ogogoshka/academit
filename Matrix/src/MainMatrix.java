import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

public class MainMatrix {
    public static void main(String[] args) {
        Matrix test = new Matrix();

        double[][] array22 = {{-2, 1, 3, 2}, {3, 0, -1, 2}, {-5, 2, 3, 0}, {4, -1, 2, -3}};
        Matrix m22 = new Matrix(array22);
        System.out.println(m22.toString());


        double[][] temp3 = new double[m22.getRowsNumber()][m22.getColumnsNumber()];
        double[] temp4 = new double[m22.getColumnsNumber()];
        for (int i = 0; i < 3; i++) {

            double first = m22.components[i].getComponent(i);

            //m22.getVectorColumn(i + 1).minus(m22.getVectorColumn(i));
            //m22.getVectorLine(i + 1).minus(m22.getVectorLine(i));
            //m22.setVectorLine(i + 1, m22.getVectorLine(i + 1).minus(m22.getVectorLine(0)));


            for (int j = i + 1; j < 4; j++) {
                double k = m22.components[j].getComponent(i) / first;

                //m22.getVectorLine(i).multiplicationByScalar2(k);

                m22.setVectorLine(j, m22.getVectorLine(j).minus(m22.getVectorLine(i).multiplicationByScalar2(k)));
                //m22.getVectorLine(j).minus(m22.getVectorLine(i));

                //temp3[i][j + 1] = m22.components[i].getComponent(j) - first * k;
            }

            temp3[i][i] = m22.components[i].getComponent(i);

        }
        double temp5 = 1;
        for (int i = 0; i < 4; i++) {
            temp5 = temp5 * m22.components[i].getComponent(i);
            //double temp5 = temp5 * 10;
        }
        //System.out.println("temp5 = " + temp5);

        System.out.println(m22.toString());

        System.out.println("m22.getDeterminant()=" + m22.getDeterminant());

        Matrix m33 = new Matrix(temp3);
        //System.out.println(m33.toString());
        //Vector v22 = new Vector(temp4);
        //m22.setVectorLine(0, v22);
        //System.out.println(m22.toString());


        double[][] array44 = {{-6, -3, 5, 6}, {-10, 2, 7, 8}, {11, 7, 8, 1}, {11, 7, 8, 9}};
        Matrix m44 = new Matrix(array44);
        //System.out.println("m44.getDeterminant() = " + m44.getDeterminant());

        double[][] array10 = {{-6, -3}, {-10, -4}, {11, 7, 8}};
        Matrix m10 = new Matrix(array10);

        Matrix m11 = new Matrix(m10);
        //System.out.println(m11.toString());

        double[][] array12 = {{-6, -3, 2, 3}, {-10, -4}};
        Matrix m12 = new Matrix(array12);
        //System.out.println(m12.toString());

        //System.out.println(m11.minus(m12).toString());
        //System.out.println(m11.add(m12).toString());
        //System.out.println(Matrix.add(m11, m12).toString());


        double[][] array = {{1, 2, -1}};
        double[][] array2 = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        double[][] array3 = {{1, 2, 3}, {4, 5, 6}};

        Matrix m1 = new Matrix(3, 3);

        double[] arr = {1, 2, -1};

        Vector[] newVector = new Vector[2];
        newVector[0] = new

                Vector(3, arr);

        newVector[1] = new

                Vector(3, arr);

        Matrix m6 = new Matrix(newVector);

        double[] array6 = {6, 7, 8};


        //System.out.println(m4.toString());
        //m6.add(m4);
        //System.out.println(m6.add(m3).toString());


        //m3.getVectorColumn(1);


        double[][] arrayTestM = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        double[] arrayTestV = {1, 2, -1};
        Vector v7 = new Vector(3, arrayTestV);
        Matrix m7 = new Matrix(arrayTestM);
        //m7.multiplicationByVector(v7);


        //add(m6, m7);
        //minus(m6, m7);

        double[][] array8 = {{3, 1, 2}, {0, -1, 4}};
        double[][] array9 = {{-1, 1}, {2, 0}, {0, 3}};

        Matrix m8 = new Matrix(array8);
        Matrix m9 = new Matrix(array9);

        m8.getRowsNumber();
        m8.getColumnsNumber();
        m8.getVectorLine(0);





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

/*

        double[][] temp3 = new double[m22.getRowsNumber()][m22.getColumnsNumber()];
        double[] temp4 = new double[m22.getColumnsNumber()];
        for (int i = 0; i < m22.getRowsNumber(); i++) {
            temp4[0] = m22.components[i].getComponent(i);
            temp3[i][i] = m22.components[i].getComponent(i);

            double first = m22.components[i].getComponent(i);
            //double k2 = m22.components[i].getComponent(i + 1) / m22.components[i].getComponent(i);
            //double temp2 = m22.components[i].getComponent(i + 1) / m22.components[i].getComponent(i);

            for (int j = i + 1; j < m22.getColumnsNumber() - 1; j++) {
                double k = m22.components[i].getComponent(j) / first;
                //this.components[i].getComponent(j) = this.components[i].getComponent(j) - first * k;
                double temp = m22.components[i].getComponent(j) - first * k;
                temp3[i][j + 1] = temp;
                //this.components[i].getComponent(j + 1) = temp;
                temp4[j + 1] = temp;
            }
        }
        double temp5 = 1;
        for (int i = 0; i < 4; i++) {
            temp5 = temp5 * temp3[i][i];
            //double temp5 = temp5 * 10;
        }
        System.out.println("temp5 = " + temp5);

 */