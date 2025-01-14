import java.util.*;

class Queue{
int max;
int[] arr;
int front,rear;
int size=0;

public Queue(int s)
{ max=s;
front=0;
rear=-1;
arr=new int[max];
}

public void insert(int item){
if(!isFull()){
rear=(rear+1)%max;
arr[rear]=item;
size++;
}
else
System.out.println("Queue full");
}

boolean isFull(){
return size==max;
}
public void peek()
{ System.out.print(arr[front]); }
}
public class Queuearr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the queue:");
        int size = sc.nextInt();

        Queue queue = new Queue(size);

        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = sc.nextInt();
                    queue.insert(element);
                    break;
                case 2:
                    
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
