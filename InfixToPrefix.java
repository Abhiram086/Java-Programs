import java.util.Scanner;

class InfixToPrefix {

    // Custom stack implementation using an array
    static class Stack {
        int maxSize;
        int top;
        char[] stackArray;

        Stack(int size) {
            maxSize = size;
            top = -1;
            stackArray = new char[maxSize];
        }

        public void push(char value) {
            if (top < maxSize - 1) {
                stackArray[++top] = value;
            }
        }

        public char pop() {
            if (top >= 0) {
                return stackArray[top--];
            }
            return '\0';
        }

        public char peek() {
            if (top >= 0) {
                return stackArray[top];
            }
            return '\0';
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }

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
        return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'));
    }

    public static void reverse(char[] exp) {
        int start = 0, end = exp.length - 1;
        while (start < end) {
            char temp = exp[start];
            exp[start] = exp[end];
            exp[end] = temp;
            start++;
            end--;
        }
    }

    public static char[] infixToPrefix(char[] exp) {
        reverse(exp);
        int length = exp.length;
        Stack stack = new Stack(length);
        char[] result = new char[length];
        int k = 0;

        for (int i = 0; i < length; i++) {
            char ch = exp[i];

            if (isOperand(ch)) {
                result[k++] = ch;
            } else if (ch == ')') {
                stack.push(ch);
            } else if (ch == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result[k++] = stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == ')') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) < precedence(stack.peek())) {
                    result[k++] = stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result[k++] = stack.pop();
        }

        reverse(result);
        char[] finalResult = new char[k];
        System.arraycopy(result, 0, finalResult, 0, k);
        return finalResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        String expression = scanner.nextLine();
        char[] expArray = expression.toCharArray();
        char[] prefix = infixToPrefix(expArray);

        if (prefix != null) {
            System.out.print("Prefix expression: ");
            for (char c : prefix) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

