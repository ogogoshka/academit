package ru.academit.novikov.matrix;

import ru.academit.novikov.vector.*;

public class Matrix {

    private Vector[] components;

    public Matrix() {
    }

    public Matrix(int rowsNumber, int numbersColumn) {
        if (rowsNumber <= 0) {
            throw new IllegalArgumentException("кол-во строк не может быть <= 0");
        } else if (numbersColumn <= 0) {
            throw new IllegalArgumentException("кол-во столбцов не может быть <= 0");
        } else {
            this.components = new Vector[rowsNumber];
            for (int i = 0; i < rowsNumber; i++) {
                this.components[i] = new Vector(numbersColumn);
            }
        }
    }

    public Matrix(Matrix matrix) {
        Vector[] vector = new Vector[matrix.getRowsNumber()];
        this.components = new Vector[matrix.getRowsNumber()];
        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            vector[i] = matrix.components[i];
            this.components[i] = new Vector(vector[i]);
        }
    }

    public Matrix(double[][] array) {
        int maxLength = 0;
        for (double[] anArray : array) {
            maxLength = Math.max(maxLength, anArray.length);
        }
        this.components = new Vector[array.length];
        for (int i = 0; i < array.length; i++) {
            this.components[i] = new Vector(maxLength, array[i]);
        }
    }

    public Matrix(Vector[] vector) {
        this.components = new Vector[vector.length];
        for (int i = 0; i < vector.length; i++) {
            this.components[i] = new Vector(vector[i]);
        }
    }

    public int getRowsNumber() {
        return this.components.length;
    }

    public int getNumbersOfColumn() {
        return this.components[0].getSize();
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{ ");
        for (int i = 0; i < this.components.length; i++) {
            if (i == this.components.length - 1) {
                resultString.append(this.components[i].toString());
            } else {
                resultString.append(this.components[i].toString()).append(" , ");
            }
        }
        return resultString.append(" }").toString();
    }

    public Vector getVectorLine(int rowsNumber) {
        if (rowsNumber > this.getRowsNumber() || rowsNumber < 0) {
            throw new IllegalArgumentException("такой строки не существует");
        }
        return new Vector(this.components[rowsNumber]);
    }

    public void setVectorLine(int rowsNumber, Vector vector) {
        this.components[rowsNumber] = new Vector(vector);
    }

    public Vector getVectorColumn(int numberColumn) {
        if (numberColumn > this.getNumbersOfColumn() || numberColumn < 0) {
            throw new IllegalArgumentException("такого столбца не существует");
        }
        double[] temp = new double[this.getRowsNumber()];
        for (int i = 0; i < this.getRowsNumber(); i++) {
            temp[i] = this.components[i].getComponent(numberColumn);
        }
        return new Vector(this.getRowsNumber(), temp);
    }

    public Matrix transpose() {
        Vector[] arrayOfVectors = new Vector[this.getNumbersOfColumn()];
        for (int j = 0; j < this.getNumbersOfColumn(); j++) {
            arrayOfVectors[j] = this.getVectorColumn(j);
        }
        this.components = new Vector[this.getRowsNumber()];
        for (int j = 0; j < this.getRowsNumber(); j++) {
            this.components[j] = arrayOfVectors[j];
        }
        return this;
    }

    public void multiplicationByScalar(double scalar) {
        for (Vector component : this.components) {
            component.multiplicationByScalar(scalar);
        }
    }

    public Matrix add(Matrix matrix) {
        int maxRowsNumber = Math.max(matrix.components.length, this.components.length);
        Vector[] arrayOfVectors = new Vector[maxRowsNumber];
        for (int i = 0; i < maxRowsNumber; i++) {
            arrayOfVectors[i] = Vector.add(this.components[i], matrix.components[i]);
        }
        return new Matrix(arrayOfVectors);
    }

    public Matrix minus(Matrix matrix) {

        int maxRowsNumber = Math.max(matrix.components.length, this.components.length);
        Vector[] arrayOfVectors = new Vector[maxRowsNumber];
        for (int i = 0; i < maxRowsNumber; i++) {
            arrayOfVectors[i] = Vector.minus(this.components[i], matrix.components[i]);
        }
        return new Matrix(arrayOfVectors);
    }

    public Vector multiplicationByVector(Vector vector) {
        if (this.getNumbersOfColumn() != vector.getSize()) {
            throw new IllegalArgumentException("нельзя умножать, кол-во столбцов в матрице должно совпадать с кол-вом элементов в векторе");
        } else {
            double[] temp = new double[this.getRowsNumber()];
            for (int i = 0; i < this.getRowsNumber(); i++) {
                for (int j = 0; j < this.getNumbersOfColumn(); j++) {
                    temp[i] += this.components[i].getComponent(j) * vector.getComponent(j);
                }
            }
            return new Vector(this.getRowsNumber(), temp);
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
        if (m1.getNumbersOfColumn() != m2.getRowsNumber()) {
            throw new IllegalArgumentException("нельзя умножать. число столбцов в первой матрице должно совпадать с числом строк во второй");
        } else {
            Vector[] vector = new Vector[m2.getNumbersOfColumn()];
            for (int i = 0; i < m2.getNumbersOfColumn(); i++) {
                vector[i] = m1.multiplicationByVector(m2.getVectorColumn(i));
            }

            return new Matrix(vector).transpose();
        }
    }

    //f. Вычисление определителя матрицы

    public double getDeterminant() {
        double determinant = 0;
        if (this.components.length != this.getNumbersOfColumn()) {
            throw new IllegalArgumentException("матрица не имеет определителя");
        } else if (this.components.length == 2) {
            determinant = this.components[0].getComponent(0) * this.components[1].getComponent(1) - this.components[0].getComponent(1) * this.components[1].getComponent(0);
        } else if (this.components.length == 3) {

        } else {

        }
        return determinant;
    }

}