package net.codejava;
import java.util.Random;

public class Driver 
{
    public static void main(String[] args) 
    {
    	// here my implementation of the BinSearch Tree
        BinarySearchTree bst = new BinarySearchTree();

        // then i initiated task one by randomly insert 10 non-repeated numbers from 0 to 9
        System.out.println("implementation of task 1: ");
        for (int i = 0; i < 10; i++) 
        {
            int randomKey = getRandomNumber(0, 9);
            bst.insert(randomKey);
        }
        // followed by printing the final tree
        bst.inorderTraversal();
        System.out.println();

        // then i implemented task two by deleting three numbers (randomly picked from 0 to 9 again)
        System.out.println("implementation of task 2: ");
        for (int i = 0; i < 3; i++) 
        {
            int randomKeyToDelete = getRandomNumber(0, 9);
            bst.delete(randomKeyToDelete);
        }
        // again printing the final tree
        bst.inorderTraversal();
        System.out.println();

        // finally, task three where i search three random numbers between 0 and 9
        System.out.println("implementation of task three: ");
        for (int i = 0; i < 3; i++) 
        {
            int randomKeyToSearch = getRandomNumber(0, 9);
            Node result = bst.search(randomKeyToSearch);
            System.out.println("Search result for " + randomKeyToSearch + ": " + (result != null));
        }
    }

    // basic method for generating my random numbers
    private static int getRandomNumber(int min, int max) 
    {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
