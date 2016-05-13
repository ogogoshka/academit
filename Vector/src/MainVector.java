import ru.academit.novikov.shapes.Vector;

public class MainVector {
    public static void main(String[] args) {


        Vector vector = new Vector(3);

        int razmer = vector.getSize();
        System.out.println(razmer);


        System.out.println(vector);
        vector.toString();
        System.out.println();


        int[] size = new int[5];
        String resultString = "";

        for (int n = 0; n < 4; n++) {
            size[n] = 0;
            if (n == 0) {
                resultString += size[n];
            } else {
                resultString += " , " + size[n];
            }
        }
        resultString = "{" + resultString + "}";
        System.out.println(resultString);


    }
}