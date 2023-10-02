package net.codejava;
import java.util.Random;


public class SortClass 
{
	
	// HERE IS THE DRIVER OF MY SORT COMPARISON PROGRAM
	public static void main(String[] args)
	{
		// I BEGIN MY PROGRAM BY CALLING MY RANDOMIZED ARRAY FUNCTION
        int[] firstArray = randomizedArray(15, 1, 1000);
        
        System.out.println("HERE IS MY ARRAY");
        
        // NOTE** I WAS HAVING TROUBLE PRINTING MY ARRAY-- I DID SOME RESEARCH AND FOUND THIS METHOD FOR PRINTING AN ARRAY WHICH I LIKED
        for (int value : firstArray) 
        {
            System.out.print(value + " ");
        }
        System.out.println(" ");
        System.out.println(" ");
        
        
        // THEN, I CALL A METHOD TO DUPLICATE THIS ARRAY
        System.out.println("HERE IS MY DUPLICATED ARRAY");
        
        int[] secondArray = duplicateArray(firstArray);
        
        for (int value : secondArray) 
        {
            System.out.print(value + " ");
        }
        System.out.println(" ");
        System.out.println(" ");
        
		// THEN, I CALL MY BUBBLE SORT ON THE FIRST ARRAY
        System.out.println("HERE IS MY FIRST ARRAY SORTED BY BUBBLE SORT");
        
        long start1 = System.nanoTime();
        bubbleSort(firstArray);
        for (int value : firstArray) 
        {
            System.out.print(value + " ");
        }
        long finish1 = System.nanoTime();
        long timeElapsedMillis1 = finish1 - start1;
        System.out.println(" ");
        System.out.println("Bubble Sort of " + firstArray.length + " integer array took  " + timeElapsedMillis1 + "ms to complete.");
        System.out.println(" ");
        System.out.println(" ");
        
		// THEN, I CALL MY SELECTION SORT ON THE FIRST ARRAY
        System.out.println("HERE IS MY SECOND ARRAY SORTED BY SELECTION SORT");
        
        long start2 = System.nanoTime();
        selectionSort(secondArray);
        for (int value : secondArray) 
        {
            System.out.print(value + " ");
        }
        long finish2 = System.nanoTime();
        long timeElapsedMillis2 = finish2 - start2;
        System.out.println(" ");
        System.out.println("Bubble Sort of " + firstArray.length + " integer array took  " + timeElapsedMillis2 + "ms to complete.");
        System.out.println(" ");
        System.out.println(" ");
        
       
	}
	
	
	
	// HERE IS A METHOD WHICH CREATES A RANDOMIZED INTEGER ARRAY
    public static int[] randomizedArray(int size, int start, int end) 
    {
        if (size <= 0 || start > end) 
        {
        	// RETURNS AN EMPTY ARRAY IF INPUT PARAMETERS DONT MAKE SENSE
        	System.out.println("Error");
            return new int[0];
        }

        // I HAVE EXPERIENCE USING THE RANDOM PACKAGE FROM CODING II
        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) 
        {
            randomArray[i] = random.nextInt(end - start + 1) + start;
        }

        return randomArray;
        
    }
	
    
    // HERE IS A METHOD TO DUPLICATE MY ARRAY
    public static int[] duplicateArray(int[] originalArray)
    {
    	int[] duplicatedArray = new int[originalArray.length]; 
    	
    	for (int i = 0; i < originalArray.length; i++)
    	{
    		duplicatedArray[i] = originalArray[i];
    	}
    	
    	return duplicatedArray;
    		
    }
    	
    
	// HERE IS A METHOD TO PERFORM A BUBBLE SORT ON AN INTEGER ARRAY
    public static void bubbleSort(int[] arr) 
    {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) 
        {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) 
            {
                if (arr[j] > arr[j + 1]) 
                {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // IF NO TWO ELEMENTS WERE SWAPPED IN THE INNER LOOP, THE ARRAY IS ALREADY SORTED
            if (!swapped) 
            {
                return; 
            }
        }
    }
    
	// HERE IS A METHOD TO PERFORM A SELECTION SORT ON AN INTEGER ARRAY
    public static void selectionSort(int[] arr) 
    {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) 
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) 
            {
                if (arr[j] < arr[minIndex]) 
                {
                    minIndex = j;
                }
            }

            if (minIndex != i) 
            {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
       

	
}
