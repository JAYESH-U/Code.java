package LabPrograms;

interface Prime {
    boolean isPrime(int num);
}

class PrimeTester implements Prime {
    int n;

    public boolean isPrime(int num) {
        for (int i = 2; i < num - 1; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

class ImprPrimeTester implements Prime {
    int n;

    public boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

class FasterPrimeTester implements Prime {
    int n;

    public boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

class FastestPrimeTester implements Prime {
    int n;

    public boolean isPrime(int num) {
        int i = 2;
        if (num == 1 || num == 2)
            return true;
        return ((Math.pow(i, num - 1) % num == 1));
    }
}

public class TW7_Interfaces {
    public static void main(String[] args) {
        PrimeTester p1 = new PrimeTester();
        ImprPrimeTester p2 = new ImprPrimeTester();
        FasterPrimeTester p3 = new FasterPrimeTester();
        FastestPrimeTester p4 = new FastestPrimeTester();

        System.out.println("61 is a prime number : " + p1.isPrime(61));
        System.out.println("17 is a prime number : " + p2.isPrime(17));
        System.out.println("29 is a prime number : " + p3.isPrime(29));
        System.out.println("7 is a prime number : " + p4.isPrime(7));
    }
}
