package ru.academit.novikov.flowlayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ru.academit.novikov.flowlayout.TemperatureConvert.*;

public class TemperatureGUI {

    private static final String FAHRENHEIT_IN = "Фаренгейтах";
    private static final String KELVIN_IN = "Кельвинах";
    private static final String CELSIUS_IN = "Цельсиях";

    private static final String FAHRENHEIT_OUT = "Фаренгейты";
    private static final String KELVIN_OUT = "Кельвины";
    private static final String CELSIUS_OUT = "Цельсии";

    private JFrame frame = new JFrame("Тулза для перевода температур");
    private JTextField entryField = new JTextField(30);
    private JTextField outField = new JTextField(30);
    private JButton convertButton = new JButton("Перевести");

    private String[] elementsIn = new String[]{FAHRENHEIT_OUT, CELSIUS_OUT, KELVIN_OUT};
    private JComboBox comboBoxIn = new JComboBox(elementsIn);

    private String[] elementsOut = new String[]{FAHRENHEIT_IN, CELSIUS_IN, KELVIN_IN};
    private JComboBox comboBoxOut = new JComboBox(elementsOut);

    private JLabel labelTemperatureIn = new JLabel("Вы ввели Температуру в");
    private JLabel labelTemperatureOut = new JLabel("Перевести Температуру в");

    public TemperatureGUI() {
        frame.setSize(410, 270);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        frame.add(panel);

        panel.add(labelTemperatureIn);

        panel.add(comboBoxIn);


        panel.add(entryField);

        panel.add(convertButton);

        panel.add(outField);

        panel.add(labelTemperatureOut);
        panel.add(comboBoxOut);

        convertButton.addActionListener(new ConvertActionListener());
    }

    private class ConvertActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            temperatureOut();
        }
    }


    private void temperatureOut() {
        String entryString = entryField.getText();

        try {
            double temperature = Double.parseDouble(entryString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Температура должна быть числом!!!");
        }

        if (choiceTemperatureIn.getSelectedItem().equals(FAHRENHEIT_IN)) {
            Double inF = Double.valueOf(entryString);
            if (choiceTemperatureOut.getSelectedItem().equals(FAHRENHEIT_OUT)) {
                outField.setText(String.valueOf(inF));
            } else if (choiceTemperatureOut.getSelectedItem().equals(CELSIUS_OUT)) {
                outField.setText(String.valueOf(fahrenheitToCelsius(inF)));
            } else {
                outField.setText(String.valueOf(fahrenheitToKelvin(inF)));
            }

        } else if (choiceTemperatureIn.getSelectedItem().equals(CELSIUS_IN)) {
            Double inC = Double.valueOf(entryString);
            if (choiceTemperatureOut.getSelectedItem().equals(FAHRENHEIT_OUT)) {
                outField.setText(String.valueOf(celsiusToFahrenheit(inC)));
            } else if (choiceTemperatureOut.getSelectedItem().equals(CELSIUS_OUT)) {
                outField.setText(String.valueOf(inC));
            } else {
                outField.setText(String.valueOf(celsiusToKelvin(inC)));
            }

        } else {
            Double inK = Double.valueOf(entryString);
            if (choiceTemperatureOut.getSelectedItem().equals(FAHRENHEIT_OUT)) {
                outField.setText(String.valueOf(kelvinToFahrenheit(inK)));
            } else if (choiceTemperatureOut.getSelectedItem().equals(CELSIUS_OUT)) {
                outField.setText(String.valueOf(kelvinToCelsius(inK)));
            } else {
                outField.setText(String.valueOf(inK));
            }
        }
    }
}