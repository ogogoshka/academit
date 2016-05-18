package ru.academit.novikov.vector;

import java.util.Arrays;

public class Vector {

    private final static double EPSILON = 0.0001;
    private double[] components;

    public Vector() {
    }

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("размерность вектора не может быть <= 0");
        }
        components = new double[size];
    }

    public Vector(Vector v1) {
        double[] temp = new double[v1.getSize()];
        System.arraycopy(v1.components, 0, temp, 0, v1.getSize());
        this.components = temp;
    }

    public Vector(int size, double[] array) {
        int minLength = Math.min(size, array.length);
        double[] temp = new double[size];
        System.arraycopy(array, 0, temp, 0, minLength);
        this.components = temp;
    }

    private int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{ ");
        for (int i = 0; i < components.length; i++) {
            if (i == 0) {
                resultString.append(components[i]);
            } else {
                resultString.append(", ").append(components[i]);
            }
        }
        return resultString.append(" }").toString();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (o == this)
            return true;
        Vector v2 = (Vector) o;
        for (int i = 0; i < this.getSize(); i++) {
            if (!((Math.abs(this.components[i] - v2.components[i]) < EPSILON) && this.getSize() == v2.getSize())) //{
                //} //else {
                return false;
            //}
        }
        return true;
    }
    /*
        @Override
    public boolean equals(Object obj) {
        }
        for (int i = 0; i < this.getSize(); i++) {
            return (this.getSize() == obj.getSize()) && (Math.abs(this.components[i] - obj.components[i]) < EPSILON);
        }
        return false;
    }
     */


    public Vector add(Vector v2) {
        int maxLength = Math.max(this.getSize(), v2.getSize());
        double[] temp = new double[maxLength];
        System.arraycopy(v2.components, 0, temp, 0, v2.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            temp[i] = temp[i] + this.components[i];
        }
        Vector v3 = new Vector();
        v3.components = temp;
        return v3;
    }

    public Vector minus(Vector v2) {
        int maxLength = Math.max(this.getSize(), v2.getSize());
        double[] temp = new double[maxLength];
        System.arraycopy(this.components, 0, temp, 0, this.getSize());
        for (int i = 0; i < v2.getSize(); i++) {
            temp[i] = temp[i] - v2.components[i];
        }
        Vector v3 = new Vector();
        v3.components = temp;
        return v3;
    }

    public void multiplicationByScalar(int scalar) {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] = scalar * this.components[i];
        }
    }

    public void reverse() {
        this.multiplicationByScalar(-1);
    }

    public double getVectorLength() {
        double sum = 0;
        for (double component : this.components) {
            sum += component * component;
        }
        return Math.sqrt(sum);
    }

    public double getComponent(int i) {
        return this.components[i];
    }

    public void setComponent(int i, double newComponent) {
        this.components[i] = newComponent;
    }

    public static double scalarMultiplication(Vector v1, Vector v2) {
        double multiplication = 0;
        int minLength = Math.min(v1.getSize(), v2.getSize());
        for (int j = 0; j < minLength; j++) {
            multiplication += v1.components[j] * v2.components[j];
        }
        return Math.sqrt(multiplication);
    }

    public static Vector add(Vector v1, Vector v2) {
        Vector v3 = new Vector(v1);
        return v3.add(v2);
    }

    public static Vector minus(Vector v1, Vector v2) {
        Vector v3 = new Vector(v1);
        return v3.minus(v2);
    }
}