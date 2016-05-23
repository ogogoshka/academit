package ru.academit.novikov.matrix;

import ru.academit.novikov.vector.*;

public class Matrix {

    public Vector[] components;

    public Matrix() {
    }

    public Matrix(int rowsNumber, int columnsNumber) {
        if (rowsNumber <= 0) {
            throw new IllegalArgumentException("кол-во строк не может быть <= 0");
        } else if (columnsNumber <= 0) {
            throw new IllegalArgumentException("кол-во столбцов не может быть <= 0");
        }
        this.components = new Vector[rowsNumber];
        for (int i = 0; i < rowsNumber; i++) {
            this.components[i] = new Vector(columnsNumber);
        }
    }

    public Matrix(Matrix matrix) {
        Matrix m2 = new Matrix(matrix.components);
        this.components = m2.components;
        //this.components = new Vector[matrix.getRowsNumber()];
        //for (int i = 0; i < matrix.getRowsNumber(); i++) {
        //this(matrix.components[i]);
        //this.components[i] = new Vector(matrix.components[i]);
        //}
        //Matrix this.components = new Matrix(matrix.components);
        //this.components = new Matrix((new Vector[matrix.getRowsNumber()]) new Vector(matrix.components));
        //this.components = new Matrix(matrix.components);
        //matrix.components = new Vector[matrix.getRowsNumber()];
        //this.components = new Matrix(matrix.components);
        //this(Vector[matrix.components.length]matrix.components);
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

    public int getColumnsNumber() {
        return this.components[0].getSize();
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{ ");
        for (int i = 0; i < this.getRowsNumber(); i++) {
            if (i == this.getRowsNumber() - 1) {
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
        if (rowsNumber > this.getRowsNumber() || rowsNumber < 0) {
            throw new IllegalArgumentException("такой строки не существует");
        }
        this.components[rowsNumber] = new Vector(vector);
    }

    public Vector getVectorColumn(int columnsNumber) {
        if (columnsNumber > this.getColumnsNumber() || columnsNumber < 0) {
            throw new IllegalArgumentException("такого столбца не существует");
        }
        double[] temp = new double[this.getRowsNumber()];
        for (int i = 0; i < this.getRowsNumber(); i++) {
            temp[i] = this.components[i].getComponent(columnsNumber);
        }
        return new Vector(this.getRowsNumber(), temp);
    }

    public Matrix transpose() {
        Vector[] arrayOfVectors = new Vector[this.getColumnsNumber()];
        for (int j = 0; j < this.getColumnsNumber(); j++) {
            arrayOfVectors[j] = this.getVectorColumn(j);
        }
        this.components = arrayOfVectors;
        return this;
    }

    public void multiplicationByScalar(double scalar) {
        for (Vector component : this.components) {
            component.multiplicationByScalar(scalar);
        }
    }

    public Matrix add(Matrix matrix) {
        if (this.getRowsNumber() >= matrix.getRowsNumber()) {
            for (int i = 0; i < matrix.getRowsNumber(); i++) {
                this.components[i].add(matrix.components[i]);
            }
            return this;
        } else {
            for (int i = 0; i < this.getRowsNumber(); i++) {
                matrix.components[i].add(this.components[i]);
            }
            this.components = new Vector[matrix.getRowsNumber()];
            for (int i = 0; i < this.getRowsNumber(); i++) {
                this.components[i] = new Vector(matrix.components[i]);
            }
            //this.components = matrix.components;
            return this;
        }
    }

    public Matrix minus(Matrix matrix) {
        if (this.getRowsNumber() >= matrix.getRowsNumber()) {
            for (int i = 0; i < matrix.getRowsNumber(); i++) {
                this.components[i].minus(matrix.components[i]);
            }
            return this;
        } else {
            for (int i = 0; i < this.getRowsNumber(); i++) {
                matrix.components[i].minus(this.components[i]);

            }
            this.components = new Vector[matrix.getRowsNumber()];
            for (int i = 0; i < this.getRowsNumber(); i++) {
                this.components[i] = new Vector(matrix.components[i].multiplicationByScalar2(-1));
            }
            //this.components = matrix.components;
            //return matrix;
            //this.components = matrix.components;
            return this;
        }
    }

    //int maxRowsNumber = Math.max(matrix.getRowsNumber(), this.getRowsNumber());
    //for (int i = 0; i < maxRowsNumber; i++) {
    //this.components[i].minus(matrix.components[i]);
    //}
    //return this;
    //}

    public Vector multiplicationByVector(Vector vector) {
        if (this.getColumnsNumber() != vector.getSize()) {
            throw new IllegalArgumentException("нельзя умножать, кол-во столбцов в матрице должно совпадать с кол-вом элементов в векторе");
        }
        double[] temp = new double[this.getRowsNumber()];
        for (int i = 0; i < this.getRowsNumber(); i++) {
            for (int j = 0; j < this.getColumnsNumber(); j++) {
                temp[i] += this.components[i].getComponent(j) * vector.getComponent(j);
            }
        }
        return new Vector(this.getRowsNumber(), temp);
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
        if (m1.getColumnsNumber() != m2.getRowsNumber()) {
            throw new IllegalArgumentException("нельзя умножать. число столбцов в первой матрице должно совпадать с числом строк во второй");
        }
        Vector[] vector = new Vector[m2.getColumnsNumber()];
        for (int i = 0; i < m2.getColumnsNumber(); i++) {
            vector[i] = m1.multiplicationByVector(m2.getVectorColumn(i));
        }
        return new Matrix(vector).transpose();
    }

    //f. Вычисление определителя матрицы
    public double getDeterminant() {
        double determinant = 1;
        if (this.components.length != this.getColumnsNumber()) {
            throw new IllegalArgumentException("матрица не имеет определителя");
        }
        for (int i = 0; i < this.getRowsNumber() - 1; i++) {
            double diagonalComponent = this.components[i].getComponent(i);
            for (int j = i + 1; j < this.getColumnsNumber(); j++) {
                double k = this.components[j].getComponent(i) / diagonalComponent;
                this.setVectorLine(j, this.getVectorLine(j).minus(this.getVectorLine(i).multiplicationByScalar2(k)));
            }
        }
        for (int i = 0; i < this.getRowsNumber(); i++) {
            determinant = determinant * this.components[i].getComponent(i);
        }
        return determinant;
    }
}

/*

    public Matrix add(Matrix matrix) {
        int maxRowsNumber = Math.max(matrix.getRowsNumber(), this.getRowsNumber());
        int minRowsNumber = Math.min(matrix.getRowsNumber(), this.getRowsNumber());

        Vector[] v2 = new Vector[maxRowsNumber];
        Vector[] v3 = new Vector[maxRowsNumber];

        //Matrix m2 = new Matrix(maxRowsNumber, maxRowsNumber);
        //v2 = this.components;

        if (this.getRowsNumber() >= matrix.getRowsNumber()) {
            for (int i = 0; i < this.getRowsNumber(); i++) {
                //v2[i] = new Vector(this.components[i]);
            }
            for (int i = 0; i < matrix.getRowsNumber(); i++) {
                //v2[i].add(matrix.components[i]);
                this.components[i].add(matrix.components[i]);
            }
            return this;
        } else {
            for (int i = 0; i < matrix.getRowsNumber(); i++) {
                //v2[i] = new Vector(matrix.components[i]);
            }
            for (int i = 0; i < this.getRowsNumber(); i++) {
                //v2[i].add(this.components[i]);
                matrix.components[i].add(this.components[i]);
            }
            this.components = matrix.components;
            return this;
        }


        for (int i = 0; i < this.getRowsNumber(); i++) {
            v2[i] = new Vector(this.components[i]);
            //this.components[i].add(matrix.components[i]);
            //v2[i].add(matrix.components[i]);
            //v2[i] = new Vector(matrix.components[i]);
            //v2[i] = null;
            //v2[i].add(matrix.components[i]);
            //this.components[i] = Vector.add(this.components[i], matrix.components[i]);
        }

        //this.components = new Vector[maxRowsNumber];

        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            //this.components[i].add(v2[i]);
            v2[i].add(matrix.components[i]);
            //v3[i] = new Vector(this.components[i]);
        }



//Vector[]this.components = new Vector[maxRowsNumber];
//for (int i = 0; i < maxRowsNumber; i++) {
//this.components[i].add(v2[i]);
//v2[i].add(this.components[i]);
//this.components[i] = new Vector(v2[i]);

//v2[i].add(v3[i]);
//this.components[i] = new Vector(v2[i]);
//}
//        this.components = v2;



*/