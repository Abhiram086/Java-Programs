class queue
{
    int max;
    int []arr;
    int front;
    int rear;

    public queue(int s)
    {
        max=s;
        front=0;
        rear=-1;
        arr=new int[max];
    }
    public void insert(int item)
    {
        rear=(rear+1)%max
        arr[rear]=item;
        

    }
    public int delete()
    {
        int temp=arr[front];
        front=(front+1)%max;
        return temp;
    }
    public boolean isfull()
    {
        if((rear+2)%max==front)
        {
            return temp;
        }
        else return false;
   }
   public boolean isempty()
   {
    if(front==(rear+1)%max)
    {
        return true;
    }
    else return false;
   }
}



public class cicularqueue {
    
}
