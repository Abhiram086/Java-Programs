import java.util.*;

class Node {
    int data;
    Node lchild, rchild;

    public Node(int d) {
        data = d;
    }

    public void displayNode() {
        System.out.print(data + " ");
    }
}

public class Tree {
    public Node root;

    public Tree() {
        root = null;
    }

    public void insert(int d) {
        Node nl = new Node(d);
        if (root == null) {
            root = nl;
        } else {
            Node curr = root;
            Node parent;
            while (true) {
                parent = curr;
                if (d < curr.data) {
                    curr = curr.lchild;
                    if (curr == null) {
                        parent.lchild = nl;
                        return;
                    }
                } else {
                    curr = curr.rchild;
                    if (curr == null) {
                        parent.rchild = nl;
                        return;
                    }
                }
            }
        }
    }

    public void inOrder(Node lroot) {
        if (lroot != null) {
            inOrder(lroot.lchild);
            lroot.displayNode();
            inOrder(lroot.rchild);
        }
    }

    public void preOrder(Node lroot) {
        if (lroot != null) {
            lroot.displayNode();
            preOrder(lroot.lchild);
            preOrder(lroot.rchild);
        }
    }

    public void postOrder(Node lroot) {
        if (lroot != null) {
            postOrder(lroot.lchild);
            postOrder(lroot.rchild);
            lroot.displayNode();
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Insert Node");
            System.out.println("2. Display InOrder");
            System.out.println("3. Display PreOrder");
            System.out.println("4. Display PostOrder");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    tree.insert(value);
                    break;
                case 2:
                    System.out.print("InOrder Traversal: ");
                    tree.inOrder(tree.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("PreOrder Traversal: ");
                    tree.preOrder(tree.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("PostOrder Traversal: ");
                    tree.postOrder(tree.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
