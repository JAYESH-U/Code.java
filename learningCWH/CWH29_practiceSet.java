import java.util.Random;
import java.util.Scanner;
public class CWH29_practiceSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Question 1 --> create an array of 5 floats and calculate their sum.
        System.out.println("\nQuestion 1 -->");
        float [] marks = {45.2f, 65.2f, 55.6f, 25.5f, 58.5f};
        float sum = 0;
        for(float element:marks)
        {
            sum += element;
        }
        System.out.println("sum of 5 floating point marks are : "+ sum);

//        Question 2 --> check whether a element is present in the array or not!.
        System.out.println("\nQuestion 2 -->");
        float [] marks1 = {45.2f, 65.2f, 55.6f, 25.5f, 58.5f};
        float num = 55.9f;
        boolean IsInArray = false;
        for(float element:marks1)
        {
            if(num==element)
            {
                IsInArray = true;
            }
        }
        if(IsInArray) {
            System.out.println("the value is present in the array.");
        }
        else {
            System.out.println("the value is not present in the array.");
        }

//        Question 3--> Calculate the average marks of the students.
        System.out.println("\nQuestion 3 -->");
        float [] marksP = {45.2f, 65.2f, 55.6f, 25.5f, 58.5f};
        float sumP = 0;
        for(float element:marksP)
        {
            sumP += element;
        }
        System.out.println("average of 5 floating point marks are : "+ sumP/ marksP.length);

//        Question 4 --> add two matrices od size 2x3.
        System.out.println("\nQuestion 4 -->");
        System.out.println("sum of two matrices : ");
        int [][] mat1 = {{1,2,3},{4,5,6}};
        int [][] mat2 = {{7,8,9},{3,5,1}};
        int [][] result = {{0,0,0},{0,0,0}};
        for(int i=0;i<mat1.length;i++)
        {
            for(int j=0;j<mat1[i].length;j++)
            {
                result[i][j] = mat1[i][j] + mat2[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }

//        Question 5 --> reverse an array.
        System.out.println("\nQuestion 5 -->");
        int [] RArr = {1,2,3,4,5,6,7,8,9,0};
//        Math.floorDiv --> gives remainder without any decimals.
        int a = Math.floorDiv(RArr.length,2);
        int l = RArr.length;
        for(int i=0;i<a;i++)
        {
            int temp = RArr[i];
            RArr[i] = RArr[l-i-1];
            RArr[l-i-1] = temp;
        }
        for(int element:RArr)
        {
            System.out.print(element + " ");
        }

//        Question 6 --> Find maximum element of array.
        System.out.println("\n\nQuestion 6 -->");
        int [] Arr = {1,2,3,4,5,6,7,8,9,0};
        int max = Arr[0];
        for(int element:Arr)    //if(int e: arr) -->same
        {
            if(element>max)
            {
                max = element;
            }
        }
        System.out.println("maximum number in an array : "+ max);

//        Question 7 --> minimum element of array.
        System.out.println("\nQuestion 7 -->");
        int min = Arr[0];
        for(int element:Arr)    //if(int e: arr) -->same
        {
            if(element<min)
            {
                min = element;
            }
        }
        System.out.println("min number in an array : "+ min);

//        Question 8 --> find whether array is sorted or not.
        System.out.println("\nQuestion 8 -->");
        int[] SArr = {1,4,653,234,65,7,345,7};
        boolean isSorted = true;
        for(int i=0;i<SArr.length;i++)
            if(SArr[i+1]<SArr[i]) {
                isSorted = false;
                break;
            }
        if(isSorted)
            System.out.println("The array is sorted!.");
        else System.out.println("The array is not sorted!.");
    }
}