package LabPractice;

import java.util.Scanner;

class Triangle {
    int a,b,c,area;

    void read(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of a triangle : ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        sc.close();
    }

    boolean check(){
        if((a+b)>c && (b+c)>a && (c+a)>b){
            if(a==b && b==c && c==a)
                System.out.println("Triangle is a Equilateral triangle.");
            else if(a==b || b==c || c==a)
                System.out.println("Triangle is Isoscles triangle.");
            else
                System.out.println("Triangle is a Scelene triangle.");
            return true;
        }
        else
            System.out.println("This is not a triangle.");
        return false;
    }

    void computeArea(){
        int s=(a+b+c)/2;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.out.println("The area of the triangle is : "+area);
    }
}

public class TW2 {
    public static void main(String args[]){
        Triangle t1 = new Triangle();
        t1.read();
        if(t1.check())
            t1.computeArea();
    }
}
