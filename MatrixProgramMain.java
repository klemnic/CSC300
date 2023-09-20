package net.codejava;
import java.util.Arrays;

public class MatrixProgramMain 
{
	public static void main(String[] args)
	{
		
		//here is the code that creates my array matrix
		//i used an embedded loop to create a starting value of 0
		//while increasing the value with each turn through the loop
		int[][] matrix = new int[3][4];
		int value = 0;

		for (int row = 0; row < matrix.length; row++) 
		{
		    for (int col = 0; col < matrix[row].length; col++) 
		    {
		        matrix[row][col] = value;
		        value++;
		    }
		}	
		
        int[] result = matrixSearch(matrix, 5);
        
        System.out.print("That integer appears at: ");

        System.out.println(Arrays.toString(result));
	}
	
	//here is the code where i create a basic binary search
	static int binarySearch(int[] array, int target)
	{
		int left = 0;
		int right = array.length - 1;
		
		while(left <= right)
		{
			int middle = left + (right - left) / 2;
			
			if(array[middle] == target)
			{
				return middle;
			}
			else if(array[middle] > target)
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}
		
		return -1;
	}
	
	
	static int[] matrixSearch(int[][] matrix, int key)
	{
        for (int row = 0; row < matrix.length; row++) 
        {
            int[] currentRow = matrix[row];
            int result = binarySearch(currentRow, key);
            
            if (result != -1) 
            {
                return new int[]{row, result};
            }
        }

        return null;
	}
	
}






























/*

arr = [ [1,  2, 3, 4],
        [5,  6, 7, 8],
        [9, 10,11,12]];
int[] MatrixSearch(int[][] arr, int key){

}
int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
print(arr[1][0]) //arr[1][0] is 5
$ 5
print(MatrixSearch(arr, 5))
$ [1,0]


Sorted Matrix Search: Given an M x N matrix in which each row and each 
column is sorted in ascending order, try to use binary search to write a method to find an element.


*/

//System.out.println(Arrays.deepToString(matrix));


//here i test my matrixSearch function
/*print(arr[1][0]) //arr[1][0] is 5
$ 5
print(MatrixSearch(arr, 5))
$ [1,0]*/