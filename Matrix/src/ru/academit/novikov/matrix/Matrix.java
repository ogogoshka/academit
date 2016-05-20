package ru.academit.novikov.matrix;

import ru.academit.novikov.vector.*;

public class Matrix {

    private double[][] elements;

    public Matrix() {
    }

    public Matrix(int numbersLine, int numbersColumn) {
        if (numbersLine < 0 || numbersColumn < 0) {
            throw new IllegalArgumentException("размеры матрицы не могут быть отрицательными");
        }
        elements = new double[numbersLine][numbersColumn];
    }

    public Matrix(Matrix matrix) {
        double[][] temp = new double[matrix.elements.length][matrix.elements[0].length];
        System.arraycopy(matrix.elements, 0, temp, 0, matrix.elements.length);
        this.elements = temp;
    }

    public Matrix(double[][] array) {
        double[][] temp = new double[array.length][];
        System.arraycopy(array, 0, temp, 0, array.length);
        this.elements = temp;
    }

    //d. Matrix(Vector[]) – из массива векторов-строк
    public Matrix(Vector[] vector) {
        this.elements = new double[vector.length][vector[0].getSize()];
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[0].getSize(); j++) {
                this.elements[i][j] = vector[i].getComponent(j);
            }
        }
    }

    public Matrix getSize() {
        Matrix matrix = new Matrix(1, 2);
        matrix.elements[0][0] = this.elements.length;
        matrix.elements[0][1] = this.elements[0].length;
        return matrix;
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

    public void setVectorLine(int numberLine, Vector vector) {
        int minLength = Math.min(vector.getSize(), this.elements[0].length);
        double[] temp = new double[this.elements[0].length];
        for (int i = 0; i < minLength; i++) {
            temp[i] = vector.getComponent(i);
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
        Matrix matrix = new Matrix(this.elements[0].length, this.elements.length);
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < this.elements[0].length; j++) {
                double temp = this.elements[i][j];
                matrix.elements[j][i] = temp;
            }
        }
        this.elements = new double[this.elements[0].length][this.elements.length];
        this.elements = matrix.elements;
        return this;
    }

    public void multiplicationByScalar(double scalar) {
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < this.elements[0].length; j++) {
                this.elements[i][j] = this.elements[i][j] * scalar;
            }
        }
    }

//f. Вычисление определителя матрицы

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

    public Matrix add(Matrix matrix) {
        int maxNumbersLine = Math.max(matrix.elements.length, this.elements.length);
        int maxNumbersColumn = Math.max(matrix.elements[0].length, this.elements[0].length);

        double[][] temp = new double[maxNumbersLine][maxNumbersColumn];
        for (int i = 0; i < this.elements.length; i++) {
            System.arraycopy(this.elements[i], 0, temp[i], 0, this.elements[0].length);
        }

        for (int i = 0; i < matrix.elements.length; i++) {
            for (int j = 0; j < matrix.elements[0].length; j++) {
                temp[i][j] = temp[i][j] + matrix.elements[i][j];
            }
        }
        this.elements = new double[maxNumbersLine][maxNumbersColumn];
        this.elements = temp;
        return this;
    }

    public Matrix minus(Matrix matrix) {
        int maxNumbersLine = Math.max(matrix.elements.length, this.elements.length);
        int maxNumbersColumn = Math.max(matrix.elements[0].length, this.elements[0].length);

        double[][] temp = new double[maxNumbersLine][maxNumbersColumn];
        for (int i = 0; i < this.elements.length; i++) {

            System.arraycopy(this.elements[i], 0, temp[i], 0, this.elements[0].length);
        }

        for (int i = 0; i < matrix.elements.length; i++) {
            for (int j = 0; j < matrix.elements[0].length; j++) {
                temp[i][j] = temp[i][j] - matrix.elements[i][j];
            }
        }
        this.elements = new double[maxNumbersLine][maxNumbersColumn];
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
}