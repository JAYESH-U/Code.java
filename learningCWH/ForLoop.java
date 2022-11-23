import java.util.Scanner;
public class ForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number : ");
        int n = sc.nextInt();
//        2n = 0,2,4,6.... --> even num.
//        2n+1 = 1,3,5,7..... --> odd num.
        System.out.println(n +" even numbers are : ");
        for (int i = 0;i<=n;i++)
        {
            System.out.print(2*i + " ");
        }
        System.out.println("\n");
        System.out.println(n +" odd numbers are : ");
        for (int i = 0;i<=n;i++)
        {
            System.out.print(2*i+1 + " ");
        }
    }
}
