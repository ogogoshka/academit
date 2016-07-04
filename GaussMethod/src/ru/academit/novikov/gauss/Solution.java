package ru.academit.novikov.gauss;

public enum Solution {
    NO_SOLVES("СЛАУ не имеет решений"),
    ONE_SOLVE("СЛАУ имеет одно решение"),
    MANY_SOLVES("СЛАУ имеет бесконечное множество решений");

    private String message;

    Solution(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}