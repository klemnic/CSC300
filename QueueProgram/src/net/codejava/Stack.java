package net.codejava;

// here is my stack interface, as specified in the assignment instructions
public interface Stack 
{
    void push(int x);
    int pop();
    int peek();
    boolean isEmpty();
    int getLength();
}
