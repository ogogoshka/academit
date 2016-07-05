package ru.academit.novikov.gauss;

import ru.academit.novikov.vector.Vector;

import static ru.academit.novikov.gauss.Solution.ONE_SOLUTION;

public class Result {

    private Vector vectorSolution;
    private Solution numberOfSolutions;

    public Result(Solution numberOfSolutions) {
        if (numberOfSolutions == Solution.ONE_SOLUTION) {
            throw new IllegalArgumentException();
        }
        this.numberOfSolutions = numberOfSolutions;
    }

    public Result(Vector vectorSolution) {
        this.vectorSolution = vectorSolution;
        this.numberOfSolutions = Solution.ONE_SOLUTION;
    }

    public Solution getNumberOfSolutions() {
        return numberOfSolutions;
    }

    public Vector getVectorSolution() {
        return vectorSolution;
    }

    public void printSolution2(Vector vector, Solution solution) {
        if (solution == ONE_SOLUTION) {
            System.out.println(solution.getMessage());
            System.out.println(vector.toString());
        } else {
            System.out.println(solution.getMessage());
        }
    }

    public static void printSolution(Vector vector, Solution solution) {
        if (solution == ONE_SOLUTION) {
            System.out.println(solution.getMessage());
            System.out.println(vector.toString());
        } else {
            System.out.println(solution.getMessage());
        }
    }
}