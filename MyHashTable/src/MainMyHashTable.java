import ru.academit.novikov.myhashtable.HashTable;

import java.util.Arrays;

public class MainMyHashTable {
    public static void main(String[] args) {

        HashTable nullHashTable = new HashTable();

        HashTable hashTable = new HashTable(5);

        hashTable.add("mom");
        hashTable.add("ppp");
        hashTable.add("pop");
        hashTable.add("lol");
        hashTable.add("kok");
        hashTable.add("tot");
        hashTable.add("tok");
        hashTable.add("kot");
        hashTable.add("sos");
        //pop, kok, ppp, sos, lol, tot, mom, tok, kot
        //pop, kok, ppp, lol, tot, tok, kot
        //System.out.println(hashTable.positionInMainArray("pop"));
        //System.out.println(hashTable.positionInMainArray("kok"));
        //System.out.println(hashTable.positionInMainArray("ppp"));
        //System.out.println(hashTable.positionInMainArray("sos"));
        //System.out.println(hashTable.positionInMainArray("lol"));
        //System.out.println(hashTable.positionInMainArray("tot"));
        //System.out.println(hashTable.positionInMainArray("mom"));
        //System.out.println(hashTable.positionInMainArray("tok"));
        //System.out.println(hashTable.positionInMainArray("kot"));


        System.out.println(Arrays.toString(hashTable.toArray(new String[15])));
        //System.out.println("hashTable.getLength() = " + hashTable.getLength());

        for (String aHashTable : (Iterable<String>) hashTable) {
            System.out.println("hashTable = " + aHashTable);
        }


    }
}