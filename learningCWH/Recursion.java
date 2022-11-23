import java.util.Scanner;
public class Recursion {
    //factorial = 1*2*3*4*5*6*7*8.....
    public static int factorial(int n)
    {
        if(n==1 || n==0)
            return 1;
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number : ");
        int n = sc.nextInt();
        System.out.println("factorial of " + n + " is " + factorial(n));
    }
}
