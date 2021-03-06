package ru.academit.novikov.converttemperatureswing.logic;

public class FahrenheitConverter implements TemperatureConverter {
    @Override
    public double currentToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    @Override
    public double currentFromCelsius(double temperature) {
        return temperature * 9 / 5 + 32;
    }
}
