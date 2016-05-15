import ru.academit.novikov.range.Range;

import java.util.Arrays;

public class MainRange {
    public static void main(String[] args) {

        Range r1 = new Range(1, 5);
        Range r2 = new Range(4, 7);
        Range r3 = new Range();
        Range[] r4;

        r4 = r3.combination(r1, r2);
        System.out.println(Arrays.toString(r4));
    }
}