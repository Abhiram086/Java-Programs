import java.util.*;
public class Multiply {
    public static void main(String st[]){

        System.out.println("Enter two numbers for multiplication");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int result=mul(a,b);
        System.out.println(result);
        
    } 
    public static int mul(int a,int b)
    {
    int c=a*b;
    return c;
    }
}
