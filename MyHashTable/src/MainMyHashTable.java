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


        HashTable ht1 = new HashTable(5);
        HashTable ht2 = new HashTable(5);
        //ht1.size();
        //String str2 = "pop";
        //int index = ht1.positionInMainArray(str2);

        //HashTable ht1[ 1]=new ArrayList<>();
        //ht1.add("lol");
        //System.out.println("ht1.size()=" + ht1.isEmpty());
        //System.out.println("ht1.size() = " + ht1.size());
        //System.out.println("ht1.isEmpty() = " + ht1.isEmpty());
        //System.out.println(ht1.add(str2));
        //System.out.println(ht1.positionInMainArray(str2));
        System.out.println(ht1.add("pop"));
        System.out.println(ht1.add("pop"));
        //ht1.add("pop");
        ht1.add("lol");
        ht1.add("kok");
        ht1.add("tot");
        ht1.add("tok");
        //System.out.println(ht1.positionInMainArray("pop"));
        System.out.println(ht1.positionInMainArray("lol"));
        System.out.println(ht1.positionInMainArray("kok"));
        System.out.println(ht1.positionInMainArray("tot"));
        System.out.println(ht1.positionInMainArray("tok"));

        //Object[] array2 = ht1.toArray(new Object[ht1.size()]);
        //for (int i = 0; i < 2; i++) {
        //System.out.println(array2[i]);
        //}
        System.out.println("ht1.size() = " + ht1.size());
        System.out.println("ht1.isEmpty() = " + ht1.isEmpty());

        System.out.println(ht2.add("elem1"));
        System.out.println("ht2.size() = " + ht2.size());
        //ht2.clear();
        System.out.println("ht2.size() = " + ht2.size());
        System.out.println(ht2.contains("elem1"));
        System.out.println(ht2.remove("elem1"));
        System.out.println(ht2.isEmpty());
        //System.out.println(ht2.addAll(ht1));

        //ht1.toArray();
        //System.out.println(ht1.remove("lol"));
        //Object[] array3 = new Object[ht1.size()];
        Object[] array2 = ht1.toArray(new Object[ht1.size()]);
        //Object[] array2 = new Object[ht1.size()];
        //ht1.toArray(array2);
        for (int i = 0; i < 2; i++) {
            //array3[i] = ht1.toArray();
            System.out.println(array2[i]);
            //array2[i].toString();
        }
        //for (Object value : array2) {
        //System.out.println("Number = " + value);
        //}

        //System.out.println(ht1.addAll(ht2));

        //ArrayList<String> newList = new ArrayList<>();

        //for ((Object)aHashTable : ht1) {
        //if (aHashTable != null) {
        //newList.addAll(aHashTable);
        //}
        //}
        //return newList.toArray();
        //return newList.toArray();

        ArrayList<String> newList = new ArrayList<>();

        for (int i = 0; i < ht1.size(); i++) {
            if (ht1.isEmpty()) {
                //for (int j = 0; j < ht1[i].size(); j++) {
                //}
            }
        }
        newList.toArray();

        //for (ArrayList<Type> aHashTable : ht1) {
        //if (aHashTable != null) {
        //for (String anAHashTable : aHashTable) {
        //newList.add(anAHashTable);
        //}
        //}
        //}
        //return newList.toArray();

    }
}