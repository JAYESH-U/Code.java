import java.util.Scanner;
public class ForEachLoopInJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        array length
        int [] arr = {1,2,3,4,5};
        System.out.println("length of th array is : "+ arr.length);

//        display array elements using loops.
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+ " ");
        }

//        for each loop in java.
        System.out.println("\nprinting using for each loop.");
        for(int element: arr)
        {
            System.out.print(element+ " ");
        }
    }
}
