package drive;

public class Node {
    public String Data;
    public Node NextNode;
    public Node PreviousNode;

    // Constructor with a null NextNode and PreviousNode
    public Node(String data) {
        this(data, null, null);
    }

    // Constructor with both data and NextNode
    public Node(String data, Node nextNode) {
        this(data, nextNode, null);
    }

    // Constructor with both data, NextNode, and PreviousNode
    public Node(String data, Node nextNode, Node previousNode) {
        this.Data = data;
        this.NextNode = nextNode;
        this.PreviousNode = previousNode;
    }
}
