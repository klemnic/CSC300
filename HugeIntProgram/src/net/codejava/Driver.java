package net.codejava;
import java.util.LinkedList;

public class Driver 
{
    public static void main(String[] args) 
    {
    	// here is my implementation code
        LinkedList<HugeInt> hugeIntList = new LinkedList<>();
        HugeInt num1 = new HugeInt("34220");
        HugeInt num2 = new HugeInt("-10000");
        HugeInt num3 = new HugeInt("84395");

        hugeIntList.add(num1);
        hugeIntList.add(num2);
        hugeIntList.add(num3);

        System.out.println("Unsorted List:");
        for (HugeInt num : hugeIntList) 
        {
            System.out.println(num);
        }

        sort(hugeIntList);

        System.out.println("\nSorted List:");
        for (HugeInt num : hugeIntList) 
        {
            System.out.println(num);
        }

        System.out.println("Addition:");
        HugeInt sum1 = HugeInt.additionFunction(num1, num3);
        System.out.println(num1 + " + " + num3 + " = " + sum1);

        HugeInt sum2 = HugeInt.additionFunction(num2, num3);
        System.out.println(num2 + " + " + num3 + " = " + sum2);

        System.out.println("Multiplication:");
        HugeInt product1 = HugeInt.multiplicationFunction(num1, num3);
        System.out.println(num1 + " * " + num3 + " = " + product1);

        HugeInt product2 = HugeInt.multiplicationFunction(num2, num3);
        System.out.println(num2 + " * " + num3 + " = " + product2);
    }
    

    // sorting the linked list of HugeInt objects using QuickSort
    public static void sort(LinkedList<HugeInt> list) {
        quickSort(list);
    }

    // quickSort implementation for the linked list
    private static void quickSort(LinkedList<HugeInt> list) {
        if (list == null || list.size() <= 1) {
            return; // No need to sort if the list is empty or contains only one element
        }

        quickSort(list, 0, list.size() - 1);
    }

    // my helper method for QuickSort
    private static void quickSort(LinkedList<HugeInt> list, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(list, left, right);

            quickSort(list, left, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, right);
        }
    }

    // the partition the linked list
    private static int partition(LinkedList<HugeInt> list, int left, int right) {
        HugeInt pivot = list.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, right);
        return i + 1;
    }

    // my helper method to swap two elements in the linked list
    private static void swap(LinkedList<HugeInt> list, int i, int j) {
        HugeInt temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
