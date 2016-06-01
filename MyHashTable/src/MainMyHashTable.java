import ru.academit.novikov.myhashtable.HashTable;

import java.util.ArrayList;

public class MainMyHashTable {
    public static void main(String[] args) {

        //String str1 = "Hello";
        HashTable table = new HashTable(5);
        HashTable table2 = new HashTable();
        System.out.println();

        ArrayList<Integer>[] a1 = new ArrayList[3];
        int st1 = a1.length;
        System.out.println(st1);
        //a1[1].add(1, "1lalala");
        a1[0] = new ArrayList<>();
        //a1[1].set(0, 100);
        //a1[1].set(1, 200);


        a1[0].add(0, 100);
        a1[0].add(1, 200);
        a1[0].add(2, 300);
        //a1[1].set(1, "opopop");


        Integer[] array = a1[0].toArray(new Integer[a1[0].size()]);
        for (int i = 0; i < 3; i++) {
            System.out.println(array[i]);
        }
        //System.out.println(a1[1].toString());
        //System.out.println(a1[1].get(1));

    }
}