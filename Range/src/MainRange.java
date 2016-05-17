import ru.academit.novikov.range.Range;

public class MainRange {
    public static void main(String[] args) {
        Range r1 = new Range(22, 29);
        Range r2 = new Range(20, 29);
        Range r3 = new Range();

        r1.lengthRange();
        r1.getFrom();
        r1.getTo();

        r3.setFrom(1);
        r3.setTo(11);

        //System.out.println(r1.isIntersection(r2));

        r1.intersection(r2);
        System.out.println(r1.intersection(r2).toString());

        //r1.difference(r2);
        //System.out.println(Arrays.toString(r1.difference(r2)));

        //r1.union(r2);
        //System.out.println(Arrays.toString(r1.union(r2)));
    }
}