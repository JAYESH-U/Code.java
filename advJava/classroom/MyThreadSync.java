package advJava.classroom;

class MyPrinter {

    // syncronized will not let other to enter into critical section (learn in OS)
    public synchronized void print10(int value) {
        for (int i = 0; i < 10; i++) {
            System.out.print(value);
        }
        System.out.println(""); // new line after 10
    }

    // public void print10(int value) {
    // for (int i = 0; i < 10; i++) {
    // System.out.print(value);
    // }
    // System.out.println(""); // new line after 10
    // }
}

class MyThreadSync extends Thread {
    int i;
    MyPrinter p;

    MyThreadSync(int i, MyPrinter p) {
        this.i = i;
        this.p = p;
        // p = new MyPrinter(); //each threads having their own resorurces so
        // syncronization has no effect on them.
    }

    public void run() {
        for (int c = 0; c < 10; c++) {
            p.print10(i);
        }
    }
}

class MyTreadDemo {
    public static void main(String[] args) {
        MyPrinter p = new MyPrinter(); // each threads having only one resorurce so syncronization has effect on them.

        MyThreadSync t1 = new MyThreadSync(1, p);
        MyThreadSync t2 = new MyThreadSync(2, p);
        MyThreadSync t3 = new MyThreadSync(3, p);

        // t1.run();
        // t2.run();
        // t3.run();

        // to syncronize the threads they must point to only one resource.
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main ends");
    }
}