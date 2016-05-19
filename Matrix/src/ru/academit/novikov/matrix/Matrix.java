package ru.academit.novikov.matrix;

public class Matrix {

    private int sizeN;
    private int sizeM;
    private double[][] components;

    public Matrix(int sizeN, int sizeM) {
        if (sizeN < 0 || sizeM < 0) {
            throw new IllegalArgumentException("размеры матрицы не могут быть отрицательными");
        }
        components = new double[sizeN][sizeM];
    }

    public Matrix(Matrix m2) {

        double[][] temp = new double[m2.components.length][];
        temp = m2.components;

        System.arraycopy(m2.components, 0, temp, 0, m2.components.length);

        //double[] temp = new double[v1.getSize()];
        //System.arraycopy(m2.components, 0, temp, 0, m2.length());
        //this.components = temp;

    }

    public Matrix(double[][] array) {
        double[][] temp = new double[array.length][];
        System.arraycopy(array, 0, temp, 0, array.length);
        this.components = temp;
    }

    public int[][] getSize() {
        this.sizeN = sizeN;
        this.sizeM = sizeM;
        //components.length = sizeN;
        //components[0].length = sizeM;
        int[][] temp = new int[1][2];
        temp[0][0] = sizeN;
        temp[0][1] = sizeM;
        return temp;
    }


    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{ ");

        for (int i = 0; i < components.length; i++) {
            for (int j = 0; j < components[i].length; j++) {
                if (j == 0) {
                    resultString.append("{ ");
                    resultString.append(this.components[i][j]);
                } else {
                    resultString.append(", ").append(this.components[i][j]);
                }
            }
            if (i == components.length - 1) {
                resultString.append(" }");
            } else {
                resultString.append(" } , ");
            }
        }
        return resultString.append(" }").toString();
    }


}
