package net.codejava;


// here is my implementation of the node class where i include the key, left, and right data values
public class Node 
{
    int key;
    Node left, right;

    // and initiate the class with my constructor
    public Node(int item) 
    {
        key = item;
        left = right = null;
    }
}
