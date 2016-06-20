package ru.academit.novikov.gauss;

public enum EnumSolves {
    NO_SOLVES("СЛАУ не имеет решений"),
    ONE_SOLVE("СЛАУ имеет одно решение"),
    MANY_SOLVES("СЛАУ имеет бесконечное множество решений");

    private String message;

    EnumSolves(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}