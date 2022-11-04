import java.util.Scanner;
public class PercentageFiveSubs {
    public static void main(String[] args) {
        float a,b,c,d,e;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter marks of 5 subjects : ");
        a = in.nextFloat();
        b = in.nextFloat();
        c = in.nextFloat();
        d = in.nextFloat();
        e = in.nextFloat();
        System.out.println("percentage is : "+ ((a+b+c+d+e)/500.0)*100.0);
    }
}