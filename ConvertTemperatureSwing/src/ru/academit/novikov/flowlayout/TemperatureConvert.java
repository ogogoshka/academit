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
/*
    public void temperatureOut() {
        String entryString = entryField.getText();

        try {
            double temperature = Double.parseDouble(entryString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Температура должна быть числом!!!");
        }

        if (choiceTemperatureIn.getSelectedItem().equals("Фаренгейтах")) {
            Double inF = Double.valueOf(entryString);
            if (choiceTemperatureOut.getSelectedItem().equals("Фаренгейты")) {
                outField.setText(String.valueOf(inF));
            } else if (choiceTemperatureOut.getSelectedItem().equals("Цельсии")) {
                outField.setText(String.valueOf(fahrenheitToCelsius(inF)));
            } else {
                outField.setText(String.valueOf(fahrenheitToKelvin(inF)));
            }

        } else if (choiceTemperatureIn.getSelectedItem().equals("Цельсиях")) {
            Double inC = Double.valueOf(entryString);
            if (choiceTemperatureOut.getSelectedItem().equals("Фаренгейты")) {
                outField.setText(String.valueOf(celsiusToFahrenheit(inC)));
            } else if (choiceTemperatureOut.getSelectedItem().equals("Цельсии")) {
                outField.setText(String.valueOf(inC));
            } else {
                outField.setText(String.valueOf(celsiusToKelvin(inC)));
            }

        } else {
            Double inK = Double.valueOf(entryString);
            if (choiceTemperatureOut.getSelectedItem().equals("Фаренгейты")) {
                outField.setText(String.valueOf(kelvinToFahrenheit(inK)));
            } else if (choiceTemperatureOut.getSelectedItem().equals("Цельсии")) {
                outField.setText(String.valueOf(kelvinToCelsius(inK)));
            } else {
                outField.setText(String.valueOf(inK));
            }
        }
    }
 */


}