public class ArrStack {
    private int max;
    private int arr[];
    private int top;

    public ArrStack(int s)
    {
        max=s;
        arr = new int [max];
        top=-1;
    }
    public void push(int item)
    {
        top++;
        arr[top]=item;

    }
    public int pop()
        {
            int temp;
            temp=arr[top];
            top--;
            return temp;
        }
    
    public boolean isEmpty()
    {
        if(top==-1)
        return true;
        else 
        return false;
    }
    public int peek()
    {
        return arr[top];

    }
    public boolean isFull()
    {
        if(top==max-1)
        return true;
        else
        return false;
    }

};
public class Functions()
{
    public static void main(String st[])
    {
     ArrStack x=new ArrStack(5);
     if(x.isFull()==false)
     {
        x.push(25);
     }
    }
}
