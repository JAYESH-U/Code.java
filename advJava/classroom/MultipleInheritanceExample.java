package advJava.classroom;

class A{
    void display(A a){
        System.out.print("A");
    }
}

class B extends A{
    void display(B b){
        System.out.print("B");
    }
}

class C extends B{
    void display(C c){
        System.out.print("C");
    }
}

class D extends C{
    void display(D d){
        System.out.print("D");
    }
}

public class MultipleInheritanceExample {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        d.display(a);
        d.display(b);
        d.display(c);
    }
}
