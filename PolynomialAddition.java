import java.util.Scanner;

class Node {
    int coef, exp;
    Node next;

    Node(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }
}

class Polynomial {
    Node head;

    public void insertTerm(int coef, int exp) {
        Node newNode = new Node(coef, exp);
        if (head == null || head.exp < exp) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.exp > exp) {
                current = current.next;
            }
            if (current.next != null && current.next.exp == exp) {
                current.next.coef += coef;
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public Polynomial add(Polynomial poly) {
        Polynomial result = new Polynomial();
        Node ptr1 = this.head, ptr2 = poly.head;

        while (ptr1 != null || ptr2 != null) {
            if (ptr1 == null) {
                result.insertTerm(ptr2.coef, ptr2.exp);
                ptr2 = ptr2.next;
            } else if (ptr2 == null) {
                result.insertTerm(ptr1.coef, ptr1.exp);
                ptr1 = ptr1.next;
            } else if (ptr1.exp > ptr2.exp) {
                result.insertTerm(ptr1.coef, ptr1.exp);
                ptr1 = ptr1.next;
            } else if (ptr1.exp < ptr2.exp) {
                result.insertTerm(ptr2.coef, ptr2.exp);
                ptr2 = ptr2.next;
            } else {
                int sumCoef = ptr1.coef + ptr2.coef;
                if (sumCoef != 0) {
                    result.insertTerm(sumCoef, ptr1.exp);
                }
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }

        return result;
    }

    public void printPolynomial() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Polynomial is empty.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.coef + "x^" + temp.exp);
            if (temp.next != null) {
                System.out.print(" + ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

public class PolynomialAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Polynomial poly1 = new Polynomial(), poly2 = new Polynomial();

        System.out.print("Enter number of terms for first polynomial: ");
        int n1 = scanner.nextInt();
        for (int i = 0; i < n1; i++) {
            System.out.print("Enter coefficient and exponent: ");
            poly1.insertTerm(scanner.nextInt(), scanner.nextInt());
        }

        System.out.print("Enter number of terms for second polynomial: ");
        int n2 = scanner.nextInt();
        for (int i = 0; i < n2; i++) {
            System.out.print("Enter coefficient and exponent: ");
            poly2.insertTerm(scanner.nextInt(), scanner.nextInt());
        }

        System.out.println("\nPolynomial 1:");
        poly1.printPolynomial();
        
        System.out.println("Polynomial 2:");
        poly2.printPolynomial();

        Polynomial result = poly1.add(poly2);
        System.out.println("Result of addition:");
        result.printPolynomial();
    }
}

