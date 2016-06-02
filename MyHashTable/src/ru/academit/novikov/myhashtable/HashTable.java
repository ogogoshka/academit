package ru.academit.novikov.myhashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HashTable<E> implements Collection<E> {

    private static final int DEFAULT_CAPACITY = 20;
    private ArrayList<E>[] hashTable;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int sizeOfTable) {
        if (sizeOfTable <= 0) {
            throw new IllegalArgumentException("Некорректный размер таблицы");
        }
        this.hashTable = new ArrayList[sizeOfTable];
    }

    private int hashCode(E element) {
        return Math.abs(element.hashCode()) % hashTable.length;
    }

    @Override
    public int size() {
        int numberOfElements = 0;
        for (ArrayList<E> aHashTable : hashTable) {
            numberOfElements += aHashTable.size();
        }
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return hashTable == null;
    }

    @Override
    public boolean contains(Object o) {
        int index = o.hashCode();
        int lastIndex = hashTable[index].lastIndexOf(o);
        return lastIndex != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        List<E> newList = new ArrayList<E>();
        for (ArrayList<E> aHashTable : hashTable) {
            for (E anAHashTable : aHashTable) {
                newList.add(anAHashTable);
            }
        }
        return newList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E element) {
        int index = hashCode(element);
        int lastIndex = hashTable[index].lastIndexOf(element);
        if (lastIndex == -1) {
            hashTable[index].add(element);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = o.hashCode();
        for (int i = 0; i < hashTable[index].size(); i++) {
            hashTable[index].remove(o);
        }
        int lastIndex = hashTable[index].lastIndexOf(o);
        return lastIndex == -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        //for (int i = 0; i < hashTable.length; i++) {
        //hashTable[i].addAll(0, Collection < ? > c);
        //hashTable[i].addAll(Collection<? extends E> c[i])
        //}

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int index = c.hashCode();
        hashTable[index].size();
        c.toArray();

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        c.size();


        return false;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (ArrayList<E> aHashTable : hashTable) {
            for (int j = 0; j < aHashTable.size(); j++) {
                aHashTable.remove(j);
            }
        }
    }
}