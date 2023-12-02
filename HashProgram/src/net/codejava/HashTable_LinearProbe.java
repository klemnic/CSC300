package net.codejava;

public class HashTable_LinearProbe extends HashTable {
    private int[] keys;
    private int[] values;
    private int size;
    private int capacity;

    public HashTable_LinearProbe(int capacity) {
        this.capacity = capacity;
        this.keys = new int[capacity];
        this.values = new int[capacity];
        this.size = 0;
    }

    @Override
    public void HashInsert(int key, int value) {
        int index = linearProbe(key);
        keys[index] = key;
        values[index] = value;
        size++;
    }

    @Override
    public boolean HashSearch(int key) {
        int index = linearProbe(key);
        return keys[index] == key;
    }

    @Override
    public void HashDelete(int key) {
        int index = linearProbe(key);
        if (keys[index] == key) {
            keys[index] = 0; // Assuming 0 is not a valid key
            values[index] = 0; // Assuming 0 is not a valid value
            size--;
        }
    }

    private int linearProbe(int key) {
        int index = key % capacity;
        while (keys[index] != 0 && keys[index] != key) {
            index = (index + 1) % capacity;
        }
        return index;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            output.append("[").append(i).append("]: {").append(keys[i]).append(":").append(values[i]).append("}");
            if (i < capacity - 1) {
                output.append("; ");
            }
        }
        return output.toString();
    }
}

