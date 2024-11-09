import java.util.*;
public class Sumeven {
    public static void main(String st[])
    {
      System.out.println("Enter the limit");
      Scanner sc = new Scanner(System.in);
      int n=sc.nextInt();
      int sum=0;
      for(int i=0;i<=n;i++)
      {
        sum=sum+i;
      }  
      System.out.println(sum);
    }
    
}
