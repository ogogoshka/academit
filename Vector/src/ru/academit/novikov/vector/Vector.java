package ru.academit.novikov.vector;

public class Vector {

    private int[] arrayOfComponents;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("размерность вектора не может быть <= 0");
        }
        arrayOfComponents = new int[size];
        for (int i = 0; i < size; i++) {
            arrayOfComponents[i] = 2;
        }
    }

    public int getSize() {
        return arrayOfComponents.length;
    }

    public String toString() {
        String resultString = "";
        for (int i = 0; i < arrayOfComponents.length; i++) {
            if (i == 0) {
                resultString += arrayOfComponents[i];
            } else {
                resultString += " , " + arrayOfComponents[i];
            }
        }
        resultString = "{" + resultString + "}";
        return resultString;
    }


    public int[] getAdditionOfVector(Vector v1, Vector v2) {

        if (v2.getSize() < v1.getSize()) {
            for (int i = 0; i < v2.getSize(); i++) {
                v1.arrayOfComponents[i] = v1.arrayOfComponents[i] + v2.arrayOfComponents[i];
            }

            for (int i = v2.getSize(); i < v1.getSize(); i++) {
                v1.arrayOfComponents[i] = v1.arrayOfComponents[i];
            }
            return v1.arrayOfComponents;

        } else if (v2.getSize() > v1.getSize()) {
            for (int i = 0; i < v1.getSize(); i++) {
                v2.arrayOfComponents[i] = v2.arrayOfComponents[i] + v1.arrayOfComponents[i];
            }

            for (int i = v1.getSize(); i < v2.getSize(); i++) {
                v2.arrayOfComponents[i] = v2.arrayOfComponents[i];
            }
            return v2.arrayOfComponents;

        } else {
            for (int i = 0; i < v1.getSize(); i++) {
                v1.arrayOfComponents[i] = v1.arrayOfComponents[i] + v2.arrayOfComponents[i];
            }
            return v1.arrayOfComponents;
        }
    }

    public int[] getMultiplicationVectorByScalar(int scalar) {
        for (int i = 0; i < arrayOfComponents.length; i++) {
            arrayOfComponents[i] = scalar * arrayOfComponents[i];
        }
        return arrayOfComponents;
    }


    public int[] getVectorReversal() {
        for (int i = 0; i < arrayOfComponents.length; i++) {
            arrayOfComponents[i] = (-1) * arrayOfComponents[i];
        }
        return arrayOfComponents;
    }

    public int getSubtractAnotherVector() {
        return 0;
    }

    public static int getScalarProductOfVectors(Vector v1, Vector v2) {

        return 0;
    }


    public Vector(int size, double[] array) {

        //(double)this.arrayOfComponents[] = array[];


        //this.size = size;
        //this.array = array;

        /*

        int[] size = new int[n];

        for (int i = 1; i < n; i++) {
            size[i] = array[i];
        }


         */
    }


    public Vector(Vector v) {

        //this(v.getSize());
    }



/*

    //@Override
    public String toString() {
        return getClass().getName() + "    Vector{" + "n = " + n + "}";
    }



    private int a;

    //@Override
    public String toString() {

        return getClass().getName() + "    Vector{" + "n = " + n + "}";
    }
 */
    /*

    //@Override
    public String toString2() {
        String resultString = "";
        for (int i = 1; i < n; i++) {
            size[i] = 0;
            if (i == 0) {
                resultString += size[i];
            } else {
                resultString += " , " + size[i];
            }
        }
        resultString = "{" + resultString + "}";
        return resultString;
    }

     */
//private int n;
//    private int razmer;
//    private double[] array;


    //private int[] size;


    //int[] arrayOfComponents = new int[size];


}



/*

        if (ar2.length < ar1.length) {
            for (int i = 0; i < ar2.length; i++) {
                ar1[i] = ar1[i] + ar2[i];
            }

            for (int i = ar2.length; i < ar1.length; i++) {
                ar1[i] = ar1[i];
            }

        } else if (ar2.length > ar1.length) {
            for (int i = 0; i < ar1.length; i++) {
                ar2[i] = ar2[i] + ar1[i];
            }

            for (int i = ar1.length; i < ar2.length; i++) {
                ar2[i] = ar2[i];
            }

        } else {
            for (int i = 0; i < ar1.length; i++) {
                ar1[i] = ar1[i] + ar2[i];
            }
        }

 */