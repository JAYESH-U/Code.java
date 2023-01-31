package codes.OBA;

class stack {
    int a[], size, top;

    public stack(int[] a, int s) {
        this.top = -1;
        this.a = new int[s];
        this.size = s;

        for (int i = 0; i < a.length; i++)
            push(a[i]);
    }

    void push(int x) {
        if (top < size - 1) {
            a[++top] = x;
            System.out.println("pushed " + x);
        } else
            System.out.println("Stack overflow.");
    }

    void pop() {
        if (top > -1)
            System.out.println("popped " + a[top--]);
        else
            System.out.println("Stack underflow.");
    }

    void peek() {
        if (top > -1)
            System.out.println("Stack top : " + a[top]);
        else
            System.out.println("Stack underflow!!!...");
    }

    void isEmpty() {
        if(top<0)
            System.out.println("Stack underflow.");
        else
            System.out.println("Stack is not empty.");
    }

    void display() {
        System.out.print("Stack : ");
        for (int i = top; i >= 0; i--)
            System.out.print(a[i] + " ");
        System.out.println("\n");
    }
}

public class oba2 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
        stack s = new stack(a, 20);
        System.out.println();

        s.isEmpty();
        System.out.println();

        s.push(9);
        s.push(10);
        System.out.println();

        s.peek();
        System.out.println();

        s.display();

        s.pop();
        s.pop();
        s.pop();
        s.pop();
        System.out.println();

        s.peek();
        System.out.println();

        s.display();

        s.isEmpty();
        System.out.println();
    }
}
