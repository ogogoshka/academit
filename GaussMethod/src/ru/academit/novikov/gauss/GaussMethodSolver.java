package ru.academit.novikov.gauss;

import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

public class GaussMethodSolver {
    private static final double EPSILON = 1e-10;
    private Vector vector;
    private Matrix matrix;

    private Matrix extendedMatrix;
    private Matrix bottomTriangular;

    public GaussMethodSolver(Matrix matrix, Vector vector) {
        if (matrix.getRowsNumber() != vector.getSize()) {
            throw new IllegalArgumentException("некорректные данные. кол-во строк в матрице должно совпадать с кол-вом элементов вектора");
        }
        this.vector = vector;
        this.matrix = matrix;
        //solve();
    }

    /*
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
     */
    //получение расширенной матрицы
    private Matrix getExtendedMatrix() {
        if (extendedMatrix == null) {
            extendedMatrix = new Matrix(this.matrix.getRowsNumber(), this.matrix.getColumnsNumber() + 1);
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
        }
        return extendedMatrix;
    }

    //прямой ход. приведение к нижнетреугольному виду
    private Matrix bottomTriangular() {
        if (bottomTriangular == null) {
            bottomTriangular = getExtendedMatrix();
            for (int i = 0; i < bottomTriangular.getRowsNumber() - 1; i++) {
                double diagonalComponent = bottomTriangular.getComponent(i, i);
                for (int j = i + 1; j < bottomTriangular.getColumnsNumber() - 1; j++) {
                    double k = bottomTriangular.getComponent(j, i) / diagonalComponent;
                    bottomTriangular.setVectorLine(j, bottomTriangular.getVectorLine(j).minus(bottomTriangular.getVectorLine(i).multiplicationByScalar2(k)));
                }
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
    private Vector getVectorSolution() {
        Matrix matrix = diagonalMatrix();
        Vector vectorSolutions = new Vector(matrix.getRowsNumber());
        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            vectorSolutions.setComponent(i, matrix.getComponent(i, matrix.getColumnsNumber() - 1));
        }
        return vectorSolutions;
    }

    public void solve2() {

    }

    public void solve() {
        //Matrix extendedMatrix = getExtendedMatrix();
        extendedMatrix = getExtendedMatrix();
        if (isMatrixContainZeroLineExceptLastElement(extendedMatrix)) {
            System.out.println(Solution.NO_SOLUTION.getMessage());
        } else if (isMatrixContainZeroLine(extendedMatrix)) {
            System.out.println(Solution.MANY_SOLUTIONS.getMessage());
        } else {
            //Matrix bottomTriangular = bottomTriangular();
            bottomTriangular = bottomTriangular();
            if (isMatrixContainZeroLineExceptLastElement(bottomTriangular)) {
                System.out.println(Solution.NO_SOLUTION.getMessage());
            } else if (isMatrixContainZeroLine(bottomTriangular)) {
                System.out.println(Solution.MANY_SOLUTIONS.getMessage());
            } else {
                System.out.println(Solution.ONE_SOLUTION.getMessage());
                Vector vector = getVectorSolution();
                System.out.println(vector.toString());
            }
        }
    }

    //поиск хотя бы одной нулевой строки
    public static boolean isMatrixContainZeroLine(Matrix matrix) {
        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            if (matrix.getVectorLine(i).isAllZeroElements()) {
                return true;
            }
        }
        return false;
    }

    //поиск хотя бы одной строки где все элементы НУЛИ кроме последнего элемента
    public static boolean isMatrixContainZeroLineExceptLastElement(Matrix matrix) {
        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            for (int j = 0; j < matrix.getColumnsNumber() - 2; j++) {
                if (Math.abs(matrix.getVectorLine(i).getComponent(j)) > EPSILON) {
                    return false;
                }
            }
            if (Math.abs(matrix.getVectorLine(i).getComponent(matrix.getColumnsNumber() - 1)) >= EPSILON) {
                return true;
            }
        }
        return false;
    }

}