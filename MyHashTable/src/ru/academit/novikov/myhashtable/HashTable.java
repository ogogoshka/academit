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
            return (T[]) Arrays.copyOf(this.toArray(), this.size(), a.getClass());
        }

        int k = 0;
        for (ArrayList<E> currentBucket : hashTable) {
            if (currentBucket != null) {
                for (E currentElement : currentBucket) {
                    a[k] = (T) currentElement;
                    k++;
                }
            }
        }
        if (a.length > this.size()) {
            a[this.size()] = null;
        }
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

        private int currentIndex = 0;
        private int currentBucket = 0;

        //private int currentIndex;
        //private int currentBucket;

        @Override
        public boolean hasNext() {
            int lastPosition = hashTable[currentBucket].size();
            int lastBucket = hashTable.length - 1;


            //if (currentBucket == lastBucket && currentIndex > lastPosition) {
            //return false;
            //}
            //return true;
            return !(currentBucket == lastBucket && currentIndex == lastPosition);
            //return currentBucket != lastBucket || currentIndex != lastPosition;
        }

        @Override
        public E next() {
            //if (!hasNext()) {
            //throw new NoSuchElementException("конец хеш-таблицы");
            //}

            int lastBucket = hashTable.length - 1;
            //currentBucket = 0;

            while (hashTable[currentBucket] == null && currentBucket < lastBucket) {
                currentBucket++;
                if (hashTable[currentBucket] != null) {
                    currentIndex = 0;
                    return hashTable[currentBucket++].get(currentIndex);
                }
            }
/*
            if (currentBucket > lastBucket) {
                throw new NoSuchElementException("конец хеш-таблицы");
            }

 */

            int lastPosition = hashTable[currentBucket].size();

            if (hashTable[currentBucket] != null && currentIndex < lastPosition) {
                //if (currentIndex < lastPosition) {
                return hashTable[currentBucket].get(currentIndex++);
                //} else if (currentIndex == lastPosition) {
                //currentBucket++;
                //currentIndex = 0;
                //if (hashTable[currentBucket] == null) {
                //return hashTable[currentBucket++].get(currentIndex);
                //}
                //return hashTable[currentBucket].get(currentIndex);
            } else {
                currentIndex = 0;
                //throw new NoSuchElementException("конец хеш-таблицы");
                return hashTable[currentBucket++].get(currentIndex);
            }
            //}

            /*
            if (currentIndex < lastPosition) {
                return hashTable[currentBucket].get(currentIndex++);
            } else if (currentBucket < lastBucket && currentIndex == lastPosition) {
                //currentBucket++;
                currentIndex = 0;
                //if (hashTable[currentBucket] == null) {
                    return hashTable[currentBucket++].get(currentIndex);
                //}
                //return hashTable[currentBucket].get(currentIndex);
            } else {
                return hashTable[currentBucket].get(currentIndex++);
            }




            if (hashTable[currentBucket] == null) {
                currentBucket++;
                currentIndex = 0;
                if (currentBucket > lastBucket) {
                    throw new NoSuchElementException("конец хеш-таблицы");
                }
                return hashTable[currentBucket].get(currentIndex);
            } else {

                int lastPosition = hashTable[currentBucket].size();

                if (currentIndex == lastPosition) {
                    currentBucket++;
                    currentIndex = 0;
                    return hashTable[currentBucket++].get(currentIndex);
                }
                return hashTable[currentBucket].get(currentIndex++);
            }


            if (hashTable[currentBucket] == null) {
                currentBucket++;
                currentIndex = 0;
                if (currentBucket == lastBucket) {
                    return hashTable[currentBucket].get(currentIndex);
                }
                return hashTable[currentBucket].get(currentIndex);
            }


            if ((currentBucket == lastBucket && hashTable[currentBucket] == null) || currentBucket > lastBucket) {
                throw new NoSuchElementException("конец хеш-таблицы");
            } else {
                //int lastPosition = hashTable[currentBucket].size();
                if (currentIndex == lastPosition) {
                    currentBucket++;
                    currentIndex = 0;
                    if (currentBucket == lastBucket) {
                        return hashTable[currentBucket].get(currentIndex);
                    } else if (hashTable[currentBucket] == null) {
                        return hashTable[currentBucket++].get(currentIndex);
                    }
                }
                return hashTable[currentBucket].get(currentIndex++);
            }
            */
/*
            while (hashTable[currentBucket] == null && currentBucket < lastBucket) {
                currentBucket++;
                if (hashTable[currentBucket] != null) {
                    currentIndex = 0;
                    return hashTable[currentBucket++].get(currentIndex);
                }
            }

            int lastPosition = hashTable[currentBucket].size();

            if (currentIndex >= lastPosition) {
                E el = hashTable[currentBucket].get(currentIndex);
                currentBucket++;
                currentIndex = 0;
                return el;
            }

            return hashTable[currentBucket].get(currentIndex++);

            if (hashTable[currentBucket] == null) {
                if (currentBucket == lastBucket) {
                    throw new NoSuchElementException("конец хеш-таблицы");
                } else {
                    currentBucket++;
                    currentIndex = 0;
                    return hashTable[currentBucket].get(currentIndex);
                }
            } else {

                int lastPosition = hashTable[currentBucket].size();

                if (currentIndex == lastPosition) {
                    currentBucket++;
                    currentIndex = 0;
                    return hashTable[currentBucket].get(currentIndex);
                }
                return hashTable[currentBucket].get(currentIndex++);
            }


            if (currentBucket < lastBucket && currentIndex == lastPosition) {
                currentBucket++;
                currentIndex = 0;
                if (currentBucket == lastBucket) {
                    return hashTable[currentBucket].get(currentIndex);
                } else if (hashTable[currentBucket] == null) {
                    return hashTable[currentBucket++].get(currentIndex);
                }
                if (hashTable[currentBucket] == null) {
                    return hashTable[currentBucket++].get(currentIndex);
                } else {
                    return hashTable[currentBucket++].get(currentIndex);
                }
            } else {
                return hashTable[currentBucket].get(currentIndex++);
            }
        }
 */

            //return hashTable[currentBucket].get(currentIndex++);


            //Про итератор, в методе next:
            //1. Переменные нужно объявить после проверки на !hasNext, до этого они не нужны
            //2. Всё равно есть случаи, когда будет падать, тоже потестируйте
            //3. В if и else сейчас один и тот же код. Либо ошибка, либо можно просто этот код написать.


        }
    }
}

