package ru.academit.novikov.gauss;

import ru.academit.novikov.vector.Vector;

public class Result {

    private Vector vectorSolution;
    private static Solution numberOfSolutions;

    public Result() {

    }


    public Solution getNumberOfSolutions() {
        return numberOfSolutions;
    }

    public Vector getVectorSolution() {
        return vectorSolution;
    }

    public static void printSolution(Vector vector) {
        if (numberOfSolutions == Solution.ONE_SOLUTION) {
            System.out.println(Solution.ONE_SOLUTION.getMessage());
            System.out.println(vector.toString());
        }
        System.out.println(numberOfSolutions.getMessage());
    }
}