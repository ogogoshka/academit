package ru.academit.novikov.gauss;

import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

public class GaussMethod {
    public Vector vector;
    public Matrix matrix;

    public GaussMethod(Matrix matrix, Vector vector) {
        if (matrix.getRowsNumber() != vector.getSize()) {
            throw new IllegalArgumentException("некорректные данные. кол-во строк в матрице должно совпадать с кол-вом элементов вектора");
        }
        this.vector = vector;
        this.matrix = matrix;
    }

    //получение расширенной матрицы
    public Matrix getExtendedMatrix() {
        Matrix extendedMatrix = new Matrix(this.matrix.getRowsNumber(), this.matrix.getColumnsNumber() + 1);
        extendedMatrix.add(this.matrix);
        extendedMatrix.setVectorColumn(extendedMatrix.getColumnsNumber() - 1, this.vector);
        //swap lines
        for (int i = 0; i < extendedMatrix.getRowsNumber(); i++) {
            int max = i;
            for (int j = i + 1; j < extendedMatrix.getRowsNumber(); j++) {
                if (Math.abs(extendedMatrix.getComponent(j, i)) > Math.abs(extendedMatrix.getComponent(i, i))) {
                    max = j;
                }
                extendedMatrix.replaceLine(i, max);
            }
        }
        return extendedMatrix;
    }

    //прямой ход. приведение к нижнетреугольному виду
    public Matrix bottomTriangular() {
        for (int i = 0; i < getExtendedMatrix().getRowsNumber() - 1; i++) {
            double diagonalComponent2 = getExtendedMatrix().getComponent(i, i);
            for (int j = i + 1; j < getExtendedMatrix().getColumnsNumber(); j++) {
                double k2 = getExtendedMatrix().getComponent(j, i) / diagonalComponent2;
                getExtendedMatrix().setVectorLine(j, getExtendedMatrix().getVectorLine(j).minus(getExtendedMatrix().getVectorLine(i).multiplicationByScalar2(k2)));
            }
        }
        return new Matrix(getExtendedMatrix());
    }

    //обратный ход
    public Matrix backSubstitution() {
        for (int i = 0; i < bottomTriangular().getRowsNumber() - 1; i++) {
            double diagonalComponent2 = bottomTriangular().getComponent(i, i);
            for (int j = i + 1; j < bottomTriangular().getColumnsNumber(); j++) {
                double k2 = bottomTriangular().getComponent(j, i) / diagonalComponent2;
                bottomTriangular().setVectorLine(j, bottomTriangular().getVectorLine(j).minus(bottomTriangular().getVectorLine(i).multiplicationByScalar2(k2)));
            }
        }
        return new Matrix(bottomTriangular());
    }

    public Matrix poluchenieEdinic() {
        for (int i = 0; i < backSubstitution().getRowsNumber(); i++) {
            double diagonalComponent3 = 1 / backSubstitution().getComponent(i, i);
            backSubstitution().setVectorLine(i, backSubstitution().getVectorLine(i).multiplicationByScalar2(diagonalComponent3));
        }
        return new Matrix(backSubstitution());
    }

    public static Vector getReshenie(Matrix matrix2, Vector vector2) {
        Vector v2 = new Vector(matrix2.getRowsNumber());
        for (int i = 0; i < matrix2.getRowsNumber(); i++) {
            v2.setComponent(i, matrix2.getComponent(i, matrix2.getColumnsNumber() - 1));
        }
        return new Vector(v2);
    }

    public Vector getReshenie2(Matrix matrix2, Vector vector2) {
        Vector v2 = new Vector(matrix2.getRowsNumber());
        for (int i = 0; i < matrix2.getRowsNumber(); i++) {
            v2.setComponent(i, matrix2.getComponent(i, matrix2.getColumnsNumber() - 1));
        }
        return new Vector(v2);
    }

    public Vector nulevoiVector() {
        return new Vector(this.matrix.getColumnsNumber() + 1);
    }


}
