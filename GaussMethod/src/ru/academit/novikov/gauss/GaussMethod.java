package ru.academit.novikov.gauss;

import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

public class GaussMethod {
    private static final double EPSILON = 1e-10;
    private Vector vector;
    private Matrix matrix;

    public GaussMethod(Matrix matrix, Vector vector) {
        if (matrix.getRowsNumber() != vector.getSize()) {
            throw new IllegalArgumentException("некорректные данные. кол-во строк в матрице должно совпадать с кол-вом элементов вектора");
        }
        this.vector = vector;
        this.matrix = matrix;
        //endResult();
    }

    //получение расширенной матрицы
    private Matrix getExtendedMatrix() {
        Matrix extendedMatrix = new Matrix(this.matrix.getRowsNumber(), this.matrix.getColumnsNumber() + 1);
        extendedMatrix.add(this.matrix);
        extendedMatrix.setVectorColumn(extendedMatrix.getColumnsNumber() - 1, this.vector);
        //replace lines
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
    private Matrix bottomTriangular() {
        Matrix bottomTriangular = getExtendedMatrix();
        for (int i = 0; i < bottomTriangular.getRowsNumber() - 1; i++) {
            double diagonalComponent = bottomTriangular.getComponent(i, i);
            for (int j = i + 1; j < bottomTriangular.getColumnsNumber() - 1; j++) {
                double k = bottomTriangular.getComponent(j, i) / diagonalComponent;
                bottomTriangular.setVectorLine(j, bottomTriangular.getVectorLine(j).minus(bottomTriangular.getVectorLine(i).multiplicationByScalar2(k)));
            }
        }
        return bottomTriangular;
    }

    //обратный ход - получение диагональной матрицы
    private Matrix diagonalMatrix() {
        Matrix diagonalMatrix = bottomTriangular();
        for (int i = 0; i < diagonalMatrix.getRowsNumber(); i++) {
            if (Math.abs(diagonalMatrix.getComponent(i, i)) > EPSILON) {
                double diagonalComponent = 1 / diagonalMatrix.getComponent(i, i);
                diagonalMatrix.setVectorLine(i, diagonalMatrix.getVectorLine(i).multiplicationByScalar2(diagonalComponent));
            }
        }

        for (int i = diagonalMatrix.getRowsNumber() - 1; i > 0; i--) {
            double diagonalComponent = diagonalMatrix.getComponent(i, i);
            for (int j = i - 1; j >= 0; j--) {
                double k = diagonalMatrix.getComponent(j, i);
                k = k / diagonalComponent;
                diagonalMatrix.setVectorLine(j, diagonalMatrix.getVectorLine(j).minus(diagonalMatrix.getVectorLine(i).multiplicationByScalar2(k)));
            }
        }
        return diagonalMatrix;
    }

    //получение вектора решений
    private Vector getVectorSolves() {
        Matrix matrix = diagonalMatrix();
        Vector vectorSolutions = new Vector(matrix.getRowsNumber());
        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            vectorSolutions.setComponent(i, matrix.getComponent(i, matrix.getColumnsNumber() - 1));
        }
        return vectorSolutions;
    }

    public void endResult() {
        Matrix extendedMatrix = getExtendedMatrix();
        if (extendedMatrix.isMatrixContainZeroLineExceptLastElement()) {
            System.out.println(EnumSolves.NO_SOLVES.getMessage());
        } else if (extendedMatrix.isMatrixContainZeroLine()) {
            System.out.println(EnumSolves.MANY_SOLVES.getMessage());
        } else {
            Matrix bottomTriangular = bottomTriangular();
            if (bottomTriangular.isMatrixContainZeroLineExceptLastElement()) {
                System.out.println(EnumSolves.NO_SOLVES.getMessage());
            } else if (bottomTriangular.isMatrixContainZeroLine()) {
                System.out.println(EnumSolves.MANY_SOLVES.getMessage());
            } else {
                System.out.println(EnumSolves.ONE_SOLVE.getMessage());
                Vector vector = getVectorSolves();
                System.out.println(vector.toString());
            }
        }
    }

}