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

    public int hashCode(E element) {
        return Math.abs(element.hashCode()) % hashTable.length;
    }

    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException();
        } else {
            int index = hashCode(element);
            if (hashTable[index] == null) {
                hashTable[index] = new ArrayList<>();
                hashTable[index].add(element);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        } else {
            int index = o.hashCode();
            if (hashTable[index] == null) {
                return false;
            } else {
                hashTable[index].remove(o);
                return true;
            }
        }
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
            if (aHashTable.size() != 0) {
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
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }
    /*
            for (int i = 0; i < hashTable.length; i++) {
            if (!hashTable[i].addAll(c)) {
                return false;
            }
            hashTable[i].addAll(c);
        }
        return true;
    }
     */


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