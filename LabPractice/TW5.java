package LabPractice;

class Stack {
    int t, s[], size;

    Stack(int size){
        s= new int[size];
        t=-1;
        this.size = size;
    }

    Stack(int a[]){
        s= new int[a.length];
        t=-1;
        this.size = a.length;
        for(int ele : a)
            push(ele);
    }

    Stack(Stack st){
        s= new int[st.size];
        t=-1;
        this.size = st.size;
        for(int ele : st.s)
            push(ele, st.t);
    }

    void push(int x){
        if(t <size-1)
            s[++t] = x;
        else
            System.out.println("Stack Overflow.");
    }

    void push(int x, int top){
        if(t < top)
            s[++t] = x;
        else
            System.out.println("Stack Overflow.");
    }

    int pop(){
        if(t<0){
            System.out.println("Stack is empty");
            return -1;
        }
        else
            return s[t--];
    }

    void display(){
        System.out.println("Stack : ");
        for(int i=0;i<=t;i++)
            System.out.print(s[i]+" ");
        System.out.println("\n");
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
