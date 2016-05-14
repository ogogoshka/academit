
package ru.academit.novikov.vector;

public class Vector {

    private int[] components;

    //1.Конструкторы
    //a.Vector(n) – размерность n, все компоненты равны 0
    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("размерность вектора не может быть <= 0");
        }
        components = new int[size];
        for (int i = 0; i < size; i++) {
            components[i] = 2;
        }
    }

    //b.Vector(Vector) – конструктор копирования
    public Vector(Vector v1) {
        this.components = v1.components;
    }

    //c.Vector(n, double[]) – заполнение вектора значениями из массива.
    public Vector(int size, int[] array) {

        if (size < array.length) {
            this.components = array;

        } else if (size > array.length) {
            int[] temp = new int[size];

            System.arraycopy(array, 0, temp, 0, array.length);

            for (int i = array.length; i < size; i++) {
                temp[i] = 0;
            }

            this.components = temp;

        } else {
            this.components = array;
        }
    }

    //2.Метод getSize() для получения размерности вектора
    public int getSize() {
        return components.length;
    }

    //3.Реализовать метод toString(), чтобы печатал вектор в  формате { значения компонент через запятую } Например, { 1, 2, 3 }
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

    //a.Прибавление к вектору другого вектора
    public Vector add(Vector v2) {

        if (this.getSize() < v2.getSize()) {

            int[] temp = new int[v2.getSize()];

            for (int j = 0; j < this.getSize(); j++) {
                temp[j] = this.components[j] + v2.components[j];
            }

            for (int j = this.getSize(); j < v2.getSize(); j++) {
                temp[j] = temp[j] + v2.components[j];
            }
            this.components = temp;
            return this;

        } else if (this.getSize() > v2.getSize()) {

            int[] temp = new int[this.getSize()];

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

    //b.Вычитание из вектора другого вектора
    public Vector deduct(Vector v2) {

        if (this.getSize() < v2.getSize()) {

            int[] temp = new int[v2.getSize()];

            for (int j = 0; j < this.getSize(); j++) {
                temp[j] = this.components[j] - v2.components[j];
            }

            for (int j = this.getSize(); j < v2.getSize(); j++) {
                temp[j] = temp[j] - v2.components[j];
            }
            this.components = temp;
            return this;

        } else if (this.getSize() > v2.getSize()) {

            int[] temp = new int[this.getSize()];

            for (int j = 0; j < v2.getSize(); j++) {
                temp[j] = this.components[j] - v2.components[j];
            }

            System.arraycopy(this.components, v2.getSize(), temp, v2.getSize(), this.getSize() - v2.getSize());
            this.components = temp;
            return this;

        } else {
            for (int j = 0; j < this.getSize(); j++) {
                this.components[j] = this.components[j] - v2.components[j];
            }
            return this;
        }
    }

    //c.Умножение вектора на скаляр
    public void multiplicationByScalar(int scalar) {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] = scalar * this.components[i];
        }
    }

    //d.Разворот вектора (умножение всех компонент на -1)
    public void reverse() {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] = (-1) * this.components[i];
        }
    }

    //e.Получение длины вектора
    public double getVectorLength() {
        double sum = 0;
        for (int component : this.components) {
            sum = sum + component * component;
        }
        return Math.sqrt(sum);
    }

    //f.Получение и установка компоненты вектора по индексу
    public double getComponent(int i) {
        return this.components[i];
    }

    public void setComponent(int newComponent, int i) {
        this.components[i] = newComponent;
    }






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
    public int[] multiplicationByScalar2(int scalar) {
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
    public int[] getScalarProductOfVectors(Vector v1, Vector v2) {
        return v1.components;
    }


    public Vector(int size, double[] array) {

        //(double)this.components[] = array[];


        //this.size = size;
        //this.array = array;



        int[] size = new int[n];

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


    //private int[] size;


    //int[] components = new int[size];


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
