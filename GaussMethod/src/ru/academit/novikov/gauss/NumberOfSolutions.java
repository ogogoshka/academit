package ru.academit.novikov.gauss;

public enum NumberOfSolutions {
    NO_SOLUTION("СЛАУ не имеет решений"),
    ONE_SOLUTION("СЛАУ имеет одно решение"),
    MANY_SOLUTIONS("СЛАУ имеет бесконечное множество решений");

    private String message;

    NumberOfSolutions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}