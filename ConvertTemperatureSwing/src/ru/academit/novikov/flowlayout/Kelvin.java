package ru.academit.novikov.flowlayout;

public class Kelvin implements Converter {
    @Override
    public double inCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double fromCelsius(double temperature) {
        return temperature + 273.15;
    }
}
