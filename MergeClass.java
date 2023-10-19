package net.codejava;
import java.util.Random;

public class MergeClass 
{
	public static void main(String[] args)
	{
		// creating my original array and displaying it
		int[] myArray1 = randomArrayGenerator(10);
		displayArray(myArray1);
		
		// sorting my array and displaying it again
        mergeImplementation(myArray1);
        displayArray(myArray1);
	}

	
    public static void mergeImplementation(int[] arr) 
    {
        if (arr == null || arr.length <= 1) 
        {
        	// if the array is null or has one or zero elements, it is already sorted
            return;
        }
        
        // start the merge sort process
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) 
    {
        if (left < right) 
        {
        	// finds the middle of the array
            int mid = left + (right - left) / 2;

            // uses recursive processes to sort the right and left
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // then call the merge function
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) 
    {
    	// determines the sizes of the two arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // filling the left and right arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) 
        {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) 
        {
            rightArray[i] = arr[mid + 1 + i];
        }

        // merges the two populated subarrays
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) 
        {
            if (leftArray[i] <= rightArray[j]) 
            {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // copying any remaining elements
        while (i < n1) 
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) 
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // random array generator method from past assignment
    public static int[] randomArrayGenerator(int size) 
    {
        int[] result = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) 
        {
            int pos = r.nextInt(size);
            result[i] = pos;
            result[pos] = i;
        }
        return result;
    }

    // method to display the array from past assignment
    public static void displayArray(int[] arr) 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.print(arr[i]);
            if (i < arr.length - 1) 
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

