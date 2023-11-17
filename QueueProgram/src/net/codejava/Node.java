package net.codejava;

// nodes to support my doubly linked list
public class Node 
{
    int data;
    Node next;
    Node prev;

    public Node(int data) 
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
