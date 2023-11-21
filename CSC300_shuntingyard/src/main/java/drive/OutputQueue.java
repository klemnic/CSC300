package drive;

public class OutputQueue extends Queue {

    private Node front;
    private Node rear;

    public OutputQueue() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public void enqueue(String data) {
        Node newNode = new Node(data, null);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.NextNode = newNode;
            rear = newNode;
        }
    }

    @Override
    public Node dequeue() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Queue is empty");
        }

        Node removedNode = front;
        front = front.NextNode;

        if (front == null) {
            rear = null;
        }

        return removedNode;
    }

    @Override
    public Node peek() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Queue is empty");
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int getLength() {
        int length = 0;
        Node current = front;
        while (current != null) {
            length++;
            current = current.NextNode;
        }
        return length;
    }
}
