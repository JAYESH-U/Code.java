//this loop is similar to while loop which runs at least one time.
//and then check the condition and run until the condition become false.

import java.util.Scanner;
public class DoWhileLoop
{
    public static void main(String[] args)
    {
        int a = 10,i = 1;
        do
        {
            System.out.println(a++);
        }while(a<=5);

        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number : ");
        int n = sc.nextInt();
        do{
            System.out.println(i++);
        }while(i<=n);
    }
}
