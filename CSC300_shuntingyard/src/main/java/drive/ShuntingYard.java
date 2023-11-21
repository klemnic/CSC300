package drive;

public class ShuntingYard {
    public LinkedList Tokens;
    public OutputQueue ReversePolish;

    public ShuntingYard() {
        this.Tokens = new LinkedList();
        this.ReversePolish = new OutputQueue();
    }

    // Parse a math expression into a linked list
    // Input: the math expression as a string
    // Parsed result will be stored in Tokens linked list
    public void parse(String input) {
        OpStack operatorStack = new OpStack();
        boolean lastWasNum = false;
        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);

            if (currentChar == '(') {
                operatorStack.push(Character.toString(currentChar));
                lastWasNum = false;
            } else if (currentChar == ')') {
                // Pop operators from the stack and append to ReversePolish until an opening parenthesis is encountered
                while (!operatorStack.isEmpty() && operatorStack.peek().Data.charAt(0) != '(') {
                    ReversePolish.enqueue(" ");
                    ReversePolish.enqueue(operatorStack.pop().Data.toString());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek().Data.charAt(0) == '(') {
                    operatorStack.pop(); // Discard the '('
                }
                lastWasNum = false;
            } else if (currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-') {
                // Pop operators from the stack and append to ReversePolish until the stack is empty or
                // the top operator has lower precedence than the current operator
                while (!operatorStack.isEmpty() && ShuntingYard.getPrecedence(operatorStack.peek().Data) >= ShuntingYard.getPrecedence(Character.toString(currentChar))) {
                    ReversePolish.enqueue(" ");
                    ReversePolish.enqueue((operatorStack.pop().Data));
                }
                operatorStack.push(Character.toString(currentChar));
                lastWasNum = false;
            } else {
                // Operand
                if (!lastWasNum) {
                    ReversePolish.enqueue(" ");
                }
                ReversePolish.enqueue(currentChar.toString());
                lastWasNum = true;
            }
        }

        while (!operatorStack.isEmpty()) {
            ReversePolish.enqueue(operatorStack.pop().toString());
            ReversePolish.enqueue(" ");
        }

        while (!ReversePolish.isEmpty()) {
            System.out.println(ReversePolish.dequeue().Data);
        }
    }

    public void process() {
        Node tempNode = this.Tokens.Head;
        OpStack operatorStack = new OpStack();

        while (tempNode != null) {
            String token = tempNode.Data;

            if (token.matches("0|1|2|3|4|5|6|7|8|9")) {
                this.ReversePolish.enqueue(token); // If it's a number, add it directly to the output queue
            } else if (token.matches("\\+|-|/|\\*")) {
                // If it's an operator
                while (!operatorStack.isEmpty() && ShuntingYard.hasHigherPrecedence(operatorStack.peek().Data, token)) {
                    this.ReversePolish.enqueue(operatorStack.pop().Data); // Pop higher precedence operators to output queue
                }
                operatorStack.push(token); // Push current operator onto the stack
            } else if (token.equals("(")) {
                operatorStack.push(token); // If it's a left bracket, push it onto the stack
            } else if (token.equals(")")) {
                // If it's a right bracket
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    this.ReversePolish.enqueue(operatorStack.pop().Data); // Pop operators to output until left bracket
                }
                operatorStack.pop(); // Discard the left bracket
            }

            tempNode = tempNode.NextNode;
        }

        while (!operatorStack.isEmpty()) {
            this.ReversePolish.enqueue(operatorStack.pop().Data); // Pop any remaining operators to output
        }
    }

    public static boolean hasHigherPrecedence(String op1, String op2) {
        int precedenceOp1 = getPrecedence(op1);
        int precedenceOp2 = getPrecedence(op2);

        return precedenceOp1 >= precedenceOp2;
    }

    private static int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0; // If it's not a recognized operator, assign the lowest precedence
        }
    }

    public int run() {
        OpStack tempstack = new OpStack();
        String s = "*+/-";

        while (!ReversePolish.isEmpty()) {
            Node tempNode = ReversePolish.dequeue();
            if (tempNode != null && tempNode.Data != null) {
                String temp = tempNode.Data;

                if (temp.indexOf(s) >= 0) {
                    if (tempstack.getLength() < 2) {
                        System.err.println("Error: Insufficient operands for operation. Stack content: " + tempstack.toString());
                        return 0; // or handle the error in an appropriate way
                    }

                    int x = Integer.parseInt(tempstack.pop().Data);
                    int y = Integer.parseInt(tempstack.pop().Data);

                    switch (temp.charAt(0)) {
                        case '*':
                            tempstack.push(Integer.toString(y * x));
                            break;
                        case '+':
                            tempstack.push(Integer.toString(y + x));
                            break;
                        case '/':
                            tempstack.push(Integer.toString(y / x));
                            break;
                        case '-':
                            tempstack.push(Integer.toString(y - x));
                            break;
                        default:
                            System.err.println("Error: Unknown operator.");
                            return 0; // or handle the error in an appropriate way
                    }
                } else {
                    tempstack.push(temp);
                }
            } else {
                System.err.println("Error: Unable to process. Missing operand(s).");
                return 0; // or handle the error in an appropriate way
            }
        }

        if (tempstack.getLength() == 1) {
            return Integer.parseInt(tempstack.pop().Data);
        } else {
            System.err.println("Error: Too many operands on the stack. Stack content: " + tempstack.toString());
            return 0; // or handle the error in an appropriate way
        }
    }



}


