import java.util.Scanner;
public class Pattern {
    public static void main(String st[])
    {
        System.out.println("Printing the pattern, Enter the number of rows needed");
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    
}
