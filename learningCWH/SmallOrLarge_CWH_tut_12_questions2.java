/*
comparison operator to find out whether the given number is greater than
the user entered number ot not.
 */
import java.util.Scanner;
public class SmallOrLarge_CWH_tut_12_questions2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("enter a number : ");
        int a = sc.nextInt();
        System.out.println("the user entered number is larger : " + (a>8));
    }
}