package ru.academit.novikov.shapes;

public class Vector {

    private int[] arrayOfComponents;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("размерность вектора не может быть <= 0");
        }
        arrayOfComponents = new int[size];
    }

    public int getSize() {
        return arrayOfComponents.length;
    }

    //@Override
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


    public Vector(Vector v) {

        //this(v.getSize());
    }

    public Vector(int size, double[] array) {
        //this.size = size;
        //this.array = array;

        /*

        int[] size = new int[n];

        for (int i = 1; i < n; i++) {
            size[i] = array[i];
        }


         */
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