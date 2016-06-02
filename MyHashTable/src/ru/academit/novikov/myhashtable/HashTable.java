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
        for (ArrayList<E> aHashTable : hashTable) {
            if (!aHashTable.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        int index = o.hashCode();
        return hashTable[index].contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        /*
        for (ArrayList<E> aHashTable : hashTable) {
            aHashTable.iterator();
        }
         */

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
        List<E> newList = new ArrayList<E>();
        for (ArrayList<E> aHashTable : hashTable) {
            for (E anAHashTable : aHashTable) {
                newList.add(anAHashTable);
            }
        }
        return newList.toArray(a);
    }

    @Override
    public boolean add(E element) {
        int index = hashCode(element);
        hashTable[index].lastIndexOf(element);
        if (hashTable[index].contains(element)) {
            return false;
        } else {
            hashTable[index].add(element);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int index = o.hashCode();
        return hashTable[index].remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (ArrayList<E> aHashTable : hashTable) {
            if (!aHashTable.containsAll(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (int i = 0; i < hashTable.length; i++) {
            if (!hashTable[i].addAll(c)) {
                return false;
            }
            hashTable[i].addAll(c);
        }
        return true;
    }
/*
        if (this.containsAll(c)) {
            return false;
        } else {
            //hashTable.
        }


        for (int i = 0; i < hashTable.length; i++) {
            //hashCode(c.[i]);
            hashTable[i].addAll(c);
            hashTable[i].containsAll(c);
        }


        //int index = c.hashCode();
        //hashTable[index].size();
        //c.toArray();

        //this.addAll(c);
 */


    @Override
    public boolean removeAll(Collection<?> c) {
        for (ArrayList<E> aHashTable : hashTable) {
            if (!aHashTable.removeAll(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (ArrayList<E> aHashTable : hashTable) {
            if (!aHashTable.retainAll(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (ArrayList<E> aHashTable : hashTable) {
            aHashTable.clear();
        }
    }

}