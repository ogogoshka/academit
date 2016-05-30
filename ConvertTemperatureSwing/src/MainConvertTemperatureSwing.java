import ru.academit.novikov.converttemperatureswing.TemperatureGUI;

import javax.swing.*;

public class MainConvertTemperatureSwing {

    public static void main(String[] args) {

        //System.out.println(new KelvinConverter().currentToCelsius(11));
        //new KelvinConverter().currentToCelsius(11);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureGUI();
            }
        });
    }
}