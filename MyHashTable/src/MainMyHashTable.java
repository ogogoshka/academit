import ru.academit.novikov.myhashtable.HashTable;

import java.util.Arrays;

public class MainMyHashTable {
    public static void main(String[] args) {

        HashTable nullHashTable = new HashTable();

        HashTable hashTable = new HashTable(5);

        hashTable.add("ppp");
        hashTable.add("pop");
        hashTable.add("lol");
        hashTable.add("kok");
        hashTable.add("tot");
        hashTable.add("tok");
        hashTable.add("kot");

        for (String aHashTable : (Iterable<String>) hashTable) {
            System.out.println("hashTable = " + aHashTable);
        }

        System.out.println(Arrays.toString(hashTable.toArray(new String[11])));

    }
}