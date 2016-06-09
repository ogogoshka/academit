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
        if (a.length < this.size()) {
            //Object[] newArray = new Object[this.size()];
            //System.arraycopy(this.toArray(), 0, newArray, 0, this.size());
            //return (T[]) newArray;
            return (T[]) Arrays.copyOf(this.toArray(), this.size(), a.getClass());
        }
        //System.arraycopy(this.toArray(), 0, a, 0, this.size());
        int k = 0;
        if (a.length >= this.size()) {
            for (ArrayList<E> currentBucket : hashTable) {
                for (E currentElement : currentBucket) {
                    a[k] = (T) currentElement;
                    k++;
                }
            }
            a[this.size()] = null;
        }
        return a;
    }

/*
        if (a.length < this.size())
        return (T[]) Arrays.copyOf(this.toArray(), this.size(), a.getClass());
        System.arraycopy(this.toArray(), 0, a, 0, this.size());
        if (a.length > this.size())
        a[this.size()] = null;
        return a;
 */

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
        private int currentIndex2;
        private HashTable<E> eHashTable;
        private ArrayList<E> eArrayList;

        @Override
        public boolean hasNext() {
            int lastPosition = HashTable.this.hashTable[currentBucket].size();
            int lastBucket = hashTable.length - 1;
            return !(currentBucket == lastBucket && currentIndex == lastPosition);

            //E endElem = hashTable[hashTable.length].get(hashTable[hashTable.length].size());
            //int lastPosition = hashTable[lastBucket].size();

            //if (currentIndex > lastEl || currentBucket > lastBuck) {
            //this.currentIndex = HashTable.this.size();

            //return currentIndex < HashTable.this.size() && currentBucket < hashTable.length;
            //&& hashTable[currentBucket].get(currentIndex2) != null;
            //arrayList[currentIndex] != null;
            //int currentIndex2 = hashTable[currentBucket].get(currentIndex);

            //hashTable[currentIndex].listIterator(1);
            //Iterator<E> iterator = hashTable[currentBucket].iterator();

            //Iterator<E> iteratorer = hashTable[currentBucket].listIterator();

            //ListIterator<E> listIts = hashTable[currentBucket].listIterator(HashTable.this.size());
            //System.out.println(listIts.nextIndex());

            //return null;
            //return iterator.hasNext();
            //iterator.hasNext();
            //if (HashTable.this.iterator()) {
            //return true;
            //}

            //return currentIndex2 < HashTable.this.size();
        }

        @Override
        public E next() {
            //if (!hasNext()) {
            //throw new NoSuchElementException();
            //}

            if (currentBucket > hashTable.length) {
                throw new NoSuchElementException("конец массива");
            }

            if (currentIndex == hashTable[currentBucket].size()) {
                if (hashTable[currentBucket] == null) {
                    currentBucket++;
                    return hashTable[currentBucket].get(currentIndex);
                } else {
                    currentIndex = 0;
                    currentBucket++;
                    return hashTable[currentBucket++].get(currentIndex);
                }
            } else {
                return hashTable[currentBucket].get(currentIndex++);
            }

            //else {
            //Object[] thisArray = HashTable.this.toArray();
            //E el;
            //for (int i = 0; i < hashTable.length; i++) {
            //el = hashTable[i].get(currentIndex++);
            //}

            //return (E) thisArray[currentIndex++];

            //if (currentBucket < hashTable.length) {
            //return hashTable[currentBucket++].get(currentIndex++);
            //}else{
            //return hashTable[currentBucket].get(currentIndex);
            //}
            //return hashTable[currentBucket].get(currentIndex);
            //}

            //HashTable.this.hashTable[currentIndex++];

            //for (Object currentElement : hashTable) {
            //currentElement[currentIndex++];
            //}

            //HashTable.this.hashTable[currentBucket].get(currentIndex++);
            //hashTable[currentBucket].iterator().next();

            //while (hashTable.length < currentBucket) {

            //if (currentIndex < hashTable[currentBucket].size()) {
            //return HashTable.this.hashTable[currentBucket].get(currentIndex++);
            //} else {
            //currentBucket++;
            //}
/*
                Iterator<E> iter = HashTable.this.hashTable[currentBucket].iterator();
                if (iter.hasNext()) {
                    return HashTable.this.hashTable[currentBucket].get(currentIndex++);
                } else {
                    currentBucket++;
                    //return HashTable.this.hashTable[currentBucket].get(currentIndex++);
                }
 */


            //}

            //Iterator<E> iter = HashTable.this.hashTable[currentBucket].iterator();
            //if (iter.hasNext()) {
            //return HashTable.this.hashTable[currentBucket].get(currentIndex++);
            //} else {
            //currentBucket++;
            //return HashTable.this.hashTable[currentBucket].get(currentIndex++);
            //}
            /*
                    E item = this.next.getData();
			this.last = this.next;
			//advance all 3 instance variables through the list
			this.next = this.next.getNext();
			this.nextIndex++;
			this.previous = this.previous.getNext();

			return item;

            Iterator<E> iter = HashTable.this.hashTable[currentBucket].iterator();

            for (int i = 0; iter.hasNext(); i++) {

            }


            for (ArrayList<E> aHashTable : hashTable) {
                Iterator<E> iters = aHashTable.iterator();
                if (!iters.hasNext()) {
                    aHashTable.listIterator();
                } else {
                    return aHashTable.get(currentIndex++);
                }

            }



            Iterator<E> iters = HashTable.this.iterator();

            for (ArrayList<E> aHashTable : hashTable) {
                Iterator<E> iterat = aHashTable.iterator();
                //if (iterat.hasNext()) {
                //return iterat.next();
                //}
            }


            if (iters.hasNext()) {

            }

            ListIterator<E> listIter = hashTable[currentBucket].listIterator();
 */
            //int nextEl = listIter.nextIndex();
            //}
            //currentIndex = 0;
            //currentBucket = 0;


            //return hashTable[currentBucket].get(currentIndex++);
/*

            E el = hashTable[currentBucket].get(currentIndex);

            for (ArrayList<E> aHashTable : hashTable) {
                //Iterator<E> iters = aHashTable.iterator();
                //if (!iters.hasNext()) {
                aHashTable.listIterator();
                //} else {
                el = aHashTable.get(currentIndex++);
            }
            return el;
 */


            //return hashTable[currentBucket].get(currentIndex++);


            //return HashTable.this.hashTable[currentBucket].get(currentIndex++);
            //return HashTable.this.hashTable[currentBucket].get(currentIndex++);
            //return (E) HashTable.this.hashTable[currentBucket++].get(currentIndex++);
        }
    }
}
            /*
                        for (Iterator<E> i = hashTable[currentBucket].iterator(); i.hasNext(); ) {

                //if(hashTable[currentBucket].size()){

                //}


                if (i.hasNext()) {
                    return i.next();
                } else {
                    currentBucket++;
                }

                //String text = i.next();
                //System.out.println(text);
            }
            return null;
        }
             */

