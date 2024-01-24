package advJava.lab.TW4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;

public class ByteArrayInputOutputStream {
    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        try {
            InputStream f1 = new FileInputStream("advJava\\lab\\TW4\\BAIS.txt");
            OutputStream f2 = new FileOutputStream("advJava\\lab\\TW4\\BAIS1.txt");
            OutputStream f3 = new FileOutputStream("advJava\\lab\\TW4\\BAIS2.txt");

            byte[] array = new byte[100];
            f1.read(array);

            ByteArrayInputStream by = new ByteArrayInputStream(array);
            ByteArrayOutputStream byv = new ByteArrayOutputStream();
            ByteArrayOutputStream byc = new ByteArrayOutputStream();

            System.out.print("\nFile content is : ");
            String str = new String(array);
            System.out.println(str);

            int k;
            while ((k = by.read()) != -1) {
                if (set.contains((char)k)) {
                    byv.write(k);
                } else if (((k >= (int)'a') && k < (int)'z') || (k >= (int)'A' && k < (int)'Z')) {
                    byc.write(k);
                }
            }

            System.out.println("Consonets : " + byc);
            System.out.println("Vowels : " + byv);

            byv.writeTo(f2);
            byc.writeTo(f3);

            System.out.println();
            f1.close();
            f2.close();
            f3.close();
        } catch (Exception e) {
            System.out.println("Exception IO");
        }

    }
}



//there is no need for ByteArrayInputStream..

// import java.io.*;

// public class ByteArrayInputOutputStream {
//     public static void main(String[] args) {
//         try {
//             FileInputStream fileInputStream = new FileInputStream("advJava\\lab\\TW4\\BAIS.txt");
//             ByteArrayOutputStream vowelsOutputStream = new ByteArrayOutputStream();
//             ByteArrayOutputStream consonantsOutputStream = new ByteArrayOutputStream();

//             int data;
//             while ((data = fileInputStream.read()) != -1) {
//                 char character = (char) data;
//                 if (Character.isLetter(character)) {
//                     if (isVowel(character)) {
//                         vowelsOutputStream.write(data);
//                     } else {
//                         consonantsOutputStream.write(data);
//                     }
//                 }
//             }

//             // Write the vowels to a file
//             try (FileOutputStream vowelsFileOutputStream = new FileOutputStream("advJava\\lab\\TW4\\BAIS1.txt")) {
//                 vowelsFileOutputStream.write(vowelsOutputStream.toByteArray());
//             }

//             // Write the consonants to a file
//             try (FileOutputStream consonantsFileOutputStream = new FileOutputStream("advJava\\lab\\TW4\\BAIS2.txt")) {
//                 consonantsFileOutputStream.write(consonantsOutputStream.toByteArray());
//             }

//             System.out.println("Separation completed successfully.");

//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static boolean isVowel(char character) {
//         return "aeiouAEIOU".indexOf(character) != -1;
//     }
// }
