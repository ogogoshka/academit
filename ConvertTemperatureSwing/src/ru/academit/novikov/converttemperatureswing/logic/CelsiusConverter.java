package ru.academit.novikov.converttemperatureswing.logic;

public class CelsiusConverter implements TemperatureConverter {
    @Override
    public double currentToCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double currentFromCelsius(double temperature) {
        return temperature;
    }
}
