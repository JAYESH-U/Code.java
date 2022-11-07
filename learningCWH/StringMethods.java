import java.util.Locale;
import java.util.Scanner;
public class StringMethods
{
    public static void main(String[] args)
    {
        String name = "Jayesh";     //existing string cannot be changed.
        System.out.println("name : " + name);

        //        length of the string.
        int len = name.length();    //create a new string to modify the existing string and store them.
        System.out.println("length : " + len);

        //        lowercase of the string.
        String lString = name.toLowerCase();
        System.out.println("Lowercase : " + lString);

        //        uppercase of the string
        String uString = name.toUpperCase();
        System.out.println("Uppercase : " + uString);

        //        Trimming the string --> this removes the spaces in string.
        String nonTrimmedString = "      Jayesh     ";
        System.out.println("NonTrimmedString : " + nonTrimmedString);
        String trimmedString = nonTrimmedString.trim();
        System.out.println("TrimmedString : " + trimmedString);

        //        Substring --> print the characters from that index.
        System.out.println("Substring from index 2 : " + name.substring(2));
        System.out.println("Substring from index 1 to 5 : " + name.substring(1,5));

        //        replce --> replaces the character with other character.
        System.out.println("Replace 'a' with 'e' : " + name.replace('a', 'e'));
        System.out.println("Replace 'aye' with 'eya' : " + name.replace("aye", "eya"));

        //        starts with and ends with --> gives boolean output.
        System.out.println("Is name starting with 'jay'?? : " + name.startsWith("jay"));
        System.out.println("Is name ending with 'esh'?? : " + name.endsWith("esh"));

        //        charAt() -->retutns the character at a given index position.
        System.out.println("The character present at index 4 : " + name.charAt(4));

        //        indexOf() --> return the index of the given character or a string.
        System.out.println("index of 'a' in the string name : " + name.indexOf('a'));
        System.out.println("index of 'aye' in the string name is : " + name.indexOf("aye"));

        //        indexOf("str","index") --> return the index of the character or a string which is present after the index number.
        //        if the string not present in the given index then it will return -1
        System.out.println();
        String modName = "Jayeeaash";
        System.out.println("modified name : " + modName);
        System.out.println("Index of 'a' in the string modified sting name2 from index 5 : "+ modName.indexOf('a',6));

        //        lastIndexOf() --> this will give the index of the last same character.
        System.out.println("the last index of a in modName : " + modName.lastIndexOf('a'));
        System.out.println("the last index of y in modName present before index 5 : " + modName.lastIndexOf('y',5));

        //        equals("str") --> returns true if the given string is equal to "str", false otherwis
        System.out.println("is 'Jayesh' similar to name : " + name.equals("Jayesh"));
        System.out.println("is 'jaYeSH' similar to name ignoring the cases : " + name.equalsIgnoreCase("jaYeSH"));

        //        "\n" , "\t" --> works similar as in c language.
        //        "\"" or "\'" -->escapes the sequence.
        System.out.println("i am escape sequence \" charactor ");
    }
}
/*
        \t	Insert a tab in the text at this point.
        \b	Insert a backspace in the text at this point.
        \n	Insert a newline in the text at this point.
        \r	Insert a carriage return in the text at this point.
        \f	Insert a form feed in the text at this point.
        \'	Insert a single quote character in the text at this point.
        \"	Insert a double quote character in the text at this point.
        \\	Insert a backslash character in the text at this point.
*/
