package net.codejava;

public class Main 
{
	// here is the main method which drives my queue program
	// running this program should give you the desired result (assuming i understood the instructions correctly :))
    public static void main(String[] args) 
    {
        MyQueue myQueue = new MyQueue();

        // i start by actually adding to my queue
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);

        // then, i demonstrated the different methods in this assignment
        System.out.println("Demonstration of viewing orginal queue node: " + myQueue.peek()); 

        System.out.println("Demonstration of dequeue: " + myQueue.dequeue()); 
        System.out.println("Demonstration of dequeue: " + myQueue.dequeue());

        System.out.println("Demonstration of is empty: " + myQueue.isEmpty());
        System.out.println("Demonstration of length: " + myQueue.getLength()); 
    }
}

