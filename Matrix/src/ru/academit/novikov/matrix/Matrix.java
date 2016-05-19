package ru.academit.novikov.matrix;

import ru.academit.novikov.vector.*;

public class Matrix {

    private double[][] elements;

    public Matrix() {
    }

    public Matrix(int sizeN, int sizeM) {
        if (sizeN < 0 || sizeM < 0) {
            throw new IllegalArgumentException("размеры матрицы не могут быть отрицательными");
        }
        elements = new double[sizeN][sizeM];
    }

    public Matrix(Matrix m2) {
        double[][] temp = new double[m2.elements.length][m2.elements[0].length];
        System.arraycopy(m2.elements, 0, temp, 0, m2.elements.length);
        this.elements = temp;
    }

    public Matrix(double[][] array) {
        double[][] temp = new double[array.length][];
        System.arraycopy(array, 0, temp, 0, array.length);
        this.elements = temp;
    }

    //d.	Matrix(Vector[]) – из массива векторов-строк

    public Matrix(Vector[] v2) {

        int lengthV = v2.length;

        //Matrix m3 = v2[v2.length];


        Vector[] v3 = new Vector[5];

        for (int i = 0; i < v2.length; i++) {
            //for (int j = 0; j < v2.length[getSize()]; j++) {
            //this.elements[i][j] = v2.;
        }
    }


    public Matrix getSize() {
        Matrix m2 = new Matrix(1, 2);
        m2.elements[0][0] = this.elements.length;
        m2.elements[0][1] = this.elements[0].length;
        return m2;
    }

    public Vector getVectorLine(int numberLine) {
        if (numberLine > this.elements.length) {
            throw new IllegalArgumentException("такой строки не существует");
        }
        double[] temp = new double[this.elements[0].length];
        for (int i = 0; i < this.elements[0].length; i++) {
            temp[i] = this.elements[numberLine][i];
        }
        return new Vector(this.elements[0].length, temp);
    }

    public void setVectorLine(int numberLine, Vector v2) {
        int minLength = Math.min(v2.getSize(), this.elements[0].length);
        double[] temp = new double[this.elements[0].length];
        for (int i = 0; i < minLength; i++) {
            temp[i] = v2.getComponent(i);
            this.elements[numberLine][i] = temp[i];
        }
    }

    public Vector getVectorColumn(int numberColumn) {
        if (numberColumn > this.elements[0].length) {
            throw new IllegalArgumentException("такого столбца не существует");
        }
        double[] temp = new double[this.elements.length];
        for (int i = 0; i < this.elements.length; i++) {
            temp[i] = this.elements[i][numberColumn];
        }
        return new Vector(this.elements.length, temp);
    }

    public Matrix getTranspose() {
        Matrix m2 = new Matrix(this.elements[0].length, this.elements.length);
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < this.elements[0].length; j++) {
                double temp = this.elements[i][j];
                m2.elements[j][i] = temp;
            }
        }
        this.elements = new double[this.elements[0].length][this.elements.length];
        this.elements = m2.elements;
        return this;
    }

    public void multiplicationByScalar(double scalar) {
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < this.elements[0].length; j++) {
                this.elements[i][j] = this.elements[i][j] * scalar;
            }
        }
    }

