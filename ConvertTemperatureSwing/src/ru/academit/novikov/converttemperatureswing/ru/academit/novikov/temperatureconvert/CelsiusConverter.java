package ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert;

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
