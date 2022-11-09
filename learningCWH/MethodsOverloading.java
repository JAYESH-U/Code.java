import java.util.Scanner;
public class MethodsOverloading {
    public static void morn()
    {
        System.out.println("Good morning bro..");
    }
    public static void morn(int a)
    {
        System.out.println("Good morning " + a + " bro..");
    }
    public static void morn(float a)
    {
        System.out.println("Good morning " + a + " bro..");
    }
    public static void morn(String a)
    {
        System.out.println("Good morning " + a + " bro..");
    }
    public static void morn(float a, int b)
    {
        System.out.println("Good morning " + (a+b) + " bro..");
    }
    public static void morn(int a, float b)
    {
        System.out.println("Good morning " + (a+b) + " bro..");
    }

//    public static void change(int a)
//    {
//        a = 98;
//    }
//    public static void change2(int [] a)
//    {
//        a[0] = 98;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
////        changing an integer.
//        int x = 45;
//        change (x);
//        System.out.println("the value of x using x : "+ x);
//
////        changing the array.
//        int [] arr = { 52,73,77,89,98,94};
//        change2(arr);
//        System.out.println("the value of a[0] after running the change is : " + arr[0]);

//        Method overloading.
        morn();
        morn(20);
        morn(20.2f);
        morn(30.3f,40);
        morn(50,40.4f);
        morn("Jayesh");
    }
}
