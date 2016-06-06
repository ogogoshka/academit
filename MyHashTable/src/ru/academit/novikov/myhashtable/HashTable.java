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

    public int positionInMainArray(Object o) {
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
        } else {
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
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        } else {
            int index = positionInMainArray(o);
            if (hashTable[index] == null) {
                return false;
            } else {
                hashTable[index].remove(o);
                return true;
            }
        }
    }

    @Override
    public boolean contains(Object obj) {
        int index = positionInMainArray(obj);
        if (hashTable[index].size() == 0) {
            return false;
        } else {
            for (int i = 0; i < hashTable[index].size(); i++) {
                if (hashTable[index].get(i).equals(obj)) {
                    return true;
                }
            }
        }
        return false;
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
    public Iterator<E> iterator() {
        //E e = new E();
        //int index = positionInMainArray(e);
        //int length = hashTable.length;
        //hashTable[index].size();
        //hashTable[index].iterator();
        return new MyIterHash();
    }

    private class MyIterHash implements Iterator<E> {

        private int currentIndex;
        private int currentBucket;

        @Override
        public boolean hasNext() {
            return currentIndex < HashTable.this.size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            //E el = hashTable[currentBucket].get(currentIndex);
            //currentIndex++;
            return null;
        }
    }

 /*
        Iterator<E> it = new Iterator<E>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                //return currentIndex < currentSize && arrayList[currentIndex] != null;
                return true;
            }
            //@Override
            //public E next() {
                //return arrayList[currentIndex++];
                //return hashTable;
            //}
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        return it;
 */

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
        Object[] thisArray = this.toArray();
        T[] result = Arrays.copyOf(a, thisArray.length);
        for (int i = 0; i < thisArray.length; i++) {
            result[i] = (T) thisArray[i];
        }
        return result;
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
        Object[] cArray = c.toArray();
        int count = 0;
        for (int i = 0; i < cArray.length; i++) {
            int bucket = positionInMainArray(cArray[i]);
            if (hashTable[bucket].add((E) cArray[i])) {
                count++;
            }
            if (count == cArray.length) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] cArray = c.toArray();
        int count = 0;
        for (int i = 0; i < cArray.length; i++) {
            int bucket = positionInMainArray(cArray[i]);
            for (int j = 0; j < hashTable[bucket].size(); j++) {
                if (hashTable[bucket].get(j).equals(cArray[i])) {
                    hashTable[bucket].remove(j);
                    count++;
                }
            }
            if (count == cArray.length) {
                return true;
            }
        }
        return false;
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

}

/*
        List<E> newList = new ArrayList<>();
        for (ArrayList<E> aHashTable : hashTable) {
            if (aHashTable != null) {
                newList.addAll(aHashTable);
            }
        }
        newList.addAll(c);

        //this.clear();
        //this.

        //Collection<? extends E> c;
        for (Object o : c) {
            int index = positionInMainArray(o);
            E e = (E) o;
            hashTable[index].add(e);
        }
        return true;
    }
 */


    //Iterator iter = c.iterator();
    //Iterator<? extends E> i = c.iterator();

    //for (Iterator<? extends E> i = c.iterator(); i.hasNext(); ) {
    //E e = i.next();
    //int index = positionInMainArray(e);
    //hashTable[index].add(e);
    //}

/*
        for (int i = 0; iter.hasNext(); i++) {
            E e = (E) iter.next();
            //iter.next();
            //int index = positionInMainArray(iter.next());
            int index = positionInMainArray(e);
            hashTable[index].add(e);
            //if( i%6 == 0 )
            //res += "\n";
            //res += " " + iter.next().toString();   // !!!
        }
 */


    //c.iterator();


    //for (int i = 0; i < hashTable.length; i++) {
    //hashTable[i].addAll(c);
    //}


    //boolean modified = false;
    //for (E e : c)
    //if (add(e))
    //modified = true;
    //return modified;

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
            //positionInMainArray(c.[i]);
            hashTable[i].addAll(c);
            hashTable[i].containsAll(c);
        }


        //int index = c.positionInMainArray();
        //hashTable[index].size();
        //c.toArray();

        //this.addAll(c);
 */


