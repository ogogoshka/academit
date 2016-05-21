package ru.academit.novikov.matrix;

import ru.academit.novikov.vector.*;

public class Matrix {

    private Vector[] components;

    public Matrix() {
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{ ");
        for (int i = 0; i < this.components.length; i++) {
            for (int j = 0; j < this.components[0].getSize(); j++) {
                if (j == 0) {
                    resultString.append("{ ");
                    resultString.append(this.components[i].getComponent(j));
                } else {
                    resultString.append(", ").append(this.components[i].getComponent(j));
                }
            }
            if (i == this.components.length - 1) {
                resultString.append(" }");
            } else {
                resultString.append(" } , ");
            }
        }
        return resultString.append(" }").toString();
    }

    public Matrix(int numbersRow, int numbersColumn) {
        if (numbersRow <= 0 || numbersColumn <= 0) {
            throw new IllegalArgumentException("размеры матрицы не могут быть <= 0");
        }
        this.components = new Vector[numbersRow];
        for (int i = 0; i < numbersRow; i++) {
            this.components[i] = new Vector(numbersColumn);
        }
    }

    public Matrix(Matrix matrix) {
        Vector[] vector = new Vector[matrix.components.length];
        this.components = new Vector[matrix.components.length];
        for (int i = 0; i < matrix.components.length; i++) {
            vector[i] = matrix.components[i];
            this.components[i] = vector[i];
        }
    }

    public Matrix(double[][] array) {
        this.components = new Vector[array.length];
        for (int i = 0; i < array.length; i++) {
            this.components[i] = new Vector(array[0].length, array[i]);
        }
    }

    public Matrix(Vector[] vector) {
        this.components = new Vector[vector.length];
        for (int i = 0; i < vector.length; i++) {
            this.components[i] = new Vector(vector[0].getSize());
            this.components[i] = vector[i];
        }
    }

    public int getNumbersOfRow() {
        return this.components.length;
    }

    public int getNumbersOfColumn() {
        return this.components[0].getSize();
    }

    public Vector getVectorLine(int numbersRow) {
        if (numbersRow > this.components.length) {
            throw new IllegalArgumentException("такой строки не существует");
        }
        return new Vector(this.components[numbersRow]);
    }

    public void setVectorLine(int numberRow, Vector vector) {
        this.components[numberRow] = new Vector(vector);
    }

    public Vector getVectorColumn(int numberColumn) {
        if (numberColumn > this.components[0].getSize()) {
            throw new IllegalArgumentException("такого столбца не существует");
        }
        double[] temp = new double[this.components.length];
        for (int i = 0; i < this.components.length; i++) {
            temp[i] = this.components[i].getComponent(numberColumn);
        }
        return new Vector(this.components.length, temp);
    }

    public Matrix transpose() {
        Vector[] vector = new Vector[this.components[0].getSize()];
        for (int j = 0; j < this.components[0].getSize(); j++) {
            vector[j] = this.getVectorColumn(j);
        }
        this.components = new Vector[this.components.length];
        for (int j = 0; j < this.components.length; j++) {
            this.setVectorLine(j, vector[j]);
        }
        return this;
    }

    public void multiplicationByScalar(double scalar) {
        for (Vector component : this.components) {
            component.multiplicationByScalar(scalar);
        }
    }

//f. Вычисление определителя матрицы

    public Matrix add(Matrix matrix) {
        int maxNumbersRow = Math.max(matrix.components.length, this.components.length);
        int maxNumbersColumn = Math.max(matrix.components[0].getSize(), this.components[0].getSize());
        double[][] temp = new double[maxNumbersRow][maxNumbersColumn];
        for (int i = 0; i < this.components.length; i++) {
            for (int j = 0; j < this.components[0].getSize(); j++) {
                temp[i][j] = this.components[i].getComponent(j);
            }
        }
        for (int i = 0; i < matrix.components.length; i++) {
            for (int j = 0; j < matrix.components[0].getSize(); j++) {
                temp[i][j] = temp[i][j] + matrix.components[i].getComponent(j);
            }
        }
        this.components = new Vector[maxNumbersRow];
        for (int i = 0; i < maxNumbersRow; i++) {
            this.components[i] = new Vector(maxNumbersColumn, temp[i]);
        }
        return this;
    }

    public Matrix minus(Matrix matrix) {
        int maxNumbersRow = Math.max(matrix.components.length, this.components.length);
        int maxNumbersColumn = Math.max(matrix.components[0].getSize(), this.components[0].getSize());
        double[][] temp = new double[maxNumbersRow][maxNumbersColumn];
        for (int i = 0; i < this.components.length; i++) {
            for (int j = 0; j < this.components[0].getSize(); j++) {
                temp[i][j] = this.components[i].getComponent(j);
            }
        }
        for (int i = 0; i < matrix.components.length; i++) {
            for (int j = 0; j < matrix.components[0].getSize(); j++) {
                temp[i][j] = temp[i][j] - matrix.components[i].getComponent(j);
            }
        }
        this.components = new Vector[maxNumbersRow];
        for (int i = 0; i < maxNumbersRow; i++) {
            this.components[i] = new Vector(maxNumbersColumn, temp[i]);
        }
        return this;
    }

    public Vector multiplicationByVector(Vector vector) {
        if (this.components[0].getSize() != vector.getSize()) {
            throw new IllegalArgumentException("нельзя умножать, кол-во столбцов в матрице должно совпадать с кол-вом элементов в векторе");
        } else {
            double[] temp = new double[this.components.length];
            for (int i = 0; i < this.components.length; i++) {
                for (int j = 0; j < this.components[0].getSize(); j++) {
                    temp[i] += this.components[i].getComponent(j) * vector.getComponent(j);
                }
            }
            return new Vector(this.components.length, temp);
        }
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
        if (m1.components[0].getSize() != m2.components.length) {
            throw new IllegalArgumentException("нельзя умножать. число столбцов в первой матрице должно совпадать с числом строк во второй");
        } else {
            Vector[] vector = new Vector[m2.components[0].getSize()];
            for (int i = 0; i < m2.components[0].getSize(); i++) {
                vector[i] = m1.multiplicationByVector(m2.getVectorColumn(i));
            }

            return new Matrix(vector).transpose();
        }
    }
}