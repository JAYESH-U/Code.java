class Stack {
    int top;
    int size;
    int[] stack;

    Stack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    synchronized void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack is full");
        } else {
            top++;
            stack[top] = data;
            System.out.println("pushed element is " + stack[top]);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    synchronized void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("popped element is " + stack[top--]);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(stack[top]);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
        }
    }
}

class pushThread extends Thread {
    Stack s;
    String name;
    int ele;

    pushThread(String name, Stack s, int ele) {
        this.s = s;
        this.name = name;
        this.ele = ele;
    }

    @Override
    public void run() {
        s.push(ele);
    }
}

class popThread extends Thread {
    Stack s;
    String name;

    popThread(String name, Stack s) {
        this.s = s;
        this.name = name;
    }

    @Override
    public void run() {
        s.pop();
    }
}

public class StackOperations {
    public static void main(String[] args) {
        Stack s = new Stack(10);
        pushThread pu1 = new pushThread("pu1", s, 10);
        pushThread pu2 = new pushThread("pu2", s, 20);
        pushThread pu3 = new pushThread("pu3", s, 30);
        pushThread pu4 = new pushThread("pu4", s, 40);
        pushThread pu5 = new pushThread("pu5", s, 50);
        pushThread pu6 = new pushThread("pu6", s, 60);
        pushThread pu7 = new pushThread("pu7", s, 70);
        pushThread pu8 = new pushThread("pu8", s, 80);
        pushThread pu9 = new pushThread("pu9", s, 90);
        pushThread pu10 = new pushThread("pu10", s, 100);

        popThread po1 = new popThread("po1", s);
        popThread po2 = new popThread("po2", s);
        popThread po3 = new popThread("po3", s);
        popThread po4 = new popThread("po4", s);
        popThread po5 = new popThread("po5", s);

        pu1.start();
        pu2.start();
        pu3.start();
        pu4.start();
        pu5.start();
        pu6.start();
        pu7.start();
        pu8.start();
        pu9.start();
        pu10.start();

        po1.start();
        po2.start();
        po3.start();
        po4.start();
        po5.start();

        // s.display();
    }
}