import java.util.Scanner;
public class Methods {
//    methods are just like a function().
//    if we don't write static in syntax of a method then we need to create an object to call it.
//    just like a scanner object in a main function --> Methods obj = new Methods();
    public static int logic(int a, int b){
        int c;
        if(a > b)
            c = a + b;
        else
            c = (a + b) * 5;
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter two numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("result : " + logic(a, b));
    }
}