import java.util.*;


class link{
int data;
link next;

public link(int d)
{
data=d;
next=null;}

void display(){
System.out.print(data);
}};

class linkl{
link first;
public linkl(){
first=null;
}
public void insertfirst(int data){
link ob=new link(data);
ob.next=first;
first=ob;
}

public boolean isEmpty(){
return first==null;
}

public int sum(){
int sum=0;
link curr=first;

while(curr!=null){
sum+=curr.data;
curr=curr.next;
}
return sum;
}
public void displays()
{
link curr=first;
while(curr!=null){
curr.display();
curr=curr.next;
}
}
};


public class sumofdigit{
public static void main(String st[]){
Scanner sc=new Scanner(System.in);

linkl x=new linkl();

System.out.println("Enter the number");
int num=sc.nextInt();

while(num>0)
{
int digit=num%10;
x.insertfirst(digit);
num/=10;
}
x.displays();
int sum=x.sum();

while(sum>9){
int temp=0;
while(sum>0){
temp=temp+sum%10;
sum=sum/10;
}
sum=temp;
}
System.out.println("sum is"+ sum);
}
}

