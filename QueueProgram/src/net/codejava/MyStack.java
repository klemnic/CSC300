package net.codejava;

// here is my implementation of a basic stack class with the specified methods
class MyStack extends MyDoublyLinkedList implements Stack 
{

    @Override
    public void push(int x)
    {
        addFirst(x);
    }

    @Override
    public int pop() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Stack is empty");
        }
        return removeFirst();
    }

    @Override
    public int peek() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Stack is empty");
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

