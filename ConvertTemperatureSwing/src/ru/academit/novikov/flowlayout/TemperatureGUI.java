package ru.academit.novikov.flowlayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ru.academit.novikov.flowlayout.TemperatureConvert.*;

public class TemperatureGUI {
    private JFrame jFrame = new JFrame("Тулза для перевода температур");
    private JTextField entryField = new JTextField(30);
    private JTextField outField = new JTextField(30);
    private JButton convertButton = new JButton("Перевести");
    private Choice choiceTemperatureIn = new Choice();
    private Choice choiceTemperatureOut = new Choice();
    private JLabel labelTemperatureIn = new JLabel("Вы ввели Температуру в");
    private JLabel labelTemperatureOut = new JLabel("Перевести Температуру в");

    public TemperatureGUI() {
        jFrame.setSize(410, 270);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        jFrame.add(jPanel);

        jPanel.add(labelTemperatureIn);
        jPanel.add(choiceTemperatureIn);
        choiceTemperatureIn.add("Фаренгейтах");
        choiceTemperatureIn.add("Цельсиях");
        choiceTemperatureIn.add("Кельвинах");

        jPanel.add(entryField);

        jPanel.add(convertButton);

        jPanel.add(outField);

        jPanel.add(labelTemperatureOut);
        jPanel.add(choiceTemperatureOut);
        choiceTemperatureOut.add("Фаренгейты");
        choiceTemperatureOut.add("Цельсии");
        choiceTemperatureOut.add("Кельвины");

        convertButton.addActionListener(new ConvertActionListener());
    }

    private class ConvertActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
}