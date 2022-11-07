/*
Java program to encrypt a grade by adding 8 to it.
Decrypt it to show the correct grade.
*/

import java.util.Scanner;
public class GradeEncrypt_CWH_tut_12_questions1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the grade : ");
        char g = sc.next().charAt(0);

        //encoding
        g = (char) (g + 8);
        System.out.println(g);

        //decoding
        g = (char)(g - 8);
        System.out.println(g);
    }
}