public class Literals {
    public static void main(String[] args) {
        byte age = 34; // set default
        int age2 = 56; // ,,
        short age3 = 87; // ,,
        long ageDino = 5666666666666L; // L(by default it is set to int type)
        char ch = 'A'; // set default and (' ')--> char literal
        float f1 = 5.6f; // set double by default (to set it to float add 'f' or 'F')
        double d1 = 4.66; // set double by default (d or D)
        boolean a = true; // true or false -->boolean literal
        System.out.println("age = " + age);
        System.out.println("age2 = " + age2);
        System.out.println("age3 = "+ age3);
        System.out.println("ageDino = " + ageDino);
        System.out.println("ch = " + ch);
        System.out.println("f1 = " + f1);
        System.out.println("d1 = " + d1);
        System.out.println("a = " + a);
        String str = "Harry"; // " " --> string literal
        System.out.println(str);
    }
}