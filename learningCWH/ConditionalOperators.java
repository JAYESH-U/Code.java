import java.util.Scanner;
public class ConditionalOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your age : ");
        int age =  sc.nextInt();
        boolean cond = (age>18);
        if(cond)
        {
            System.out.println("Yes, you can drive!.");
        }
        else
        {
            System.out.println("No, you cannot drive yet!.");
        }
    }
}
