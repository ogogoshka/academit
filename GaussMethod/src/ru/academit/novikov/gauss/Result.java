package ru.academit.novikov.gauss;

import ru.academit.novikov.vector.Vector;

public class Result {

    private Vector vectorSolution;
    private Solution numberOfSolutions;

    public Result() {
    }

    public Solution getNumberOfSolutions() {
        return numberOfSolutions;
    }

    public Vector getVectorSolution() {
        return vectorSolution;
    }

    public static void printSolution(Vector vector, Solution solution) {
        if (solution == Solution.ONE_SOLUTION) {
            System.out.println(solution.getMessage());
            System.out.println(vector.toString());
        } else {
            System.out.println(solution.getMessage());
        }
    }
}