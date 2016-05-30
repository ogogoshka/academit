import ru.academit.novikov.converttemperatureswing.TemperatureGUI;
import ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert.CelsiusConverter;
import ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert.FahrenheitConverter;
import ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert.KelvinConverter;
import ru.academit.novikov.converttemperatureswing.ru.academit.novikov.temperatureconvert.TemperatureConverter;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MainConvertTemperatureSwing {

    public static void main(String[] args) {

        //System.out.println(new KelvinConverter().currentToCelsius(11));
        //new KelvinConverter().currentToCelsius(11);

        Map<Integer, TemperatureConverter> convertMap = new HashMap<>();

        convertMap.put(0, new FahrenheitConverter());
        convertMap.put(1, new CelsiusConverter());
        convertMap.put(2, new KelvinConverter());

        //convertMap.get(0);

        //System.out.println(convertMap.get(0).currentToCelsius(100));

        System.out.println(convertMap.get(2).currentFromCelsius(convertMap.get(0).currentToCelsius(100)));
        //convertMap.get(2).currentFromCelsius(convertMap.get(0).currentToCelsius(100));


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureGUI();
            }
        });
    }
}