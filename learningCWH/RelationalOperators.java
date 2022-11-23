import java.util.Scanner;
public class RelationalOperators {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        boolean a = true;
        boolean b = false;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
//        Logical and operator &&
        System.out.print("a && b = ");
        if(a && b)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

//        Logical or operator ||
        System.out.print("a || b = ");
        if(a || b)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

//        Logical not operator !
        System.out.println("!a = " + !a);
        System.out.println("!b = " + !b);

    }
}