package ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert;

public interface TemperatureConverter {
    double currentToCelsius(double temperature);
    double currentFromCelsius(double temperature);
}