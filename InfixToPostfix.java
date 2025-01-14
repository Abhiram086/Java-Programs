import java.util.Scanner;

class Stack {
    int maxSize;
    int top;
    char[] stackArray;

    Stack(int size) {
        maxSize = size;
        top = -1;
        stackArray = new char[maxSize];
    }

    public void push(char value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
        } else {
            stackArray[++top] = value;
        }
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return '\0';
        } else {
            return stackArray[top--];
        }
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

public class InfixToPostfix {
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    public static char[] infixToPostfix(char[] exp) {
        int length = exp.length;
        Stack stack = new Stack(length);
        char[] result = new char[length];
        int k = 0;

        for (int i = 0; i < length; i++) {
            char ch = exp[i];

            if (isOperand(ch)) {
                result[k++] = ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result[k++] = stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.println("Invalid Expression");
                    return null;
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result[k++] = stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                System.out.println("Invalid Expression");
                return null;
            }
            result[k++] = stack.pop();
        }

        char[] finalResult = new char[k];
        for (int i = 0; i < k; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        String expression = scanner.nextLine();

        char[] expArray = expression.toCharArray();

        char[] postfix = infixToPostfix(expArray);

        if (postfix != null) {
            System.out.print("Postfix expression: ");
            for (int i = 0; i < postfix.length; i++) {
                System.out.print(postfix[i]);
            }
            System.out.println();
        }
    }
}

