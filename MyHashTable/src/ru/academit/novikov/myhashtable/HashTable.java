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
        //for (int i = 0; i < hashTable.length; i++) {
        //hashTable[i] = new ArrayList<>();
        //}
    }

    private int hashCode(E element) {
        return Math.abs(element.hashCode()) % hashTable.length;
    }

    public void add(E element) {
        int index = hashCode(element);
        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<E>();
            hashTable[index].add(element);
        } else {
            for (int i = 0; i < hashTable[index].size(); i++) {
                if (!(hashTable[index].get(i).equals(element)) && i == hashTable[index].size()) {
                    hashTable[index].add(hashTable[index].size(), element);
                }
            }
        }
    }

    public boolean isContainsElement(E element) {
        int index = hashCode(element);
        if (hashTable[index] == null) {
            return false;
        }
        for (int i = 0; i < hashTable[index].size(); i++) {
            if (hashTable[index].get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void remove(E element) {
        int index = hashCode(element);
        if (hashTable[index] == null) {
            return;
        }
        for (int i = 0; i < hashTable[index].size(); i++) {
            if (hashTable[index].get(i).equals(element)) {
                hashTable[index].remove(i);
            }
        }
    }

    public int getNumberOfElements() {
        int numberOfElements = 0;
        for (ArrayList<E> aHashTable : hashTable) {
            numberOfElements += aHashTable.size();
        }
        return numberOfElements;
    }


}