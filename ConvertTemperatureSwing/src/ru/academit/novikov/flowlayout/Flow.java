package ru.academit.novikov.flowlayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Flow extends Frame {
    private TextField text1 = new TextField(50);
    private TextField text2 = new TextField(50);

    public Flow(String s) {
        super(s);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        Choice temperatureIn = new Choice();
        temperatureIn.add("Фаренгейтах");
        temperatureIn.add("Цельсиях");
        temperatureIn.add("Кельвинах");

        Choice temperatureOut = new Choice();
        temperatureOut.add("Фаренгейты");
        temperatureOut.add("Цельсии");
        temperatureOut.add("Кельвины");

        Button convert = new Button("Перевести");

        add(new Label("Вы ввели Температуру в"));
        add(temperatureIn);
        add(text1);

        add(convert);

        add(text2);
        text2.setEditable(false);
        add(new Label("Перевести Температуру в"));
        add(temperatureOut);

        setSize(410, 270);
        setVisible(true);
        setResizable(false);

        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                String str1 = text1.getText();
                double temperature;

                try {
                    temperature = Double.parseDouble(str1);
                } catch (NumberFormatException exception) {
                    throw new IllegalArgumentException("Температура должна быть числом!!!");
                }

                if (temperatureIn.getSelectedItem().equals("Фаренгейтах")) {
                    Double inF = Double.valueOf(str1);
                    if (temperatureOut.getSelectedItem().equals("Фаренгейты")) {
                        text2.setText(String.valueOf(inF));
                        text2.setText(String.valueOf(inF));
                    } else if (temperatureOut.getSelectedItem().equals("Цельсии")) {
                        inF = (inF - 32) * 5 / 9;
                        text2.setText(String.valueOf(inF));
                        text2.setText(String.valueOf(inF));
                    } else {
                        inF = 273.15 + (inF - 32) * 5 / 9;
                        text2.setText(String.valueOf(inF));
                        text2.setText(String.valueOf(inF));
                    }

                } else if (temperatureIn.getSelectedItem().equals("Цельсиях")) {
                    Double inC = Double.valueOf(str1);
                    if (temperatureOut.getSelectedItem().equals("Фаренгейты")) {
                        inC = inC * 9 / 5 + 32;
                        text2.setText(String.valueOf(inC));
                    } else if (temperatureOut.getSelectedItem().equals("Цельсии")) {
                        text2.setText(String.valueOf(inC));
                    } else {
                        inC = inC + 273.15;
                        text2.setText(String.valueOf(inC));
                    }

                } else {
                    Double inK = Double.valueOf(str1);
                    if (temperatureOut.getSelectedItem().equals("Фаренгейты")) {
                        inK = inK - 273.15;
                        inK = inK * 9 / 5 + 32;
                        text2.setText(String.valueOf(inK));
                    } else if (temperatureOut.getSelectedItem().equals("Цельсии")) {
                        inK = inK - 273.15;
                        text2.setText(String.valueOf(inK));
                    } else {
                        text2.setText(String.valueOf(inK));
                    }
                }
            }
        });
    }
}

//из шкалы Фаренгейта в шкалу Цельсия
// нужно от исходного числа отнять 32 и умножить результат на 5/9.

//из шкалы Цельсия в шкалу Фаренгейта
// нужно умножить исходное число на 9/5 и прибавить 32.