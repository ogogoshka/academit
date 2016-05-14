package ru.academit.novikov.vector;

public class Vector {

    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("размерность вектора не может быть <= 0");
        }
        components = new double[size];
        for (int i = 0; i < size; i++) {
            components[i] = 2;
        }
    }

    public Vector(Vector v1) {
        double[] temp = new double[v1.getSize()];
        System.arraycopy(v1.components, 0, temp, 0, v1.getSize());
        this.components = temp;
    }

    public Vector(int size, double[] array) {
        if (size < array.length) {
            double[] temp = new double[size];
            System.arraycopy(array, 0, temp, 0, size);
            this.components = temp;
        } else if (size > array.length) {
            double[] temp = new double[size];
            System.arraycopy(array, 0, temp, 0, array.length);
            this.components = temp;
        } else {
            double[] temp;
            temp = array;
            this.components = temp;
        }
    }

    private int getSize() {
        return components.length;
    }

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

    public Vector add(Vector v2) {
        if (this.getSize() < v2.getSize()) {
            double[] temp = new double[v2.getSize()];
            for (int j = 0; j < this.getSize(); j++) {
                temp[j] = this.components[j] + v2.components[j];
            }
            System.arraycopy(v2.components, this.getSize(), temp, this.getSize(), v2.getSize() - this.getSize());
            this.components = temp;
            return this;
        } else if (this.getSize() > v2.getSize()) {
            for (int j = 0; j < v2.getSize(); j++) {
                this.components[j] += v2.components[j];
            }
            System.arraycopy(this.components, v2.getSize(), this.components, v2.getSize(), this.getSize() - v2.getSize());
            return this;
        } else {
            for (int j = 0; j < this.getSize(); j++) {
                this.components[j] += v2.components[j];
            }
            return this;
        }
    }

    public Vector minus(Vector v2) {
        if (this.getSize() < v2.getSize()) {
            double[] temp = new double[v2.getSize()];
            for (int j = 0; j < this.getSize(); j++) {
                temp[j] = this.components[j] - v2.components[j];
            }
            for (int j = this.getSize(); j < v2.getSize(); j++) {
                temp[j] -= v2.components[j];
            }
            this.components = temp;
            return this;
        } else if (this.getSize() > v2.getSize()) {
            for (int j = 0; j < v2.getSize(); j++) {
                this.components[j] -= v2.components[j];
            }
            System.arraycopy(this.components, v2.getSize(), this.components, v2.getSize(), this.getSize() - v2.getSize());
            return this;
        } else {
            for (int j = 0; j < this.getSize(); j++) {
                this.components[j] -= v2.components[j];
            }
            return this;
        }
    }

    public void multiplicationByScalar(int scalar) {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] = scalar * this.components[i];
        }
    }

    public void reverse() {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] = (-1) * this.components[i];
        }
    }

    public double getVectorLength() {
        double sum = 0;
        for (double component : this.components) {
            sum = sum + component * component;
        }
        return Math.sqrt(sum);
    }

    public double getComponent(int i) {
        return this.components[i];
    }

    public void setComponent(int i, double newComponent) {
        this.components[i] = newComponent;
    }



















    

    //5.Реализовать статические методы – должны создаваться новые векторы

    //a.Сложение двух векторов
    public Vector sum(Vector v1, Vector v2) {


        if (v1.getSize() < v2.getSize()) {

            Vector v3 = new Vector(v2.getSize());
            double[] temp = new double[v2.getSize()];

            for (int j = 0; j < v1.getSize(); j++) {
                temp[j] = v1.components[j] + v2.components[j];
            }

            System.arraycopy(v2.components, v1.getSize(), temp, v1.getSize(), v2.getSize() - v1.getSize());
            //v1.components = temp;
            v3.components = temp;
            this.components = temp;
            //this.components=temp;
            return this;

        } else if (v1.getSize() > v2.getSize()) {

            Vector v3 = new Vector(v1.getSize());
            double[] temp = new double[v1.getSize()];

            for (int j = 0; j < v2.getSize(); j++) {
                temp[j] = v1.components[j] + v2.components[j];
            }

            System.arraycopy(v1.components, v2.getSize(), temp, v2.getSize(), v1.getSize() - v2.getSize());
            //v1.components = temp;
            v3.components = temp;
            this.components = temp;
            //this.components=temp;
            return this;

        } else {

            //Vector v3 = new Vector(v1.getSize());
            double[] temp = new double[v1.getSize()];

            for (int j = 0; j < v1.getSize(); j++) {
                temp[j] = v1.components[j] + v2.components[j];
            }
            this.components = temp;
            //this.components=temp;
            return this;
        }

        //return this.v3.components;
    }


    //b.Вычитание векторов


    //c.Скалярное произведение векторов






/*

        }
        else if (v2.getSize() > v1.getSize()) {
            for (int i = 0; i < v1.getSize(); i++) {
                v2.components[i] = v2.components[i] + v1.components[i];
            }

            for (int i = v1.getSize(); i < v2.getSize(); i++) {
                v2.components[i] = v2.components[i];
            }
            return v2.components;

        } else {
            for (int i = 0; i < v1.getSize(); i++) {
                v1.components[i] = v1.components[i] + v2.components[i];
            }
            return v1.components;
        }

    //умноженеи вектора на скаляр
    public double[] multiplicationByScalar2(int scalar) {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] = scalar * this.components[i];
        }
        return this.components;
    }

 */

    //return v1.components;


    //разворот вектора
    public Vector reverse2() {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] = (-1) * this.components[i];
        }
        return this;
    }

  /*
    public double[] getScalarProductOfVectors(Vector v1, Vector v2) {
        return v1.components;
    }


    public Vector(int size, double[] array) {

        //(double)this.components[] = array[];


        //this.size = size;
        //this.array = array;



        double[] size = new int[n];

        for (int i = 1; i < n; i++) {
            size[i] = array[i];
        }



    }
*/





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


    //private double[] size;


    //double[] components = new int[size];


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


//c.Vector(n, double[]) – заполнение вектора значениями из массива.

//for (int i = 0; i < size; i++) {
//            this.components[i] = this.components[i] + array[i];
//        }
//this.components = v1.components;


    /*

        public Vector add(Vector v2) {
        if (this.getSize() < v2.getSize()) {
            double[] temp = new double[v2.getSize()];
            for (int j = 0; j < this.getSize(); j++) {
                temp[j] = this.components[j] + v2.components[j];
            }
            for (int j = this.getSize(); j < v2.getSize(); j++) {
                temp[j] = temp[j] + v2.components[j];
            }
            this.components = temp;
            return this;
        } else if (this.getSize() > v2.getSize()) {
            double[] temp = new double[this.getSize()];
            for (int j = 0; j < v2.getSize(); j++) {
                temp[j] = this.components[j] + v2.components[j];
            }
            System.arraycopy(this.components, v2.getSize(), temp, v2.getSize(), this.getSize() - v2.getSize());
            this.components = temp;
            return this;
        } else {
            for (int j = 0; j < this.getSize(); j++) {
                this.components[j] = this.components[j] + v2.components[j];
            }
            return this;
        }
    }

     */