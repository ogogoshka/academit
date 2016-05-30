package ru.academit.novikov.flowlayout;

public class TemperatureConvert {

    public static double celsiusToFahrenheit(double temperature) {
        return temperature * 9 / 5 + 32;
    }

    public static double celsiusToKelvin(double temperature) {
        return temperature + 273.15;
    }

    public static double kelvinToFahrenheit(double temperature) {
        temperature -= 273.15;
        return temperature * 9 / 5 + 32;
    }

    public static double kelvinToCelsius(double temperature) {
        return temperature - 273.15;
    }

    public static double fahrenheitToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double temperature) {
        return 273.15 + (temperature - 32) * 5 / 9;
    }
}