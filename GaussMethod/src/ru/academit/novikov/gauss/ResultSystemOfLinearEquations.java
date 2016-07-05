package ru.academit.novikov.gauss;

import ru.academit.novikov.vector.Vector;

import static ru.academit.novikov.gauss.NumberOfSolutions.ONE_SOLUTION;

public class ResultSystemOfLinearEquations {

    private Vector vectorSolution;
    private NumberOfSolutions numberOfSolutions;

    public ResultSystemOfLinearEquations(NumberOfSolutions numberOfSolutions) {
        if (this.numberOfSolutions == NumberOfSolutions.ONE_SOLUTION) {
            throw new IllegalArgumentException();
        }
        this.numberOfSolutions = numberOfSolutions;
    }

    public ResultSystemOfLinearEquations(Vector vectorSolution) {
        this.vectorSolution = vectorSolution;
        this.numberOfSolutions = NumberOfSolutions.ONE_SOLUTION;
    }

    public NumberOfSolutions getNumberOfSolutions() {
        return numberOfSolutions;
    }

    public Vector getVectorSolution() {
        return vectorSolution;
    }

    public void printSolution2(Vector vector, NumberOfSolutions solution) {
        if (solution == ONE_SOLUTION) {
            System.out.println(solution.getMessage());
            System.out.println(vector.toString());
        } else {
            System.out.println(solution.getMessage());
        }
    }

    public static void printSolution(Vector vector, NumberOfSolutions solution) {
        if (solution == ONE_SOLUTION) {
            System.out.println(solution.getMessage());
            System.out.println(vector.toString());
        } else {
            System.out.println(solution.getMessage());
        }
    }
}