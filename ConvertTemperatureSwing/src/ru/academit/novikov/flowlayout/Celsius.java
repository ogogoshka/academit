package ru.academit.novikov.flowlayout;

public class Celsius implements Converter {
    @Override
    public double inCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double fromCelsius(double temperature) {
        return temperature;
    }
}
