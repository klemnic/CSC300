package net.codejava;

import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Hash table with chaining: ");
        HashTable_Chaining hashChaining = new HashTable_Chaining(10);
        insertRandomNumbers(hashChaining);
        System.out.println(hashChaining);

        System.out.println("\nLinear probe implemented successfully: " + testLinearProbe());
    }

    private static void insertRandomNumbers(HashTable hashTable) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int key = random.nextInt(100); // Assuming a range of 0 to 99 for random keys
            int value = key; // Using the key as the value for simplicity
            hashTable.HashInsert(key, value);
        }
    }

    private static boolean testLinearProbe() {
        HashTable_LinearProbe hashLinearProbe = new HashTable_LinearProbe(10);
        insertRandomNumbers(hashLinearProbe);

        // Test: Check whether HashSearch returns true for inserted keys
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int keyToSearch = random.nextInt(100);
            if (!hashLinearProbe.HashSearch(keyToSearch)) {
                System.out.println("Linear probe test failed for key: " + keyToSearch);
                return false;
            }
        }

        // Add more tests as needed

        return true; // All tests passed
    }
}




