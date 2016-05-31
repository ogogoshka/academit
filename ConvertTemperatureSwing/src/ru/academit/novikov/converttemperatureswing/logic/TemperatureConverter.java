package ru.academit.novikov.converttemperatureswing.logic;

public interface TemperatureConverter {
    double currentToCelsius(double temperature);
    double currentFromCelsius(double temperature);
}