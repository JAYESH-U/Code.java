public class CWH15_practiceSet_q1 {
    public static void main(String[] args) {
        //Problem 1
        String name = "JayEsh";
        name = name.toLowerCase();
        System.out.println(name);       //cannot change the string but can modify it.
        
        //Problem 2
        String text = "To my friend.";
        text = text.replace("my", "his");
        System.out.println(text);

        // Problem 3
        String letter = "Dear <|name|>, Thanks a lot!";
        letter = letter.replace("<|name|>", "Sachin");
        System.out.println(letter);

        // Problem 4
        String myString = "This string contains double and  triple spaces";
        System.out.println(myString.indexOf("  "));
        System.out.println(myString.indexOf("   "));

        // Problem 5
        String myLetter = "Dear Harry,\n\tThis Java Course is Nice.\nThanks!";
        System.out.println(myLetter);
    }    
}