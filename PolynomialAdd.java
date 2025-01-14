import java.util.Scanner;

class Link {
    int coeff; // Coefficient of the term
    int exp;   // Exponent of the term
    Link next;

    public Link(int coefficient, int exponent) {
        coeff = coefficient;  // No need for 'this' as the parameters are renamed
        exp = exponent;       // No conflict now, so 'this' is unnecessary
        next = null;
    }

    void displayLink() {
        System.out.print(coeff + "x^" + exp);
    }
}

class LinkList {
    Link first;

    public LinkList() {
        first = null;
    }

    // Insert term in descending order by exponent
    public void insertTerm(int coeff, int exp) {
        Link newLink = new Link(coeff, exp);
        if (first == null || first.exp < exp) {
            newLink.next = first;
            first = newLink;
        } else {
            Link current = first;
            while (current.next != null && current.next.exp >= exp) {
                current = current.next;
            }
            if (current.exp == exp) {
                current.coeff += coeff; // Combine terms with the same exponent
            } else {
                newLink.next = current.next;
                current.next = newLink;
            }
        }
    }

    // Add two polynomials represented as linked lists
    public static LinkList addPolynomials(LinkList poly1, LinkList poly2) {
        LinkList result = new LinkList();
        Link p1 = poly1.first;
        Link p2 = poly2.first;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                result.insertTerm(p2.coeff, p2.exp);
                p2 = p2.next;
            } else if (p2 == null) {
                result.insertTerm(p1.coeff, p1.exp);
                p1 = p1.next;
            } else if (p1.exp == p2.exp) {
                result.insertTerm(p1.coeff + p2.coeff, p1.exp);
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.exp > p2.exp) {
                result.insertTerm(p1.coeff, p1.exp);
                p1 = p1.next;
            } else {
                result.insertTerm(p2.coeff, p2.exp);
                p2 = p2.next;
            }
        }
        return result;
    }

    // Display the polynomial
    public void display() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
            if (current != null) {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }

    // Method to take user input for a polynomial
    public void inputPolynomial(Scanner scanner) {
        System.out.println("Enter terms of the polynomial (enter 0 for exponent to finish):");
        while (true) {
            System.out.print("Enter coefficient: ");
            int coeff = scanner.nextInt();
            System.out.print("Enter exponent: ");
            int exp = scanner.nextInt();
            if (exp == 0) break; // Stop when exponent is 0

            insertTerm(coeff, exp);
        }
    }
}

public class PolynomialAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Polynomial 1:");
        LinkList poly1 = new LinkList();
        poly1.inputPolynomial(scanner);

        System.out.println("Enter Polynomial 2:");
        LinkList poly2 = new LinkList();
        poly2.inputPolynomial(scanner);

        System.out.print("Polynomial 1: ");
        poly1.display();

        System.out.print("Polynomial 2: ");
        poly2.display();

        LinkList result = LinkList.addPolynomials(poly1, poly2);
        System.out.print("Resultant Polynomial: ");
        result.display();
        
        scanner.close();
    }
}
