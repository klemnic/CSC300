package net.codejava;

// this is my implementation of the doubly linked list including fields, constructors, and methods
public class MyDoublyLinkedList 
{
	// fields
    protected Node head;
    protected Node tail;
    private int size;

    // constructor
    public MyDoublyLinkedList() 
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // then i create my methods
    public void addFirst(int data) 
    {
        Node newNode = new Node(data);
        if (isEmpty()) 
        {
            head = tail = newNode;
        } 
        else 
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) 
    {
        Node newNode = new Node(data);
        if (isEmpty()) 
        {
            head = tail = newNode;
        } 
        else 
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public int removeFirst() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("List is empty");
        }

        int removedData = head.data;
        if (head == tail) 
        {
            // Only one node in the list
            head = tail = null;
        } 
        else 
        {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removedData;
    }

    public int removeLast() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("List is empty");
        }

        int removedData = tail.data;
        if (head == tail) 
        {
            // maintains only one node in the list
            head = tail = null;
        } 
        else 
        {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removedData;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int getLength() 
    {
        return size;
    }
}
