import java.util.*;

class Dlink{
Dlink next;
Dlink prev;
String data;

public Dlink(String d){
data=d;
next=prev=null;

}

public void display(){
System.out.print(data);
}

};

class Dll{
Dlink first,last;

public Dll(){
first=last=null;
}

public void insertlast(String d){
Dlink ob=new Dlink(d);

 if (first == null) { // If the list is empty
        first = last = ob;
    } else {
        ob.prev = last;
        last.next = ob;
        last = ob;
    }
}

public void deleten(int n){
Dlink curr=first;
int temp=1;
while(temp!=n){
curr=curr.next;
temp++;
}
curr.prev.next=curr.next;
curr.next.prev=curr.prev;
}
public void displayList() {
    Dlink curr = first; // Start from the first node
    while (curr != null) { // Traverse until the end of the list
        curr.display(); // Display the data of the current node
        curr = curr.next; // Move to the next node
    }
    System.out.println(); // Print a newline after displaying all nodes
}


}
public class doubly{
public static void main(String st[]){
Scanner sc=new Scanner(System.in);
Dll x=new Dll();
System.out.println("Enter a string");
String str=sc.nextLine();
for(int i=0;i<str.length();i++){
x.insertlast(String.valueOf(str.charAt(i)));
}
System.out.println("Enter n");
int n=sc.nextInt();

x.deleten(n);
System.out.println("List after deletion:");
x.displayList();

}
}
