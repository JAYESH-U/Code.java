import java.util.Scanner;
public class ArraysSingleDimension {
    public static void main(String[] args) {
//        syntax --> dataType [] arrayName;

        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of subjects : ");
        int n = sc.nextInt();

        int [] marks = new int [n];

        System.out.println("enter marks of subjects :");
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            System.out.print("sub"+ (i+1) +" : ");
            marks[i] = sc.nextInt();
            sum += marks[i];
        }
        float avg = sum/(float)n;
        System.out.println("average marks is : "+avg);
        int [] marks1 = {20,40,40,10,30};
        int length = marks1.length;
        System.out.println("\narray length of marks1 : "+length);
    }
}
