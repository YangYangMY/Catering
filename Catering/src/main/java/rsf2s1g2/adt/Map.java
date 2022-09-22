package rsf2s1g2.adt;

import java.util.Scanner;

public class Map<K, V> implements MapInterface<K, V> {

    private MapTable<K, V>[] hashTable;
    private int numOfEntries;
    private static final int SIZE = 100;

    public Map() {
        this(SIZE);
    }

    public Map(int tableSize) {
        hashTable = new MapTable[tableSize];
        numOfEntries = 0;
    }

    @Override
    public boolean add(K key, V value) {
        hashTable[numOfEntries] = new MapTable<K, V>(key, value);
        numOfEntries++;

        // Scanner input = new Scanner(System.in);
        // System.out.println("YES ADD");
        // System.out.println(numOfEntries - 1);
        // System.out.println(hashTable[numOfEntries - 1].getValue());
        // System.out.println(numOfEntries);
        // input.next();
        
        return true;
    }

    @Override
    public void remove(K key) {
        V valueToRemove = null;

        int index = getValueIndex(key);

        if (index != -1) {
            valueToRemove = hashTable[index].getValue();
            hashTable[index].toRemove();
            numOfEntries--;
        }
    }

    @Override
    public int getValueIndex(K key) {
        int index = 0;

        if (hashTable == null) {
            System.out.println("Data is Empty");
        }

        for (int i = 0; i < numOfEntries; i++) {
            if (hashTable[i].getKey().equals(key)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public V getValue(K key) {
        V dataValue = null;

        int index = getValueIndex(key);

        if (index != -1) {
            dataValue = hashTable[index].getValue();
        }

        return dataValue;
    }

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }

    @Override
    public boolean contains(K key) {
        return getValue(key) != null;
    }

    @Override
    public String toString() {
        String output = " ";
        for (int i = 0; i < numOfEntries - 1; i++) {
            output += hashTable[i].getValue();
        }

        return output;
    }


    
    @Override
    public int getNumOfEntries() {
        return numOfEntries;
    }

    private class MapTable<K, V> {
        private K key;
        private V value;
        private boolean inTable;

        private MapTable(K uniqueKey, V dataValue) {
            key = uniqueKey;
            value = dataValue;
            inTable = true;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private boolean isExist() {
            return inTable;
        }

        private void toRemove() {
            key = null;
            value = null;
            inTable = false;
        }

    }


}
