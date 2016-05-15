import ru.academit.novikov.range.Range;

public class MainRange {
    public static void main(String[] args) {

        Range range = new Range(1, 5);

        System.out.println(range.getFrom());
        System.out.println(range.lengthRange());
        System.out.println(range.isInside(7));

        Range r1 = new Range(7, 11);
        Range r2 = new Range(8, 9);
        Range r3 = new Range();

        r3.intersection(r1, r2);
        System.out.println(r3.getFrom() + " , " + r3.getTo());

        r3.association(r1, r2);
        System.out.println(r3.getFrom() + " , " + r3.getTo());
    }
}