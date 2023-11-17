package net.codejava;

// i also included my implementation of the queue class
class MyQueue extends MyDoublyLinkedList implements Queue 
{

    @Override
    public void enqueue(int x) 
    {
        addLast(x);
    }

    @Override
    public int dequeue() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Queue is empty");
        }
        return removeFirst();
    }

    @Override
    public int peek() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() 
    {
        return super.isEmpty();
    }

    @Override
    public int getLength() 
    {
        return super.getLength();
    }
}


