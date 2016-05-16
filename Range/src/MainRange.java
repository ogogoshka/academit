import ru.academit.novikov.range.Range;

import java.util.Arrays;

public class MainRange {
    public static void main(String[] args) {

        Range r1 = new Range(7, 17);
        Range r2 = new Range(1, 11);
        Range r3 = new Range();
        Range[] r4;
        Range[] r5;

        r1.intersection(r2);
        System.out.println(r1.intersection(r2).toString());

        r1.difference(r2);
        System.out.println(Arrays.toString(r1.difference(r2)));

    }
}