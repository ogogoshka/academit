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

    


    public int positionInMainArray(E element) {
        return Math.abs(element.hashCode()) % hashTable.length;
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

        //int index = o.positionInMainArray();
        //hashTable[index];

        if (o == null) {
            throw new NullPointerException();
        } else {
            int index = hashCode();
            if (hashTable[index] == null) {
                //hashTable[index] = new ArrayList<>();
                //hashTable[index].remove(o);
                return false;
            } else {
                if (hashTable[index].contains(o)) {
                    return false;
                } else {
                    hashTable[index].remove(o);
                    return true;
                }
            }
        }
        /*
        boolean result = hashTable[index].remove(o);
        if (result)
            hashTable[index].remove(o);
        return result;


        if (hashTable[index] == null) {
            return false;
        } else {
            for (int i = 0; i < hashTable[index].size() - 1; i++)
                if (hashTable[index].get(i).equals(o)) {
                    hashTable[index].remove(i);
                    //hashTable[index].remove(o);
                    return true;
                }
        }
        return false;

    */
        //return true;
        //return hashTable[o.positionInMainArray()].remove(o);
        //int index = o.positionInMainArray();
        //if (hashTable[index] != null) {
        //hashTable[index].remove(o);
        //return true;
        //}
        //return false;
/*
        if (o == null) {
            throw new NullPointerException();
        } else {
            int index = o.positionInMainArray();
            hashTable[index].remove(o);
            return true;
        }

 */
    }

    @Override
    public boolean contains(Object obj) {
        E newElement = (E) obj;
        int index = positionInMainArray(newElement);
        if (hashTable[index].size() == 0) {
            return false;
        } else {
            //if (obj.positionInMainArray() != null) {
            for (int i = 0; i < hashTable[index].size(); i++) {
                if (hashTable[index].get(i).equals(obj)) {
                    return true;

                }
            }
            //}

        }
        return false;
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
        for (ArrayList<E> aHashTable : hashTable) {
            for (E anAHashTable : aHashTable) {
                newList.add(anAHashTable);
            }
        }
        return newList.toArray();
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

    @Override
    public void clear() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                hashTable[i].clear();
            }
        }
    }

}