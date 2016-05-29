package ru.academit.novikov.myhashtable;

import java.util.ArrayList;

public class HashTable<E> {

    private ArrayList[] hashTable;

    public HashTable(int sizeOfTable) {
        this.hashTable = new ArrayList[sizeOfTable];
    }

    private void add(E element) {
        if (element != null) {
            add(element);
        }
    }


    private int hashCode(E element) {
        //return element.hashCode() % hashTable.length;
        return 1;
    }


}