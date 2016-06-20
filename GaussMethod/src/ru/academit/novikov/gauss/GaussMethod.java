package ru.academit.novikov.gauss;

import ru.academit.novikov.matrix.Matrix;
import ru.academit.novikov.vector.Vector;

public class GaussMethod {
    private static final double EPSILON = 1e-10;
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
        //this.matrix = new Matrix(extendedMatrix);
        //return this.matrix;
        return extendedMatrix;
    }

    //прямой ход. приведение к нижнетреугольному виду
    public Matrix bottomTriangular() {
        Matrix bottomTriangular = getExtendedMatrix();
        for (int i = 0; i < bottomTriangular.getRowsNumber() - 1; i++) {

            double diagonalComponent = bottomTriangular.getComponent(i, i);

            for (int j = i + 1; j < bottomTriangular.getColumnsNumber() - 1; j++) {

                double k2 = bottomTriangular.getComponent(j, i) / diagonalComponent;
                bottomTriangular.setVectorLine(j, bottomTriangular.getVectorLine(j).minus(bottomTriangular.getVectorLine(i).multiplicationByScalar2(k2)));
            }
        }
        //return bottomTriangular;
        return new Matrix(bottomTriangular);
    }

    //обратный ход - получение диагональной матрицы
    public Matrix diagonalMatrix() {
        Matrix diagonalMatrix = bottomTriangular();
        for (int i = 0; i < diagonalMatrix.getRowsNumber() - 1; i++) {
            double diagonalComponent = diagonalMatrix.getComponent(i, i);
            if (Math.abs(diagonalComponent) > EPSILON) {
                for (int j = i + 1; j < diagonalMatrix.getColumnsNumber(); j++) {
                    double k2 = diagonalMatrix.getComponent(j, i) / diagonalComponent;
                    diagonalMatrix.setVectorLine(j, diagonalMatrix.getVectorLine(j).minus(diagonalMatrix.getVectorLine(i).multiplicationByScalar2(k2)));
                }
            }
        }
        return diagonalMatrix;
        //return new Matrix(bottomTriangular());
    }

    //получение единиц у диагональной матрицы
    public Matrix identityMatrix() {
        Matrix identityMatrix = diagonalMatrix();
        for (int i = 0; i < identityMatrix.getRowsNumber(); i++) {
            if (Math.abs(identityMatrix.getComponent(i, i)) > EPSILON) {
                double diagonalComponent = 1 / identityMatrix.getComponent(i, i);
                identityMatrix.setVectorLine(i, identityMatrix.getVectorLine(i).multiplicationByScalar2(diagonalComponent));
            }
        }
        //return new Matrix(diagonalMatrix());
        return identityMatrix;
    }

    //получение вектора решений
    public Vector getVectorSolves() {
        Matrix matrix = identityMatrix();
        Vector vectorSolutions = new Vector(matrix.getRowsNumber());
        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            vectorSolutions.setComponent(i, matrix.getComponent(i, matrix.getColumnsNumber() - 1));
        }
        /*
        System.out.println(EnumSolves.ONE_SOLVE);
        for (int i = 0; i < vectorSolutions.getVectorLength(); i++) {
        System.out.print(vectorSolutions.getComponent(i) + " ");
        }
         */
        if (this.matrix == null && this.vector == null) {
            System.out.println(EnumSolves.MANY_SOLVES.getMessage());
            //EnumSolves solves = EnumSolves.MANY_SOLVES;
            //EnumSolves solves = EnumSolves.MANY_SOLVES;
            //System.out.println(solves.getMessage());
            return null;
        }
        if (this.matrix == null) {
            EnumSolves solves = EnumSolves.NO_SOLVES;
            System.out.println(solves.getMessage());
            return null;
        }
        System.out.println(EnumSolves.ONE_SOLVE.getMessage());
        return vectorSolutions;
    }

    public void result() {
        if (this.matrix == null && this.vector == null) {
            System.out.println(EnumSolves.MANY_SOLVES.getMessage());
            //EnumSolves solves = EnumSolves.MANY_SOLVES;
            //EnumSolves solves = EnumSolves.MANY_SOLVES;
            //System.out.println(solves.getMessage());
            return;
        }
        if (this.matrix == null) {
            EnumSolves solves = EnumSolves.NO_SOLVES;
            System.out.println(solves.getMessage());
            return;
        }
        System.out.println(EnumSolves.ONE_SOLVE.getMessage());
        //EnumSolves solves = EnumSolves.ONE_SOLVE;
        //System.out.println(solves.getMessage());
        //for (int i = 0; i < getVectorSolves().getVectorLength(); i++) {
        //System.out.print(getVectorSolves().getComponent(i) + " ");
        //}
    }




    /*
    //получение вектора решений
    public Vector getVectorSolves() {
        if (this.matrix == null && this.vector == null) {
            return EnumSolves.MANY_SOLVES;
        }

        if (this.matrix == null) {
            return new EnumSolves.NO_SOLVES;
        }

        Matrix matrix = identityMatrix();
        Vector vectorSolutions = new Vector(identityMatrix().getRowsNumber());
        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            vectorSolutions.setComponent(i, matrix.getComponent(i, matrix.getColumnsNumber() - 1));
        }
        return new Vector(vectorSolutions);
    }

    public Vector getSolve2(Matrix matrix2, Vector vector2) {
        Vector v2 = new Vector(matrix2.getRowsNumber());
        for (int i = 0; i < matrix2.getRowsNumber(); i++) {
            v2.setComponent(i, matrix2.getComponent(i, matrix2.getColumnsNumber() - 1));
        }
        return new Vector(v2);
    }

        public Vector nulevoiVector() {
        return new Vector(this.matrix.getColumnsNumber() + 1);
    }

 */
}
