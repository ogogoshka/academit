import ru.academit.novikov.range.Range;

public class MainRange {
    public static void main(String[] args) {

        Range range = new Range(1, 5);

        System.out.println(range.getFrom());
        System.out.println(range.lengthRange());
        System.out.println(range.isInside(7));
    }
}