/*
    Write an alogrithm or flowchart to find out strength of the password.

*/
public class passwordStrength {
    public static int checkAlpha(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                return 1;
            }
        }
        return 0;
    }

    public static int checkNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                return 1;
            }
        }
        return 0;
    }

    public static int checkSpecial(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c) && !Character.isAlphabetic(c)) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean checkLen(String str) {
        if (str.length() < 8) {
            return false;
            // System.exit(0);
        }
        return true;
    }

    /*
    public static void main(String[] args) {
        String pass = new String("Jayesh");
        String pass = new String("1234566789");
        String pass = new String("!#$%^&*()@");
        String pass = new String("Jayesh@#");
        String pass = new String("Jayesh11");
        String pass = new String("123456789@");
        String pass = new String("Jayesh1@gmail.com");
        System.out.println(pass);

        checkLen(pass);

        int al = checkAlpha(pass);
        // System.out.println(al);

        int num = checkNum(pass);
        // System.out.println(num);

        int sp = checkSpecial(pass);
        // System.out.println(sp);

        int sum = al + num + sp;
        if (sum == 3) {
            System.out.println("Excellent");
        } else if (sum == 2) {
            System.out.println("Moderate.");
        } else if (sum == 1) {
            System.out.println("Poor");
        } else {
            System.out.println("Please enter password...!!!!");
        }
    }
    */

    public static void main(String[] args) {
        String[] str = new String[] { "Jayesh", "JayeshSU", "1234566789", "!#$%^&*()@", "Jayesh@#", "Jayesh11", "123456789@",
                "Jayesh1@gmail.com" };

        for (int i = 0; i < str.length; i++) {
            System.out.println(i + 1 + " : " + str[i]);

            if (!checkLen(str[i])){
                System.out.println("--> Invalid !!! Password length must be more than 8.\n");
                continue;
            }

            int al = checkAlpha(str[i]);
            // System.out.println(al);

            int num = checkNum(str[i]);
            // System.out.println(num);

            int sp = checkSpecial(str[i]);
            // System.out.println(sp);

            int sum = al + num + sp;
            if (sum == 3) {
                System.out.println("--> Excellent");
            } else if (sum == 2) {
                System.out.println("--> Moderate.");
            } else if (sum == 1) {
                System.out.println("--> Poor");
            } else {
                System.out.println("--> Please enter password...!!!!");
            }
            System.out.println();
        }
    }
}