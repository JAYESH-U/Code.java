package LabPractice;

class Stack {
    int t, s[], size;

    Stack(int n){
        this.t = -1;
        this.s = new int[n];
        this.size = n;
    }

    Stack(int a[]){
        this.t = -1;
        this.s = new int[a.length];
        this.size = a.length;
        for(int ele : a)
            push(ele);
    }

    Stack(Stack a){
        this.t = -1;
        this.s = new int [a.s.length];
        this.size = a.s.length;
        for(int ele : a.s)
            push(ele);
    }

    void push(int x){
        if(t<size-1)
            s[++t] = x;
        else
            System.out.println("\nStack overflow.");
    }

    int pop(){
        if(t>0)
            return s[t--];
        else
            System.out.println("\nStack underflow.");
        return -999;
    }

    void display(){
        System.out.println("\nStack : ");
        for(int i=0;i<=t;i++){
            System.out.print(s[i]+ " ");
        }
        System.out.println("");
    }
}

public class TW5 {
    public static void main(String[] args) {
        Stack s1 = new Stack(5);
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);
        // s1.pop();
        s1.display();

        Stack s2 = new Stack(s1);
        // s2.pop();
        s2.display();

        int []a = {1,2,3,4,5};
        Stack s3 = new Stack(a);
        s3.display();

        s3.pop();
        s3.display();
    }
}
