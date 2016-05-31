package ru.academit.novikov.converttemperatureswing.logic;

public class KelvinConverter implements TemperatureConverter {
    @Override
    public double currentToCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double currentFromCelsius(double temperature) {
        return temperature + 273.15;
    }
}
