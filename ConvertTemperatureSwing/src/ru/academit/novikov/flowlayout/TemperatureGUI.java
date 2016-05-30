package ru.academit.novikov.flowlayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureGUI {
    private static final String FAHRENHEIT_IN = "Фаренгейтах";
    private static final String KELVIN_IN = "Кельвинах";
    private static final String CELSIUS_IN = "Цельсиях";
    private static final String FAHRENHEIT_OUT = "Фаренгейты";
    private static final String KELVIN_OUT = "Кельвины";
    private static final String CELSIUS_OUT = "Цельсии";

    private JTextField entryField = new JTextField(30);
    private JTextField outField = new JTextField(30);

    private String[] elementsIn = new String[]{FAHRENHEIT_OUT, CELSIUS_OUT, KELVIN_OUT};
    private JComboBox<String> comboBoxIn = new JComboBox<>(elementsIn);

    private String[] elementsOut = new String[]{FAHRENHEIT_IN, CELSIUS_IN, KELVIN_IN};
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

        String entryString = entryField.getText();
        Fahrenheit far = new Fahrenheit();
        Kelvin kel = new Kelvin();
        
        if (comboBoxIn.getSelectedIndex() == comboBoxOut.getSelectedIndex()) {
            outField.setText(String.valueOf(entryString));

        } else {
            if (comboBoxIn.getSelectedIndex() == 0) {
                if (comboBoxOut.getSelectedIndex() == 1) {
                    outField.setText(String.valueOf(far.inCelsius(Double.valueOf(entryString))));
                } else {
                    outField.setText(String.valueOf(kel.fromCelsius(far.inCelsius(Double.valueOf(entryString)))));
                }

            } else if (comboBoxIn.getSelectedIndex() == 1) {
                if (comboBoxOut.getSelectedIndex() == 0) {
                    outField.setText(String.valueOf(far.fromCelsius(Double.valueOf(entryString))));
                } else {
                    outField.setText(String.valueOf(kel.fromCelsius(Double.valueOf(entryString))));
                }

            } else {
                if (comboBoxOut.getSelectedIndex() == 0) {
                    outField.setText(String.valueOf(far.fromCelsius(kel.inCelsius(Double.valueOf(entryString)))));
                } else {
                    outField.setText(String.valueOf(kel.inCelsius(Double.valueOf(entryString))));
                }
            }
        }
    }




/*
    public int getOutIndex(int outIndex) {


        return 1;

    }
 */


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