import ru.academit.novikov.range.Range;

import static ru.academit.novikov.range.Range.association2;
import static ru.academit.novikov.range.Range.difference2;

public class MainRange {
    public static void main(String[] args) {

        Range range = new Range(1, 5);

        System.out.println(range.getFrom());
        System.out.println(range.lengthRange());
        System.out.println(range.isInside(7));

        Range r1 = new Range(5, 15);
        Range r2 = new Range(1, 5);
        Range r3 = new Range();

        r3.intersection(r1, r2);
        System.out.println(r3.getFrom() + " , " + r3.getTo());

        r3.association(r1, r2);
        System.out.println(r3.getFrom() + " , " + r3.getTo());

        r3.setFrom(5);
        r3.setTo(11);
        System.out.println(r3.getFrom() + " , " + r3.getTo());

        association2(r1, r2);
        difference2(r1, r2);

    }
}