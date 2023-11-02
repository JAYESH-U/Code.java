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

    public static void main(String[] args) {
        String pass = new String("Jayesh@gmail.com");
        // System.out.println(pass);

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
}