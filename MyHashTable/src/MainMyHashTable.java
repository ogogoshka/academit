import ru.academit.novikov.myhashtable.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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

        System.out.println("ADD");
        
        ht1.add("ppp");
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


        ArrayList<String> test = new ArrayList<>(4);
        ArrayList<String> test2 = new ArrayList<>(4);

        test.add("pop");
        test.add("lol");
        test.add("kot");
        test.add("tok");

        test2.add("pop");
        test2.add("lol");
        test2.add("kok");
        test2.add("wow");

        System.out.println(Arrays.toString(test.toArray()));
        System.out.println(Arrays.toString(test2.toArray()));

        System.out.println("test.retainAll(test2) = " + test.retainAll(test2));
        System.out.println("Arrays.toString(test.toArray()) = " + Arrays.toString(test.toArray()));

        System.out.println("test.retainAll(test2) = " + test.retainAll(test2));
        System.out.println("Arrays.toString(test.toArray()) = " + Arrays.toString(test.toArray()));

        Iterator iterator = ht1.iterator();

        System.out.println(Arrays.toString(ht1.toArray()));
        System.out.println("iterator.hasNext() = " + iterator.hasNext());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());

        System.out.println(Arrays.toString(ht1.toArray()));

        //while (iterator.hasNext()) {
        //System.out.println("iterator.next() = " + iterator.next());
        //}
        //System.out.println("ht1.contains(\"pop\") = " + ht1.contains("pop"));
        //System.out.println("ht1.contains(\"joj\") = " + ht1.contains("joj"));
        //System.out.println("ht1.contains(\"null\") = " + ht1.contains(null));

    }
}


/*
        ArrayList<String> namesTest = new ArrayList<String>();

        namesTest.add("one");
        namesTest.add("two");
        namesTest.add("three");

        String[] namesArray = namesTest.toArray(new String[namesTest.size()]);
        String[] namesArray2 = new String[3];
        //namesArray2 = namesTest.toArray();

        Object[] namesArray3 = new Object[1];
        namesArray3 = namesTest.toArray();

        System.out.println(Arrays.toString(namesArray));
        System.out.println(Arrays.toString(namesArray3));


        Object[] arrTest3 = ht1.toArray(new Object[ht1.size()]);
        System.out.println(Arrays.toString(arrTest3));

        Object[] arrTest4 = new Object[5];
        arrTest4 = ht1.toArray();

        System.out.println(Arrays.toString(arrTest4));
 */
