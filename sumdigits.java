import java.util.*;

class Link
{
    int data;
    Link next;
    public Link(int d)
    {
        data=d;
        next=null;
    }
    void displaylink()
    {
        System.out.print(data);
    }
}
class LinkList
{
    Link first;

    public LinkList()
    {
        first=null;
    }

    public void insertfirst(int d)
    {
        Link ob=new Link(d);
        ob.next=first;
        first=ob;
    }
    public boolean isEmpty()
    {
        if(first==null)
        {
            return true;
        }
        else
        return false;
    }
    public int sumofdigits()
    {
        Link curr=first;
        int sum=0;
        while(curr!=null)
        {
            sum=sum+curr.data;
            curr=curr.next;
        }
        return sum;
    }
    public void display()
    {
        Link curr=first;
        while(curr!=null)
        {
            curr.displaylink();
            curr=curr.next;
        }
    }
}



public class sumdigits {
    public static void main(String st[])
    {
        LinkList x=new LinkList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int number=sc.nextInt();

        while(number>0)
        {
            int digit=number%10;
            x.insertfirst(digit);
            number=number/10;
        }
        x.display();
        int sum=x.sumofdigits();
        while(sum>9)
        {
            int temp=0;
            while(sum>0)
            {
                temp=temp+sum%10;
                sum=sum/10;
            }
            sum=temp;
        }
        System.out.println("sum is:"+sum);

    }
}
