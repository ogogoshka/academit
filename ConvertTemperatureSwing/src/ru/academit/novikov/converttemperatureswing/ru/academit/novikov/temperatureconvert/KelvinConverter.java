package ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert;

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
