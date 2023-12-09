package net.codejava;


// finally, i built this blueprint for a binary search tree
// resource i used for some of these methods: 
// https://docs.oracle.com/javase%2F9%2Fdocs%2Fapi%2F%2F/jdk/nashorn/api/tree/BinaryTree.html
public class BinarySearchTree 
{
	// start by including a node object
    private Node root;
    
    
    // then inserting the instructor
    public BinarySearchTree() 
    {
        root = null;
    }

    // method for inserting my key
    public void insert(int key) 
    {
        root = insertRec(root, key);
    }

    // and then inserting the recursive helper method to insert a key into the binary search tree
    private Node insertRec(Node root, int key) 
    {
        if (root == null) 
        {
            root = new Node(key);
            return root;
        }

        if (key < root.key) 
        {
            root.left = insertRec(root.left, key);
        } 
        else if (key > root.key) 
        {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    
    // next i initiated a delete method to ensure that i could remove values from my data structure
    public void delete(int key) 
    {
        root = deleteRec(root, key);
    }

    // again, included a recursive helper for my functions
    private Node deleteRec(Node root, int key) 
    {
        if (root == null) 
        {
            return root;
        }

        if (key < root.key) 
        {
            root.left = deleteRec(root.left, key);
        } 
        else if (key > root.key) 
        {
            root.right = deleteRec(root.right, key);
        } 
        else 
        {
            if (root.left == null) 
            {
                return root.right;
            } 
            else if (root.right == null) 
            {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // method for locating the min value in a search
    private int minValue(Node root) 
    {
        int minValue = root.key;
        while (root.left != null) 
        {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // initiation of a search method
    public Node search(int key) 
    {
        return searchRec(root, key);
    }

    // and here is my recursive helper for the search
    private Node searchRec(Node root, int key) 
    {
        if (root == null || root.key == key) 
        {
            return root;
        }

        if (key < root.key) 
        {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    // this method is used to perform an in order traversal of the binary search tree
    public void inorderTraversal() 
    {
        inorderTraversalRec(root);
    }

    // followed by the corresponding recursive helper 
    private void inorderTraversalRec(Node root) 
    {
        if (root != null) 
        {
            inorderTraversalRec(root.left);
            System.out.print(root.key + " ");
            inorderTraversalRec(root.right);
        }
    }
}
