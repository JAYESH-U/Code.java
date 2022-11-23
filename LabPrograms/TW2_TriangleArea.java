package LabPrograms;
import java.text.Format;
import java.util.Scanner;

class TW2_TriangleArea{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three sides of triangle : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a+b>c && a+c>b && b+c>a){
            Float s = (a+b+c)/2.0f;
            Double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
            if(a==b && a==c && c==b){
                System.out.println("This is an Equilateral Triangle.");
            }
            else if(a==b ||a==c || c==b){
                System.out.println("This is an Isoceles Triangle.");
            }
            else{
                System.out.println("This is an Scalene Triangle.");
            }
            System.out.printf("Area of triangle : %.3f", area);
        }
        else{
            System.out.println("This is not a triangle...!!!");
        }
    }
}