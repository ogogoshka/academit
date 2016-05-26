import ru.academit.novikov.flowlayout.Flow;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainConvertTemperatureSwing {

    public static void main(String[] args) {
        Frame frame = new Flow("Тулза для перевода температур");
        Panel panel = new Panel();
        frame.add(panel);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
    }
}