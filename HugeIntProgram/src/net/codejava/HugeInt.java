package net.codejava;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;


public class HugeInt implements Comparable<HugeInt>
{
	// i started out by creating my own linked List to store digits
    private LinkedList<Integer> number;
    // then created the sign variable
    private int sign;

    
    // next i built the constructor for the HugeInt class
    // it takes a String called num as the parameter
    public HugeInt(String num) 
    {
    	// now it is time to set the number and determine whether it is positive or negative
        number = new LinkedList<>();
        if (num.charAt(0) == '-') 
        {
        	// this will set the sign to 0 or "negative" if the number begins with a negative symbol
            sign = 0; 
            // this removes the minus sign from the number string
            num = num.substring(1);
        } 
        else 
        {
        	// this will set the sign to 1 or "positive" if i do not find a minus sign
            sign = 1; 
        }
        // then i converted the string to digits and stored them in reverse order (this made my addition and multiplication methods more simple)
        for (int i = num.length() - 1; i >= 0; i--) 
        {
            int digit = num.charAt(i) - '0';
            number.add(digit);
        }
    }
    
    
    // here is my attempted implementation of the addition function
    public static HugeInt additionFunction(HugeInt a, HugeInt b) 
    {
    	// intiating result and carry variables
        HugeInt result = new HugeInt("0");
        int carry = 0;

        // ensurance equal length of integers
        a.equalizeLength(b);

        // running a loop that adds my numbers and keeps track of the carry values
        for (int i = 0; i < a.number.size(); i++) 
        {
            int sum = a.number.get(i) + b.number.get(i) + carry;
            carry = sum / 10;
            result.number.add(sum % 10);
        }

        // it knows whether to add my carry (this is similar to the way i would do addition in kindergarden :))
        if (carry > 0) 
        {
            result.number.add(carry);
        }

        //resulting sign and result
        result.sign = a.sign;

        return result;
    }
    
    // this is a helper method to equalize the length of two HugeInt objects
    private void equalizeLength(HugeInt other) 
    {
        int maxDigits = Math.max(this.number.size(), other.number.size());

        while (this.number.size() < maxDigits) {
            this.number.add(0);
        }

        while (other.number.size() < maxDigits) {
            other.number.add(0);
        }
    }
    
    // here is my attempted implementation of the multiplication function
    public static HugeInt multiplicationFunction(HugeInt a, HugeInt b) 
    {
    	// start by making sure i keep track of the integer sizes
        int aSize = a.number.size();
        int bSize = b.number.size();

        // as well as intializing the results
        HugeInt result = new HugeInt("0");

        // then i built a loop that keeps track of both my product and carry values
        for (int i = 0; i < aSize; i++) 
        {
            HugeInt partialProduct = new HugeInt("0");
            int carry = 0;

            // it increments with each integer in my huge int
            for (int j = 0; j < bSize; j++) 
            {
                int product = a.number.get(i) * b.number.get(j) + carry;
                carry = product / 10;
                partialProduct.number.add(product % 10);
            }

            if (carry > 0) 
            {
                partialProduct.number.add(carry);
            }

            // ends by adding zeros at the beginning based on position
            for (int k = 0; k < i; k++) 
            {
                partialProduct.number.add(0, 0);
            }

            // then use my addition function in the result
            result = additionFunction(result, partialProduct);
        }

        // i also had to remove leading zeros in the result
        while (result.number.size() > 1 && result.number.get(result.number.size() - 1) == 0) {
            result.number.remove(result.number.size() - 1);
        }

        return result;
    }
    
    // then i set up the CompareTo method to compare two HugeInt objects
    public int compareTo(HugeInt a) 
    {
        // first i had to compare the signs
        if (this.sign < a.sign) 
        {
        	// this is less than a
            return -1; 
        } 
        else if (this.sign > a.sign) 
        {
        	// this is greater than a
            return 1; // this is greater than a
        }

        int size1 = this.number.size();
        int size2 = a.number.size();

        // then i compare the lengths of the HugeInts
        if (size1 < size2) 
        {
        	// if both are negative, shorter is greater
            return (this.sign == 0) ? 1 : -1; 
        } 
        else if (size1 > size2) 
        {
        	 // if both are positive, longer is greater
            return (this.sign == 0) ? -1 : 1;
        }

        // otherwise i'd compare digit by digit
        for (int i = size1 - 1; i >= 0; i--) 
        {
            int digit1 = this.number.get(i);
            int digit2 = a.number.get(i);

            if (digit1 < digit2) 
            {
            	// if both are negative, smaller is greater
                return (this.sign == 0) ? 1 : -1; 
            } 
            else if (digit1 > digit2) 
            {
            	// if both are positive, larger is greater
                return (this.sign == 0) ? -1 : 1; 
            }
        }

        return 0; // otherwise they're equal
    }

        // here is a static method to sort a LinkedList of HugeInt objects using QuickSort
        public static void quickSort(LinkedList<HugeInt> list) 
        {
            if (list == null || list.size() <= 1) 
            {
            	// there is no need to sort if the list is empty or contains only one element
                return; 
            }

            int left = 0;
            int right = list.size() - 1;

            quickSort(list, left, right);
        }

        // this is my helper method for the QuickSort
        private static void quickSort(LinkedList<HugeInt> list, int left, int right) 
        {
            if (left < right) 
            {
                int partitionIndex = partition(list, left, right);

                quickSort(list, left, partitionIndex - 1);
                quickSort(list, partitionIndex + 1, right);
            }
        }

        // here is my partition method to partition the LinkedList
        private static int partition(LinkedList<HugeInt> list, int left, int right) 
        {
            HugeInt pivot = list.get(right);
            int i = left - 1;

            for (int j = left; j < right; j++) 
            {
                if (list.get(j).compareTo(pivot) <= 0) 
                {
                    i++;
                    swap(list, i, j);
                }
            }

            swap(list, i + 1, right);
            return i + 1;
        }

        // finally, heres the helper method to swap two elements in the LinkedList
        private static void swap(LinkedList<HugeInt> list, int i, int j) 
        {
            HugeInt temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
        
        // once i have built the preceding components, i could create an overarching sort method which uses the quick sort
        public static void sort(LinkedList<HugeInt> list) 
        {
            quickSort(list);
        }
        
        
        // this method was used to convert to a string
        public String toString() 
        {
            // converting the HugeInt to a string for printing
            StringBuilder result = new StringBuilder();
            if (sign == 0) {
                result.append('-');
            }
            
            // flag to skip leading zeros
            boolean leadingZeros = true; 

            for (int i = number.size() - 1; i >= 0; i--) {
                int digit = number.get(i);

                if (leadingZeros && digit == 0) {
                    continue; 
                }
                
                // indicates that there are no more leading zeros
                leadingZeros = false;

                result.append(digit);
            }

            if (result.length() == 0) {
                result.append('0');
            }

            return result.toString();
        }

}
