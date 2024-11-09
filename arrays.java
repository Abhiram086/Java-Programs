import java.util.*;
public class arrays {
    public static void main(String st[]){

        int ar[]=new int[100];
        System.out.println("Enter the array elements");
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<=5;i++)
        {

        ar[i]=sc.nextInt();
        }
        for(int i=0;i<=5;i++)
        {
            System.out.print(ar[i]+",");
        }

    }
    
}
