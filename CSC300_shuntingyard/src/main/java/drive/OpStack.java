package drive;

public class OpStack extends Stack {
    private String Ops = "+-*/";
    private char leftParenthesis = '(';
    private char rightParenthesis = ')';

    @Override
    public void push(String data) {
        if (data != null) {
            Node newNode = new Node(data);
            if (this.Head == null) {
                this.Head = newNode;
            } else {
                newNode.NextNode = this.Head;
                this.Head.PreviousNode = newNode;
                this.Head = newNode;
            }
        }
    }

    @Override
    public Node pop() {
        if (this.Head != null) {
            Node result = this.Head;
            this.Head = this.Head.NextNode;
            if (this.Head != null) {
                this.Head.PreviousNode = null;
            }
            result.NextNode = null;
            return result;
        }
        return null;
    }

    @Override
    public Node peek() {
        return this.Head;
    }
}
