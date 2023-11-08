package net.codejava;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


// this script is the implementation the singly linked list
// i hope that my implementation is in line with your assignment expectations
public class SinglyLinkedList<T> implements List<T> 
{

	// i began by creating the variable for my head node and length
    private Node<T> head;
    private int length;

    // this is an inner class for the singly linked list node
    private static class Node<T> 
    {
        T data;
        Node<T> next;

        Node(T data) 
        {
            this.data = data;
            this.next = null;
        }
    }

    // here is the constructor for initializing the singly linked list
    public SinglyLinkedList() 
    {
        head = null;
        length = 0;
    }

    // i start by making the append function for a new item to the end of the list
    public void append(T item) 
    {
        Node<T> newNode = new Node<>(item);
        // makes sure i add it to the right place given a series of conditions
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            Node<T> current = head;
            while (current.next != null) 
            {
                current = current.next;
            }
            current.next = newNode;
        }
        // incrementing the length
        length++;
    }

    // this is my prepend for new items to the beginning of the list
    public void prepend(T item) 
    {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        // again, i made sure to increment my length of the list
        length++;
    }

    // then i built a method to insert an item after a specified item
    public void insertAfter(T target, T item) 
    {
        Node<T> current = head;
        while (current != null && !current.data.equals(target)) 
        {
            current = current.next;
        }
        if (current != null) 
        {
            Node<T> newNode = new Node<>(item);
            newNode.next = current.next;
            current.next = newNode;
            length++;
        }
    }

    // as well as removing an item from the list given certain conditions and reducing the length of the list 
    public void remove(T item) 
    {
        if (head == null) 
        {
            return;
        }
        if (head.data.equals(item)) 
        {
            head = head.next;
            length--;
            return;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(item)) 
        {
            current = current.next;
        }
        if (current.next != null) 
        {
            current.next = current.next.next;
            length--;
        }
    }

    // i also built a sarch for an item in the list
    // it returns true if the input equals an item in the list
    public boolean search(T item) 
    {
        Node<T> current = head;
        while (current != null) 
        {
            if (current.data.equals(item)) 
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // basic function to print the list
    // i saw someone use an arrow online in the past and thought this was a cool way to organize my output
    public void print() 
    {
        Node<T> current = head;
        while (current != null) 
        {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // here, i sort the list in alphabetical order using bubble sort
    // i built this in step with our lessons from the first half of the semester
    public void sort() 
    {
        if (head == null || head.next == null) 
        {
            // if the list is empty or contains only one element, it's already sorted
            return;
        }

        boolean swapped;
        Node<T> lastNode = null;

        do 
        {
            swapped = false;
            Node<T> current = head;
            Node<T> previous = null;

            while (current != lastNode) 
            {
                Node<T> next = current.next;
                if (next != null && current.data.toString().compareTo(next.data.toString()) > 0) 
                {
                    // swapping the current and next nodes
                    if (previous != null) 
                    {
                        previous.next = next;
                    } 
                    else 
                    {
                        head = next;
                    }
                    current.next = next.next;
                    next.next = current;
                    swapped = true;
                }
                previous = current;
                current = next;
            }
            lastNode = current;
        } 
        while (swapped);
    }


    // then check if the list is empty
    public boolean isEmpty() 
    {
        return head == null;
    }

    // get the length of the list
    public int getLength() 
    {
        return length;
    }
    
    // printing the list in reverse
    public void printReverse() 
    {
        printReverseRecursive(head);
        System.out.println();
    }

    private void printReverseRecursive(Node<T> node) 
    {
        if (node == null) 
        {
            return;
        }
        printReverseRecursive(node.next);
        System.out.print(node.data + " -> ");
    }
}
