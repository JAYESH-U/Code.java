package LabPractice;

interface prime {
    boolean isPrime(int n);
}

class PrimeTester implements prime {
    public boolean isPrime(int n){
        for(int i=2;i<n-1;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}

class FastPrimeTester implements prime {
    public boolean isPrime(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}

class FasterPrimeTester implements prime {
    public boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}

class FastestPrimeTester implements prime {
    public boolean isPrime(int n){
        if(n==1 || n==2)
            return true;
        else 
            return((Math.pow(2,n-1)%n)==1);
    }
}

public class TW7 {
    public static void main(String[] args) {
        PrimeTester p1 = new PrimeTester();
        if(p1.isPrime(4))
            System.out.println("Prime");
        else
            System.out.println("Not-Prime");
        FastPrimeTester p2 = new FastPrimeTester();
        if(p2.isPrime(4))
            System.out.println("Prime");
        else
            System.out.println("Not-Prime");
        FasterPrimeTester p3 = new FasterPrimeTester();
        if(p3.isPrime(4))
            System.out.println("Prime");
        else
            System.out.println("Not-Prime");
        FastestPrimeTester p4 = new FastestPrimeTester();
        if(p4.isPrime(4))
            System.out.println("Prime");
        else
            System.out.println("Not-Prime");
    }
}
