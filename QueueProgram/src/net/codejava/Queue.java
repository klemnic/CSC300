package net.codejava;

//here is my queue interface, as specified in the assignment instructions
public interface Queue 
{
    void enqueue(int x);
    int dequeue();
    int peek();
    boolean isEmpty();
    int getLength();
}
