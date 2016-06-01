package ru.academit.novikov.myhashtable;

import java.util.ArrayList;

public class HashTable<E> {

    private static final int DEFAULT_CAPACITY = 20;
    private ArrayList<E>[] hashTable;

    public HashTable() {
        hashTable = new ArrayList[DEFAULT_CAPACITY];
    }

    public HashTable(int sizeOfTable) {
        if (sizeOfTable <= 0) {
            throw new IllegalArgumentException("Некорректный размер таблицы");
        }
        this.hashTable = new ArrayList[sizeOfTable];
    }

    public boolean isContainsElement(E element) {
        int index = hashCode(element);
        return hashTable[index].equals(element);
    }

    private int hashCode(E element) {
        return Math.abs(element.hashCode()) % hashTable.length;
    }

}