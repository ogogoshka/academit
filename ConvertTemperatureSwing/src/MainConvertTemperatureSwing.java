import ru.academit.novikov.converttemperatureswing.TemperatureGUI;

import javax.swing.*;

public class MainConvertTemperatureSwing {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureGUI();
            }
        });
    }
}