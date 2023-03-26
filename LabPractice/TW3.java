package LabPractice;

class Bank {
    int num;
    float bal;
    String ty, name;
    static int cnt=0;

    Bank(String name, String ty, float bal){
        num = ++cnt;
        this.name = name;
        this.ty = ty;
        this.bal = bal;
    }

    void computeInterest(int time){
        double inter;
        if(ty.equals("s")){
            inter = 0.05* bal * time;
            System.out.println("Interest for "+time+" years : "+inter);
        }
        else if(ty.equals("rd")){
            inter = 0.065* bal * time;
            System.out.println("Interest for "+time+" years : "+inter);
        }
        else if(ty.equals("fd")){
            inter = 0.0765* bal * time;
            System.out.println("Interest for "+time+" years : "+inter);
        }
        else
            System.out.println("invalid accout type!!!!!!");
    }

    void withdraw(int w){
        if((bal-1000)>w){
            bal -= w;
            System.out.println("Accout balance after withdrawal is : "+bal);
        }else {
            System.out.println("Insufficient balance.!");
        }
    }

    void deposit(int d){
        bal+=d;
        System.out.println("Accout balance after deposit : "+bal);
    }
}

public class TW3 {
    public static void main(String[] args) {
        Bank b1 = new Bank("Jayesh", "s", 10000);
        b1.computeInterest(2);
        b1.withdraw(2000);
        b1.deposit(1000);
        b1.withdraw(10000);
    }
}
