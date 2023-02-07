package LabPrograms;

class stack {
    int[] a;
    int top;
/* 
    public stack(int size) {
    a = new int[size];
    this.top = -1;
    }
*/
    void initStack(int size) {
        a = new int[size];
        top = -1;
    }

    void initStack(stack s) {
        a = new int[s.top + 1];
        top = -1;
        int i = 0;
        for (int ele : s.a) {
            if (s.top + 1 == i++)
                break;
            push(ele, s.top);
        }
    }

    void initStack(int[] arr) {
        a = new int[arr.length];
        top = -1;
        for (int ele : arr) {
            push(ele);
        }
    }

    void push(int ele, int t) {
        if (top >= t) {
            System.out.println("stack is full.");
        } else {
            a[++top] = ele;
            System.out.println("pushed : " + ele);
        }
    }

    void push(int ele) {
        if (top == a.length - 1) {
            System.out.println("stack is full.");
        } else {
            a[++top] = ele;
            System.out.println("pushed : " + ele);
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return a[top--];
        }
    }

    int peek() {
        if (top > -1) {
            return a[top];
        } else {
            return -1;
        }
    }

    void display() {
        int t = top;
        System.out.print("elements :");
        while (t >= 0) {
            System.out.print(a[t--] + " ");
        }
        System.out.println();
    }

}

public class TW5a_MethodOverloading {
    public static void main(String[] args) {
        stack s1 = new stack();
        s1.initStack(5);
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);

        // s.display();

        System.out.println();

        System.out.println("pop : " + s1.pop());
        System.out.println("pop : " + s1.pop());

        System.out.println();

        // s.display();

        stack s2 = new stack();
        s2.initStack(s1);

        System.out.println();

        int arr[] = { 1, 2, 3, 4, 5 };
        stack s3 = new stack();
        s3.initStack(arr);

        System.out.println();

        System.out.println("peek of s1 : " + s1.peek());
        System.out.println("peek of s2 : " + s2.peek());
        System.out.println("peek of s3 : " + s3.peek());

    }
}
