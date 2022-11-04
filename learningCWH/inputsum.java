import java.util.Scanner;
public class inputsum {
    public static void main(String[] args) {
        System.out.println("Taking input from the user : ");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number 1 : ");
        int a = sc.nextInt();
        
        System.out.println("Enter a number 2 : ");
        int b = sc.nextInt();
        
        System.out.println("the sum of these two number is : "+ (a+b));
        
        System.out.println("Enter your name : ");
        String name = sc.next();    //sc.nextLine -->accepts the full line.
        System.out.println("My name is : "+ name);
        
        System.out.println("Enter the number to check wheather it is a integer or not : ");
        boolean b1 = sc.hasNextInt();
        System.out.println(b1);
    }
}