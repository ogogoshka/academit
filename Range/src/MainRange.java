import ru.academit.novikov.range.Range;

import java.util.Arrays;

public class MainRange {
    public static void main(String[] args) {
        Range r1 = new Range(5, 10);
        Range range = new Range(1, 6);
        Range r3 = new Range();

        r1.isInside(0);

        r1.isIntersection(range);
        r1.lengthRange();
        r1.getFrom();
        r1.getTo();

        r3.setFrom(1);
        r3.setTo(11);

        r1.intersection(range);
        //System.out.println(r1.intersection(range).toString());

        r1.union(range);
        //System.out.println(Arrays.toString(r1.union(range)));

        r1.difference(range);
        System.out.println(Arrays.toString(r1.difference(range)));
    }
}