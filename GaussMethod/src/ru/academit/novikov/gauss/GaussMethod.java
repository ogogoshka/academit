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

    public Matrix getExtendedMatrix() {
        Matrix extendedMatrix = new Matrix(this.matrix.getRowsNumber(), this.matrix.getColumnsNumber() + 1);
        extendedMatrix.add(this.matrix);
        extendedMatrix.setVectorColumn(extendedMatrix.getColumnsNumber() - 1, this.vector);
        return extendedMatrix;
    }

    public Matrix pryamoiHod() {
        for (int i = 0; i < getExtendedMatrix().getRowsNumber() - 1; i++) {
            double diagonalComponent2 = getExtendedMatrix().getComponent(i, i);
            for (int j = i + 1; j < getExtendedMatrix().getColumnsNumber(); j++) {
                double k2 = getExtendedMatrix().getComponent(j, i) / diagonalComponent2;
                getExtendedMatrix().setVectorLine(j, getExtendedMatrix().getVectorLine(j).minus(getExtendedMatrix().getVectorLine(i).multiplicationByScalar2(k2)));
            }
        }
        return new Matrix(getExtendedMatrix());
    }

    public Matrix obratniiHod() {
        for (int i = 0; i < pryamoiHod().getRowsNumber() - 1; i++) {
            double diagonalComponent2 = pryamoiHod().getComponent(i, i);
            for (int j = i + 1; j < pryamoiHod().getColumnsNumber(); j++) {
                double k2 = pryamoiHod().getComponent(j, i) / diagonalComponent2;
                pryamoiHod().setVectorLine(j, pryamoiHod().getVectorLine(j).minus(pryamoiHod().getVectorLine(i).multiplicationByScalar2(k2)));
            }
        }
        return new Matrix(pryamoiHod());
    }

    public Matrix poluchenieEdinic() {
        for (int i = 0; i < obratniiHod().getRowsNumber(); i++) {
            double diagonalComponent3 = 1 / obratniiHod().getComponent(i, i);
            obratniiHod().setVectorLine(i, obratniiHod().getVectorLine(i).multiplicationByScalar2(diagonalComponent3));
        }
        return new Matrix(obratniiHod());
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
