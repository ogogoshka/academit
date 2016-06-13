import ru.academit.novikov.myhashtable.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class MainMyHashTable {
    public static void main(String[] args) {

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

        System.out.println(Arrays.toString(ht1.toArray()));

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
        System.out.println("iterator.hasNext() = " + iterator.hasNext());

        System.out.println(Arrays.toString(ht1.toArray()));

        //while (iterator.hasNext()) {
        //System.out.println("iterator.next() = " + iterator.next());
        //}
        //System.out.println("ht1.contains(\"pop\") = " + ht1.contains("pop"));
        //System.out.println("ht1.contains(\"joj\") = " + ht1.contains("joj"));
        //System.out.println("ht1.contains(\"null\") = " + ht1.contains(null));

        ListIterator<String> listIts = test.listIterator(test.size());
        System.out.println(listIts.nextIndex());

        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.hasNext() = " + iterator.hasNext());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.hasNext() = " + iterator.hasNext());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.hasNext() = " + iterator.hasNext());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.hasNext() = " + iterator.hasNext());

        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.hasNext() = " + iterator.hasNext());

        //Object[] arrr = new Object[11];

        //ht1.toArray(new Object[11]);

        System.out.println(Arrays.toString(ht1.toArray(new String[7])));

        HashTable<Integer> table3 = new HashTable<>();
        table3.add(3);
        table3.add(4);

        Integer[] result = table3.toArray(new Integer[5]);

        System.out.println(Arrays.toString(result));
    }
}