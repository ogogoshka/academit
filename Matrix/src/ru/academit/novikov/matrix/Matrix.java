package ru.academit.novikov.matrix;

import java.util.Vector;

public class Matrix {

    private int sizeN;
    private int sizeM;
    private double[][] elements;

    public Matrix() {

    }

    public Matrix(int sizeN, int sizeM) {
        if (sizeN < 0 || sizeM < 0) {
            throw new IllegalArgumentException("размеры матрицы не могут быть отрицательными");
        }
        elements = new double[sizeN][sizeM];
    }

    public Matrix getVectorLine(int numberLine) {
        //double[] temp = new double[this.elements[0].length];
        Matrix m2 = new Matrix(1, this.elements[0].length);
        System.arraycopy(this.elements[numberLine], 0, m2.elements[0], 0, this.elements[0].length);
        return m2;
    }

    public Vector getVectorLine2(int numberLine) {

        Vector[] newVector = new Vector[1];
        newVector[0] = new Vector(this.elements[0].length);

        Vector v2 = new Vector(this.elements[0].length);


        double[] temp = new double[this.elements[0].length];
        Matrix m2 = new Matrix(1, this.elements[0].length);
        //System.arraycopy(this.elements[numberLine], 0, v2.components, 0, this.elements[0].length);

        for (int i = 0; i < this.elements[0].length; i++) {
            temp[i] = this.elements[numberLine][i];
        }

        Vector v3 = new Vector(this.elements[0].length);

        return v3;
    }


    public Matrix(Matrix m2) {
        double[][] temp = new double[m2.elements.length][];
        System.arraycopy(m2.elements, 0, temp, 0, m2.elements.length);
        this.elements = temp;

    }

    public Matrix(double[][] array) {
        double[][] temp = new double[array.length][];
        System.arraycopy(array, 0, temp, 0, array.length);
        this.elements = temp;
    }

    public int[][] getSize() {
        this.sizeN = sizeN;
        this.sizeM = sizeM;
        //elements.length = sizeN;
        //elements[0].length = sizeM;
        int[][] temp = new int[1][2];
        temp[0][0] = this.elements.length;
        temp[0][1] = this.elements[0].length;
        return temp;
    }

    public Matrix getTranspose() {
        Matrix m2 = new Matrix(this.elements[0].length, this.elements.length);
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < this.elements[0].length; j++) {
                double temp = this.elements[i][j];
                m2.elements[j][i] = temp;
            }
        }
        return m2;
    }

    public Matrix multScalar(double scalar) {
        //Matrix m2 = new Matrix(this.elements[0].length, this.elements.length);
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < this.elements[0].length; j++) {
                this.elements[i][j] = this.elements[i][j] * scalar;
                //m2.elements[i][j] = temp;
            }
        }
        return this;
    }

    public Matrix getSize2() {
        this.sizeN = sizeN;
        this.sizeM = sizeM;
        //elements.length = sizeN;
        //elements[0].length = sizeM;
        Matrix m2 = new Matrix(1, 2);
        //int[][] temp = new int[1][2];
        //temp[0][0] = this.elements.length;
        //temp[0][1] = this.elements[0].length;
        m2.elements[0][0] = this.elements.length;
        m2.elements[0][1] = this.elements[0].length;
        return m2;
    }


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


}