//f.	Вычисление определителя матрицы

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{ ");
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (j == 0) {
                    resultString.append("{ ");
                    resultString.append(this.elements[i][j]);
                } else {
                    resultString.append(", ").append(this.elements[i][j]);
                }
            }
            if (i == elements.length - 1) {
                resultString.append(" }");
            } else {
                resultString.append(" } , ");
            }
        }
        return resultString.append(" }").toString();
    }

    public Matrix MultiplicationByVector(Vector v2) {
        //if (this.elements[0].length != v2.getSize()) {
        //throw new IllegalArgumentException("нельзя умножать");
        //} else {

        if (this.elements.length == v2.getSize() && this.elements[0].length == 1) {

            double[][] temp = new double[this.elements.length][this.elements.length];

            for (int i = 0; i < this.elements.length; i++) {
                for (int j = 0; j < this.elements.length; j++) {
                    temp[i][j] = this.elements[i][0] * v2.getComponent(j);
                    //temp[i][0] = temp[i][0] + temp[i][0];
                    //temp2 = temp2 + this.elements[i][j] * v2.components[j];
                }
            }
            this.elements = temp;


        } else if (this.elements[0].length > 1 && this.elements[0].length == v2.getSize()) {
            double[][] temp = new double[this.elements.length][this.elements[0].length];
            //double temp2 = 0;
            for (int i = 0; i < this.elements.length; i++) {
                temp[i][0] = 0;
                for (int j = 0; j < this.elements[0].length; j++) {
                    temp[i][0] = temp[i][0] + this.elements[i][j] * v2.getComponent(j);
                    //temp[i][0] = temp[i][0] + temp[i][0];
                    //temp2 = temp2 + this.elements[i][j] * v2.components[j];
                }
            }
            this.elements = temp;
        } else {
            throw new IllegalArgumentException("нельзя умножать");
        }
        //}
        //this.elements = temp;
        return this;
    }

    public Matrix add(Matrix m2) {
        int maxLengthI = Math.max(m2.elements.length, this.elements.length);
        int maxLengthJ = Math.max(m2.elements[0].length, this.elements[0].length);

        double[][] temp = new double[maxLengthI][maxLengthJ];
        for (int i = 0; i < this.elements.length; i++) {
            System.arraycopy(this.elements[i], 0, temp[i], 0, this.elements[0].length);
        }

        for (int i = 0; i < m2.elements.length; i++) {
            for (int j = 0; j < m2.elements[0].length; j++) {
                temp[i][j] = temp[i][j] + m2.elements[i][j];
            }
        }
        this.elements = new double[maxLengthI][maxLengthJ];
        this.elements = temp;
        return this;
    }

    public Matrix minus(Matrix m2) {
        int maxLengthI = Math.max(m2.elements.length, this.elements.length);
        int maxLengthJ = Math.max(m2.elements[0].length, this.elements[0].length);

        double[][] temp = new double[maxLengthI][maxLengthJ];
        for (int i = 0; i < this.elements.length; i++) {
            /*
                for (int j = 0; j < this.elements[0].length; j++) {
                temp[i][j] = this.elements[i][j];
            } можно заменить на arraycopy
             */
            System.arraycopy(this.elements[i], 0, temp[i], 0, this.elements[0].length);
        }

        for (int i = 0; i < m2.elements.length; i++) {
            for (int j = 0; j < m2.elements[0].length; j++) {
                temp[i][j] = temp[i][j] - m2.elements[i][j];
            }
        }
        this.elements = new double[maxLengthI][maxLengthJ];
        this.elements = temp;
        return this;
    }


    public static Matrix add(Matrix m1, Matrix m2) {
        Matrix m3 = new Matrix(m1);
        return m3.add(m2);
    }

    public static Matrix minus(Matrix m1, Matrix m2) {
        Matrix m3 = new Matrix(m1);
        return m3.minus(m2);
    }

    public static Matrix multiplication(Matrix m1, Matrix m2) {

        //if (this.elements[0].length != v2.getSize()) {
        //throw new IllegalArgumentException("нельзя умножать");
        //} else {

        int maxI = Math.max(m1.elements.length, m2.elements.length);
        int maxJ = Math.max(m1.elements[0].length, m2.elements[0].length);
        double[][] temp = new double[m1.elements.length][m1.elements.length];

        //temp[i][0] = 0;
        //for (int j = 0; j < this.elements[0].length; j++) {
        //temp[i][0] = temp[i][0] + this.elements[i][j] * v2.getComponent(j);
        //temp[i][0] = temp[i][0] + temp[i][0];
        //temp2 = temp2 + this.elements[i][j] * v2.components[j];

        if (m1.elements[0].length == m2.elements.length) {
            for (int i = 0; i < m1.elements.length; i++) {
                for (int j = 0; j < m1.elements.length; j++) {
                    temp[i][j] = m1.elements[i][j] * m2.elements[j][i];
                    //temp[i][j] = temp[i][j] + temp[i][j];
                }

            }

            double[][] temp2 = new double[m1.elements[0].length][m1.elements[0].length];

            for (int i = 0; i < m1.elements[0].length; i++) {
                for (int j = 0; j < m1.elements[0].length; j++) {
                    temp2[i][j] = m1.elements[i][j] * m2.elements[j][i];
                    //temp[i][j] = temp[i][j] + temp[i][j];
                }

            }

        } else {
            throw new IllegalArgumentException("нельзя умножать");
        }
        Matrix m3 = new Matrix(temp);
        return m3;
    }

/*
        if (this.elements.length == v2.getSize() && this.elements[0].length == 1) {

            double[][] temp = new double[this.elements.length][this.elements.length];

            for (int i = 0; i < this.elements.length; i++) {
                for (int j = 0; j < this.elements.length; j++) {
                    temp[i][j] = this.elements[i][0] * v2.getComponent(j);
                    //temp[i][0] = temp[i][0] + temp[i][0];
                    //temp2 = temp2 + this.elements[i][j] * v2.components[j];
                }
            }
            this.elements = temp;


        } else if (this.elements[0].length > 1 && this.elements[0].length == v2.getSize()) {
            double[][] temp = new double[this.elements.length][this.elements[0].length];
            //double temp2 = 0;
            for (int i = 0; i < this.elements.length; i++) {
                temp[i][0] = 0;
                for (int j = 0; j < this.elements[0].length; j++) {
                    temp[i][0] = temp[i][0] + this.elements[i][j] * v2.getComponent(j);
                    //temp[i][0] = temp[i][0] + temp[i][0];
                    //temp2 = temp2 + this.elements[i][j] * v2.components[j];
                }
            }
            this.elements = temp;
        } else {
            throw new IllegalArgumentException("нельзя умножать");
        }

        //}


        //this.elements = temp;
        return m2;
    }
 */


    //return m2;
    //}


}


/*
    public int[][] getSize2() {
        int[][] temp = new int[1][2];
        temp[0][0] = this.elements.length;
        temp[0][1] = this.elements[0].length;
        return temp;
    }
 */