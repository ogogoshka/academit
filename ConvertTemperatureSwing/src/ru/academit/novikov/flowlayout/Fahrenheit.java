package ru.academit.novikov.flowlayout;

public class Fahrenheit implements Converter {
    @Override
    public double inCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    @Override
    public double fromCelsius(double temperature) {
        return temperature * 9 / 5 + 32;
    }
}
