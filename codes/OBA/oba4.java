package codes.OBA;

import java.util.Scanner;

class queue {
    int a[], size, front, rear;

    public queue(int[] a, int size) {
        this.size = size;
        this.a = new int [size];
        this.front = this.rear = rear - 1;
        for (int i = 0; i < a.length; i++)
            enqueue(a[i]);
    }

    void enqueue(int x) {
        if(rear < size - 1) {
            a[++rear] = x;
            System.out.println("enqueued " + x);
        } else 
            System.out.println("queue is full.");
    }

    void dequeue () {
        if(front == rear) 
            System.out.println("queue is empty.");
        else
            System.out.println("dequeued " + a[++front]);
    }

    void display () {
        System.out.print("queue : ");
        for(int i = front+1; i<=rear;i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

public class oba4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int [] a = {1,2,3,4,5};
        queue q = new queue(a, 20);
        q.dequeue();
        q.enqueue(20);
        q.display();
    }
}
