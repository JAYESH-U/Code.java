import java.util.Scanner;
public class CWH25_practiceSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Question 1 --> print a star triangle upside down(right triangle)
        System.out.println("Question 1 -->");
        for(int i=4;i>0;i--)
        {
            for(int j=i;j>0;j--)
                System.out.print("* ");
            System.out.println();
        }

//        Question 2 --> Sum of first n even numbers using while loop.
        System.out.println("Question 2 -->");
        int sum = 0,i=0;
        System.out.println("enter a number of even numbers : ");
        int n = sc.nextInt();
        while(i<=n)
        {
            sum += 2*i;
            i++;
        }
        System.out.println("Sum of first n numbers : " + sum);

//        Question 3 --> Multiplication table of given number.
        System.out.println("Question 3 -->");
        System.out.println("enter a number : ");
        int m = sc.nextInt();
        for(int L=1;L<=10;L++)
        {
            System.out.printf("%d * %d = %d\n",m,L,m*L);
        }

//        Question 4 --> Multiplication table of 10 in reverse order.

        System.out.println("Question 4 -->");
        int m10 = 10;
        System.out.println("Multiplication table of 10 in reverse order : ");
        for(int O=10;O>0;O--)
        {
            System.out.printf("%d * %d = %d\n",m,O,m10*O);
        }

//        Question 5 --> Factorial of n numbers.
        System.out.println("Question 5 -->");
        System.out.println("enter a number to find factorial of n numbers : ");
        int f = sc.nextInt();
        int fact = 1;
        for(int J=1;J<=f;J++)
        {
            fact *= J;
        }
        System.out.println("factorial of n number is : " + fact);

//        Question 6 --> repeat using while loop.
//        Question 7 --> Repeat 1 using for/while loop.
//        Question 8 -->What can be done using one loop that can be done using other two loops -->true
//
//        Question 9 --> calculate the sum of numbers occurring in the multiplication table of 8.
        System.out.println("Question 9 -->");
        int m8 = 8,summ=0;
        System.out.print("sum of elements in Multiplication table of 8 : ");
        for(int K=10;K>0;K--)
        {
            summ += m8*K;
        }
        System.out.println(summ);

//        Question 10 --> do While loop is executed atleast one time.

    }
}
