package advJava.classroom;

public class MyThreadT extends Thread {
    int i;

    MyThreadT(int i) {
        this.i = i;
    }

    public void run() {
        for (int c = 0; c < 10; c++) {
            System.out.println(i);
        }
    }
}

class MyThreadDemo {
    public static void main(String[] args) {
        MyThreadT t1 = new MyThreadT(1);
        MyThreadT t2 = new MyThreadT(2);
        MyThreadT t3 = new MyThreadT(3);

        // //won't mix up the thread ouputs (serial execution)
        // t1.run();
        // t2.run();
        // t3.run();
        
        
        //mix up the thread ouputs
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main ends");
    }
}