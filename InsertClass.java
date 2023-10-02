package net.codejava;
import java.util.Random;

public class InsertClass 
{
	public static void main(String[] args)
	{
		int[] firstArray = randomizedArray(15, 1, 1000);
		int[] secondArray = duplicateArray(firstArray);
		int[] thirdArray = duplicateArray(firstArray);

		// HERE IS MY ARRAY
		System.out.println("Here is my array: ");
        for (int value : firstArray) 
        {
            System.out.print(value + " ");
        }
        System.out.println(" ");
        System.out.println(" ");
		
		// HERE IS WHERE I CALL MY INSERTION SORT
		long insertionStart = System.nanoTime();
		insertionSort(thirdArray);
		long insertionFinish = System.nanoTime();
		long timeElapsedMillisInsertion = insertionFinish - insertionStart;
	
		System.out.println("Demonstration that insertion sort worked");
        for (int value : thirdArray) 
        {
            System.out.print(value + " ");
        }
        System.out.println(" ");
        System.out.println(" ");
        
		// HERE IS WHERE I CALL MY BUBBLE SORT
		long start1 = System.nanoTime();
		bubbleSort(firstArray);
		long finish1 = System.nanoTime();
		long timeElapsedMillis1 = finish1 - start1;

		// HERE IS WHERE I CALL MY SELECTION SORT
		long start2 = System.nanoTime();
		selectionSort(secondArray);
		long finish2 = System.nanoTime();
		long timeElapsedMillis2 = finish2 - start2;

		// HERE IS WHERE I COMPARE THE RUN TIME OF EACH SORT METHOD
		System.out.println("Insertion Sort of " + thirdArray.length + " integer array took " + timeElapsedMillisInsertion + "ns to complete.");
		System.out.println("Bubble Sort of " + firstArray.length + " integer array took " + timeElapsedMillis1 + "ns to complete.");
		System.out.println("Selection Sort of " + secondArray.length + " integer array took " + timeElapsedMillis2 + "ns to complete.");

	}
	
	
	// ********* THIS IS THE KEY CONTENT OF THIS ASSIGNMENT ********** //
	// HERE IS A METHOD TO PERFORM AN INSERTION SORT ON AN INTEGER ARRAY
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
	
	
	
	
	
	// THE FOLLOWING CODE WAS CARRIED OVER FROM ASSIGNMENT SIX AND SUPPORTS MY BENCHMARKS
	
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


