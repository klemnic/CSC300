package net.codejava;
import java.util.Random;
import java.util.Arrays;

public class ShellQuickClass 
{
	public static void main(String[] args)
	{
		int arraySize = 10_000_000;
        int[] randomArray = randomArrayGenerator(arraySize);
        
        // Benchmark Shell Sort
        long shellSortTime = benchmarkShellSort(randomArray, 3);
        System.out.println("Shell Sort Average Runtime: " + shellSortTime + " milliseconds");

        // Benchmark Quick Sort
        long quickSortTime = benchmarkQuickSort(randomArray, 3);
        System.out.println("Quick Sort Average Runtime: " + quickSortTime + " milliseconds");
	}
	
	// I started by including a basic partition method for my shell and quick sorts
	public static int Partition(int[] arr, int lowIndex, int highIndex) 
	{
		int low = lowIndex;
		int high = highIndex;
		
		int pivot = arr[(low + high)/2];
		
		boolean done = false;
		while(!done) 
		{
			while(arr[low] < pivot && low <= highIndex) 
			{
				low = low + 1;
			}
			while(arr[high] >= pivot && high > lowIndex) 
			{
				high = high-1;
			}
			
			if (high > low) 
			{
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			} else 
			{
				done = true;
			}
		}
		return high;
	}
	
	// Here is where I designed my shellSort function based on our class and book content
	public static void shellSort(int[] arr) 
	{
        int n = arr.length;
        
        for (int gap = n / 2; gap > 0; gap /= 2) 
        {
            for (int i = gap; i < n; i++) 
            {
                int temp = arr[i];
                int j;
                
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                {
                    arr[j] = arr[j - gap];
                }
                
                arr[j] = temp;
            }
        }
	}
	
	// Here is where I designed my quickSort function based on our class and book content
	public static void quickSort(int[] arr, int low, int high) 
	{
	    if (low < high) 
	    {
	        int pivot = arr[low];
	        int left = low;
	        int right = high;

	        while (left < right) 
	        {
	            while (arr[left] <= pivot && left < right) 
	            {
	                left++;
	            }
	            while (arr[right] >= pivot && left <= right) 
	            {
	                right--;
	            }
	            if (left < right) 
	            {
	                int temp = arr[left];
	                arr[left] = arr[right];
	                arr[right] = temp;
	            }
	        }

	        int temp = arr[right];
	        arr[right] = arr[low];
	        arr[low] = temp;

	        // I used a recursive function to achieve this sort
	        quickSort(arr, low, right - 1);
	        quickSort(arr, right + 1, high);
	    }
	}

	
	// now its time for me to measure how well these algorithms are executing
	public static long benchmarkShellSort(int[] arr, int runs) 
	{
        long totalTime = 0;
        for (int i = 0; i < runs; i++) 
        {
            int[] copy = Arrays.copyOf(arr, arr.length);
            long startTime = System.currentTimeMillis();
            shellSort(copy);
            long endTime = System.currentTimeMillis();
            totalTime += endTime - startTime;
        }
        return totalTime / runs;
    }

    public static long benchmarkQuickSort(int[] arr, int runs) 
    {
        long totalTime = 0;
        for (int i = 0; i < runs; i++) 
        {
            int[] copy = Arrays.copyOf(arr, arr.length);
            long startTime = System.currentTimeMillis();
            quickSort(copy, 0, copy.length - 1);
            long endTime = System.currentTimeMillis();
            totalTime += endTime - startTime;
        }
        return totalTime / runs;
    }
    
    
	// I reused a random array generator method from past assignments
	public static int[] randomArrayGenerator(int size) 
	{
		int[] result = new int[size];
		Random r = new Random();
		for(int i = 0; i < size; i++) 
		{
			int pos = r.nextInt(size);
			result[i] = pos;
			result[pos] = i;
		}
		return result;
	}
	
    // I also reused a method to display the array
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
