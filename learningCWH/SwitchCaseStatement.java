import java.util.Scanner;
public class SwitchCaseStatement
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your age (18 or 23 or 50) : ");
        int age = sc.nextInt();
        System.out.println("\nsimple switch -->");
        switch (age)
        {
            case 18 :
            {
                System.out.println("You are going to become an Adult!");
                System.out.println("You are going to become an Adult!");
                System.out.println("You are going to become an Adult!");
            }break;
            case 23 : System.out.println("You are going to join a Job!");break;
            case 50 : System.out.println("You are going to get retired!");break;
            default : System.out.println("Enjoy Your life!");
        }

//        ENHANCED SWITCH -->
//        take your courser on switch then tap on enhanced switch then
//        the syntax would look like the code below
//        and this does not need a break statement.
        System.out.println("\nEnhanced switch -->");
        switch (age) {
            case 18 -> {
                System.out.println("You are going to become an Adult!");
                System.out.println("You are going to become an Adult!");
                System.out.println("You are going to become an Adult!");
            }
            case 23 -> System.out.println("You are going to join a Job!");
            case 50 -> System.out.println("You are going to get retired!");
            default -> System.out.println("Enjoy Your life!");
        }
        System.out.println("\nThanks for using my Java Code!");
    }
}
