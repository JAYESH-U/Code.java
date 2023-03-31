package LabPractice;

public class TW10 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            public void run(){
                System.out.println("Thread one is running.");
            }
        };

        Thread t1 = new Thread(r1);
        t1.run();

        Runnable r2 = ()->{
            System.out.println("Thread two is running.");
        };

        Thread t2 = new Thread(r2);
        t2.run();
    }
}
