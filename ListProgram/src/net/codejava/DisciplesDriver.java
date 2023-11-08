package net.codejava;

public class DisciplesDriver 
{
    public static void main(String[] args) 
    {
    	// here is where i built the driver for my singlylinkedlist program
        SinglyLinkedList<String> disciples = new SinglyLinkedList<>();

        // a started by adding the 12 disciples to the list
        // see SinglyLinkedList lines 34 - 49 for my code
        disciples.append("Peter");
        disciples.append("James");
        disciples.append("John");
        disciples.append("Andrew");
        disciples.append("Philip");
        disciples.append("Bartholomew");
        disciples.append("Matthew");
        disciples.append("Thomas");
        disciples.append("James (son of Alphaeus)");
        disciples.append("Thaddaeus");
        disciples.append("Simon the Zealot");
        disciples.append("Judas Iscariot");
        disciples.print();

        // then removed the one who betrayed Jesus
        // see SinglyLinkedList lines 78 - 100 for my code
        disciples.remove("Judas Iscariot");
        disciples.print();

        // next we sort the disciples alphabetically
        // see SinglyLinkedList lines 129 - 171 for my code
        disciples.sort();
        disciples.print();

        // then printed the names in reverse order
        // see SinglyLinkedList lines 187 - 202 for my code
        disciples.printReverse();
    }
}
