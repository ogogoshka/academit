import ru.academit.novikov.myhashtable.HashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMyHashTable {
    public static void main(String[] args) {

        //String str1 = "Hello";
        HashTable table = new HashTable(5);
        HashTable table2 = new HashTable();
        System.out.println();

        ArrayList<Integer>[] a1 = new ArrayList[3];
        int st1 = a1.length;
        System.out.println(st1);

        a1[0] = new ArrayList<>();

        a1[0].add(0, 100);
        a1[0].add(1, 200);
        a1[0].add(2, 300);

        Integer[] array = a1[0].toArray(new Integer[a1[0].size()]);
        for (int i = 0; i < 3; i++) {
            System.out.println(array[i]);
        }

        HashTable ht1 = new HashTable(5);
        HashTable ht2 = new HashTable(5);

        ht1.add("pop");
        ht1.add("lol");
        ht1.add("kok");
        ht1.add("tot");
        ht1.add("tok");

        System.out.println("ht1.size() = " + ht1.size());
        System.out.println("ht1.isEmpty() = " + ht1.isEmpty());

        System.out.println(ht2.add("elem1"));
        System.out.println("ht2.size() = " + ht2.size());

        System.out.println("ht2.size() = " + ht2.size());
        System.out.println(ht2.contains("elem1"));
        System.out.println(ht2.remove("elem1"));
        System.out.println(ht2.isEmpty());

        Object[] array2 = ht1.toArray(new Object[ht1.size()]);

        System.out.println(Arrays.toString(ht1.toArray()));

        Object[] array7 = ht1.toArray();

        Object[] array5;
        array5 = ht1.toArray();
        for (int i = 0; i < ht1.size(); i++) {
            System.out.println(array5[i]);
        }


    }
}