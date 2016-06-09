package ru.academit.novikov.myhashtable;

import java.util.*;

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

    private int positionInMainArray(Object o) {
        return Math.abs(o.hashCode()) % hashTable.length;
    }

    @Override
    public int size() {
        int numberOfElements = 0;
        for (ArrayList<E> aHashTable : hashTable) {
            if (aHashTable != null) {
                numberOfElements += aHashTable.size();
            }
        }
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        int index = positionInMainArray(element);
        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
            hashTable[index].add(element);
            return true;
        } else {
            if (hashTable[index].contains(element)) {
                return false;
            } else {
                hashTable[index].add(element);
                return true;
            }
        }
    }

    @Override
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        } else {
            int index = positionInMainArray(obj);
            return hashTable[index] != null && hashTable[index].remove(obj);
        }
    }

    @Override
    public boolean contains(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        int index = positionInMainArray(obj);
        return hashTable[index] != null && hashTable[index].contains(obj);
    }

    @Override
    public void clear() {
        for (ArrayList<E> aHashTable : hashTable) {
            if (aHashTable != null) {
                aHashTable.clear();
            }
        }
    }

    @Override
    public Object[] toArray() {
        List<E> newList = new ArrayList<>();
        for (ArrayList<E> aHashTable : hashTable) {
            if (aHashTable != null) {
                newList.addAll(aHashTable);
            }
        }
        return newList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (this.hashTable == null) {
            throw new NullPointerException();
        }
        if (a.length < this.size()) {
            return (T[]) Arrays.copyOf(this.toArray(), this.size(), a.getClass());
        }
        int k = 0;
        for (ArrayList<E> currentBucket : hashTable) {
            for (E currentElement : currentBucket) {
                a[k] = (T) currentElement;
                k++;
            }
        }
        a[this.size()] = null;
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        List<E> newList = new ArrayList<>();
        for (ArrayList<E> aHashTable : hashTable) {
            if (aHashTable != null) {
                newList.addAll(aHashTable);
            }
        }
        return newList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int count = 0;
        for (E currentElement : c) {
            if (this.add(currentElement)) {
                count++;
            }
        }
        return count > 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int count = 0;
        for (Object currentElement : c) {
            if (this.remove(currentElement)) {
                count++;
            }
        }
        return count > 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int count = 0;
        for (Object currentElement : c) {
            int index = positionInMainArray(currentElement);
            if (hashTable[index].retainAll(c)) {
                count++;
            }
        }
        return count > 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyHashTablesIterator();
    }

    private class MyHashTablesIterator implements Iterator<E> {

        private int currentIndex;
        private int currentBucket;

        @Override
        public boolean hasNext() {
            int lastPosition = hashTable[currentBucket].size();
            int lastBucket = hashTable.length - 1;
            return currentBucket != lastBucket || currentIndex != lastPosition;
        }

        @Override
        public E next() {
            int lastPosition = hashTable[currentBucket].size();
            int lastBucket = hashTable.length - 1;

            if (!hasNext()) {
                throw new NoSuchElementException("конец хеш-таблицы");
            }

            if (currentBucket < lastBucket && currentIndex == lastPosition) {
                currentBucket++;
                currentIndex = 0;
                if (hashTable[currentBucket] == null) {
                    return hashTable[currentBucket++].get(currentIndex);
                } else {
                    return hashTable[currentBucket++].get(currentIndex);
                }
            } else {
                return hashTable[currentBucket].get(currentIndex++);
            }
        }
    }
}