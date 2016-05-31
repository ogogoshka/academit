package ru.academit.novikov.converttemperatureswing;

import ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert.CelsiusConverter;
import ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert.FahrenheitConverter;
import ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert.KelvinConverter;
import ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert.TemperatureConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TemperatureGUI {
    private static final String FAHRENHEIT_IN = "Фаренгейтах";
    private static final String CELSIUS_IN = "Цельсиях";
    private static final String KELVIN_IN = "Кельвинах";

    private static final String FAHRENHEIT_OUT = "Фаренгейты";
    private static final String CELSIUS_OUT = "Цельсии";
    private static final String KELVIN_OUT = "Кельвины";

    private JTextField entryField = new JTextField(30);
    private JTextField outField = new JTextField(30);

    private String[] elementsIn = new String[]{FAHRENHEIT_IN, CELSIUS_IN, KELVIN_IN};
    private JComboBox<String> comboBoxIn = new JComboBox<>(elementsIn);

    private String[] elementsOut = new String[]{FAHRENHEIT_OUT, CELSIUS_OUT, KELVIN_OUT};
    private JComboBox<String> comboBoxOut = new JComboBox<>(elementsOut);


    public TemperatureGUI() {
        JFrame frame = new JFrame("Тулза для перевода температур");
        frame.setSize(410, 270);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        frame.add(panel);

        JLabel labelTemperatureIn = new JLabel("Вы ввели Температуру в");
        panel.add(labelTemperatureIn);

        panel.add(comboBoxIn);
        panel.add(entryField);

        JButton convertButton = new JButton("Перевести");
        panel.add(convertButton);

        panel.add(outField);
        JLabel labelTemperatureOut = new JLabel("Перевести Температуру в");
        panel.add(labelTemperatureOut);

        panel.add(comboBoxOut);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (isStringOrNumber()) {
                    temperatureOut();
                } else {
                    JOptionPane.showMessageDialog(convertButton, "Вы ввели не число!!!", "Информация", JOptionPane.WARNING_MESSAGE);
                    entryField.setText(null);
                    outField.setText(null);
                }
            }
        });
    }

    private void temperatureOut() {
        Map<Integer, TemperatureConverter> convertMap = new HashMap<>();
        convertMap.put(0, new FahrenheitConverter());
        convertMap.put(1, new CelsiusConverter());
        convertMap.put(2, new KelvinConverter());

        String entryString = entryField.getText();
        if (comboBoxIn.getSelectedIndex() == comboBoxOut.getSelectedIndex()) {
            outField.setText(String.valueOf(entryString));
        } else {
            double anyCurrentTemperatureToCelsius = convertMap.get(comboBoxIn.getSelectedIndex()).currentToCelsius(Double.valueOf(entryString));
            double fromCelsiusToTargetTemperature = convertMap.get(comboBoxOut.getSelectedIndex()).currentFromCelsius(anyCurrentTemperatureToCelsius);
            outField.setText(String.valueOf(fromCelsiusToTargetTemperature));
        }
    }

    private boolean isStringOrNumber() {
        String entryString = entryField.getText();
        try {
            Double.parseDouble(entryString);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }
}