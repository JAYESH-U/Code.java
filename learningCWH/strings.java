import java.util.Scanner;
public class strings {
    public static void main(String[] args) {
        String name1 = new String("Jayesh"); //strings are immutable and cannot be changed.
        String name2 = "Uramanatti";
        System.out.println("My name is : " + name1 + " " + name2);  // println() -->java specific.
        System.out.printf("My name is : %s %s",name1,name2);    //printf() -->similar to c programming.
        System.out.println();
        Scanner sc = new Scanner(System.in);

        // System.out.print("enter your first name : ");
        // String name3 = sc.next();
        // System.out.println("your first name is : " + name3);

        System.out.print("enter your full name : ");
        String fullName = sc.nextLine();
        System.out.println("Your full name is : " + fullName);
    }
}