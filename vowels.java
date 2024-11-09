import java.util.*;

class Link
{
    String data;
    Link next;
    public Link(String d)
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

    public void insertfirst(String d)
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


public class vowels {
    public static void main(String st[])
    {
        int ca=0,ce=0,ci=0,co=0,cu=0;
        Scanner sc = new Scanner(System.in);
        LinkList x=new LinkList();
        System.out.println("Enter the string");
        String d=sc.nextLine();
       for(int i=0;i<d.length();i++)
       {
        char ch=d.charAt(i);
        x.insertfirst(String.valueOf(ch));
        switch(ch)
        {
            case 'a':
            case 'A':
            ca++;
            break;
            case 'e':
            case 'E':
            ce++;
            break;
            case 'i':
            case 'I':
            ci++;
            break;
            case 'o':
            case 'O':
            co++;
            break;
            case 'u':
            case 'U':
            cu++;
            break;
            
        }
       }
       System.out.println("count of each :\n"+ca  +ce  +ci  +co  +cu);

}
}
