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

    //return obj == null ? false : indexOf(obj) != -1;
    //hashTable[index]
    //this.contains(obj);


    //for (E mad : hashTable[index]) {
    //if (mad.equals(element)) {
    //return true;
    //}
    //}
    //return false;


    //if (hashTable[index].contains(o)) {
    //return true;
    //}

    //for (int i = 0; i < hashTable[index].size() - 1; i++) {
    //if (hashTable[index].get(i).equals(o)) {
    //return true;
    //}
    //}
    //return false;

/*
        public boolean contains(Object o) {
            for (int i=0; i<size(); i++) {
                E e = theElements[i];
                if ( (o==null) ? e==null : o.equals(e) )
                    return true;
            }
            return false;
        }
//(o==null ? e==null : o.equals(e))

        int index = o.positionInMainArray();
        for (int i = 0; i < hashTable[index].size(); i++) {
            E element = hashTable[index].get(i);
            if ((o == null) ? element == null : o.equals(element))
                //hashTable[index].remove(i);
                return true;
        }
        return false;
    }
     */
/*
        if (hashTable[index] != null && hashTable[index].contains(o)) {
            return true;
        }


        //return hashTable[index] != null && hashTable[index].contains(o);
        return false;
    }
 */


    @Override
    public Iterator<E> iterator() {
        //E e = new E();
        //int index = e.positionInMainArray();
        int length = hashTable.length;
        //hashTable[index].size();
        //hashTable[index].iterator();
/*
        //Iterator<E> it = new Iterator<E>() {


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
        return null;
    }


    @Override
    public Object[] toArray() {
        List<E> newList = new ArrayList<E>();
        //Collection<E> newList  = new ArrayList<E>();
        /*
            for (ArrayList<E> aHashTable : hashTable) {
            if (aHashTable != null) {
                for (E anAHashTable : aHashTable) {
                    newList.add(anAHashTable);
                }
            }
        }
        return newList.toArray();
         */

        for (ArrayList<E> aHashTable : hashTable) {
            //if (!aHashTable.isEmpty()) {
            if (aHashTable != null) {
                //aHashTable.toArray();
                //for (int j = 0; j < hashTable[i].size(); j++) {
                //newList.add(hashTable[i].get(j));
                newList.addAll(aHashTable);
                //}
            }
        }
        return newList.toArray();
        //return newList.toArray();

    }


    @Override
    public <T> T[] toArray(T[] a) {
        //List<E> newList = new ArrayList<E>();
        //for (ArrayList<E> aHashTable : hashTable) {
        //for (E anAHashTable : aHashTable) {
        //newList.add(anAHashTable);
        //}
        //}
        //return newList.toArray(a);
        return null;
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


        //Collection<? extends E> c;
        for (Object o : c) {
            int index = positionInMainArray(o);
            E e = (E) o;
            hashTable[index].add(e);
        }


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
        return true;
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
            //positionInMainArray(c.[i]);
            hashTable[i].addAll(c);
            hashTable[i].containsAll(c);
        }


        //int index = c.positionInMainArray();
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

}