//Iterator<E> iterator = hashTable[currentBucket].iterator();

//if (currentBucket < hashTable.length) {
//return (E) iterator.next();
//}
//Iterator iterator = hashTable[currentBucket].iterator();
//currentBucket++;
//return (E) iterator.next();
//return (E) iterator.next();
//E el = hashTable[currentBucket].get(currentIndex);
//currentIndex++;
//return el;

//Iterator iterator = HashTable.this.iterator();
//return (E) iterator.next();
//E returnValue = HashTable.this.iterator().next();

//return returnValue;
//return hashTable[currentBucket++].iterator().next();
//while(iterator.hasNext()){

//return (E) iterator.next();
//}


//for (int currentBucket = 0; currentBucket < hashTable.length; currentBucket++) {
//Iterator iterator = hashTable[currentBucket].iterator();
//while (iterator.hasNext()) {
//return (E) iterator.next();
//}
//if (iterator.hasNext()) {
//return (E) iterator.next();
//}
//}


//if (iterator.hasNext()) {
//return (E) iterator.next();
//} else {
//currentBucket++;
//return (E) iterator.next();
//}


//if (currentBucket < hashTable.length) {
//                return hashTable[currentBucket++].get(currentIndex++);
//            }
//return null;
//}


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



/*

            if (currentIndex == hashTable[currentBucket].size()) {


                //if (hashTable[currentBucket] != null) {
                //return hashTable[currentBucket++].get(currentIndex);
                //} else {

                //}


                //currentBucket = 1;
                //currentBucket++;

                if (hashTable[currentBucket] == null) {
                    currentBucket++;
                    return hashTable[currentBucket].get(currentIndex);
                }

                currentIndex = 0;
                currentBucket++;

                return hashTable[currentBucket++].get(currentIndex);
            } else {
                return hashTable[currentBucket].get(currentIndex++);
            }

 */