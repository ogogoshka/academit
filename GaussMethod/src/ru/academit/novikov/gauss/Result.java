package ru.academit.novikov.gauss;

import ru.academit.novikov.vector.Vector;

public class Result {

    private Vector vectorSolution;
    private Solution numberOfSolution;

    public Result(Solution numberOfSolution, Vector vectorSolution) {
        this.vectorSolution = vectorSolution;
        this.numberOfSolution = numberOfSolution;
    }


    public Solution getNumberOfSolution() {
        return numberOfSolution;
    }

    public Vector getVectorSolution() {
        return vectorSolution;
    }

    public static void printSolution(Vector vector) {
        System.out.println(vector.toString());
    }
}