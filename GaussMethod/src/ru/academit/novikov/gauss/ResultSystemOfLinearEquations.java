package ru.academit.novikov.gauss;

import ru.academit.novikov.vector.Vector;

import static ru.academit.novikov.gauss.NumberOfSolutions.ONE_SOLUTION;

public class ResultSystemOfLinearEquations {

    private Vector vectorSolution;
    private NumberOfSolutions numberOfSolutions;

    public ResultSystemOfLinearEquations(NumberOfSolutions numberOfSolutions) {
        if (this.numberOfSolutions == NumberOfSolutions.ONE_SOLUTION) {
            throw new IllegalArgumentException("В этом конструкторе нельзя использовать значение ONE_SOLUTION, используйте конструктор, принимающий Vector");
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

    public void printSolution() {
        if (numberOfSolutions == ONE_SOLUTION) {
            System.out.println(numberOfSolutions.getMessage());
            System.out.println(vectorSolution.toString());
        } else {
            System.out.println(numberOfSolutions.getMessage());
        }
    }
}