package net.codejava;

class NumbersProgram{
	
   // Though I understand that global variables are not a best practice for large problems,
   // I used one to track the number of times that my function was called
   private static int functionCalls = 0;
   
    public static void main(String[] args) 
    {
        int fibonacciNumber = getIndex(5);
        System.out.println("Fibonacci number at index is: " + fibonacciNumber);
        System.out.println("Function calls: " + functionCalls);
    }
    
    public static int getIndex(int index) 
    {
        functionCalls = functionCalls + 1;
        
        if (index <= 1) 
        {
            // This adjusts the original case of my index value
            return index + 1;
        } 
        else 
        {
            int a = 1; // This is the first Fibonacci value which I will track
            int b = 1; // This is the second Fibonacci value which I will track
            
            // Loop to perform addition for my sequence
            for (int i = 2; i <= index; i++) 
            {
                int temp = b;
                b = a + b;
                a = temp;
            }
            
            return b;
        }
    }
}
