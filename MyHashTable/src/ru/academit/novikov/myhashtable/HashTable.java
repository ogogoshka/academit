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
        if (a.length <= this.size()) {
            return (T[]) Arrays.copyOf(this.toArray(), this.size(), a.getClass());
        }
        Object[] thisArray = this.toArray();
        for (int i = 0; i < thisArray.length; i++) {
            a[i] = (T) thisArray[i];
        }
        //for (int i = thisArray.length; i < a.length; i++) {
        a[thisArray.length] = null;
        //}
        return a;
    }
    //a = (T[]) Arrays.copyOf(this.toArray(), this.size());
    //return a;
    //return (T[]) Arrays.copyOf(this.toArray(), this.size());
    //Object[] thisArray = this.toArray();
    //T[] result = Arrays.copyOf(a, thisArray.length);
    //for (int i = 0; i < thisArray.length; i++) {
    //result[i] = (T) thisArray[i];
    //}
    //System.arraycopy(thisArray, 0, a, 0, this.size());
    //if (a.length > this.size())
    //a[this.size()] = null;
    //return a;
    //Object[] thisArray = this.toArray();
    //T[] result = Arrays.copyOf(a, thisArray.length);
    //for (int i = 0; i < thisArray.length; i++) {
    //result[i] = (T) thisArray[i];
    //}
    //return result;

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
        //for (ArrayList<E> aHashTable : hashTable) {
        //if (aHashTable != null && aHashTable.addAll(c)) {
        //count++;
        //}
        //}
        for (E currentElement : c) {
            int index = positionInMainArray(currentElement);
            if (hashTable[index].add(currentElement)) {
                count++;
            }
        }
        return count > 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int count = 0;
        //for (ArrayList<E> aHashTable : hashTable) {
        //if (aHashTable != null && aHashTable.retainAll(c)) {
        //count++;
        //}
        //}

        for (Object currentElement : c) {
            int index = positionInMainArray(currentElement);
            if (hashTable[index].remove(currentElement)) {
                count++;
            }
        }

        return count > 0;
    }

    //удаляет из списка THIS все его элементы, которые не содержатся в C
    @Override
    public boolean retainAll(Collection<?> c) {
        int count = 0;

        for (Object currentElement : c) {
            int index = positionInMainArray(currentElement);
            //if (hashTable[index].retainAll(currentElement)) {
                //count++;
            //}
        }


        /*
                for (ArrayList<E> aHashTable : hashTable) {
            if (aHashTable != null && aHashTable.retainAll(c)) {
                count++;
            }
        }
         */

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
            return currentIndex < HashTable.this.size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                Object[] thisArray = HashTable.this.toArray();
                return (E) thisArray[currentIndex++];
                //if (currentBucket < hashTable.length) {
                //return hashTable[currentBucket++].get(currentIndex++);
                //}else{
                //return hashTable[currentBucket].get(currentIndex);
                //}
            }
        }
    }
    //return (E) HashTable.this.hashTable[currentIndex++];
    //E el = hashTable[currentBucket].get(currentIndex);
    //currentIndex++;
    //return null;


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


}
/*
    Object[] cArray = c.toArray();


    int count2 = 0;
    for(
    int i = 0;
    i<cArray.length;i++)

    {
        int bucket = positionInMainArray(cArray[i]);
        if (hashTable[bucket] != null && hashTable[bucket].retainAll(c)) {
            //hashTable[bucket].retainAll(c);
            return true;
        }
        //for (int j = 0; j < hashTable[bucket].size(); j++) {
        //hashTable[bucket].retainAll(c);
        //if (!(hashTable[bucket].get(j).equals(cArray[i]))) {
        //hashTable[bucket].remove(j);
        //count++;
        //}
        //}
        if (i == cArray.length) {
            return true;
        }
    }

    return false;
}

 */





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


