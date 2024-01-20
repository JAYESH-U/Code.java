package advJava.lab.TW7;

import java.util.Scanner;

class Bank {
    private String name;
    private static long accNo = 0;
    private float bal;
    private Scanner s;

    Bank() {
        s = new Scanner(System.in);
        System.out.println("Enter Account holder name : ");
        name = s.nextLine();
        accNo += 1;
        bal = 1000;
    }

    Bank(String name) {
        this.name = name;
        accNo += 1;
        bal = 1000;
    }

    public synchronized void withdraw() {
        s = new Scanner(System.in);
        System.out.println("Enter the amount to withdraw : ");
        float w = s.nextFloat();

        if (w > bal) {
            System.out.println("Insufficient balance !!!");
        } else {
            bal -= w;
            System.out.println("The balance after withdrawal : " + bal);
        }
    }

    public synchronized void deposit() {
        s = new Scanner(System.in);
        System.out.println("Enter the amount to deposit : ");
        float d = s.nextFloat();

        bal -= d;
        System.out.println("The balance after Deposit : " + bal);
    }

    public synchronized void showDetails() {
        System.out.println("---------------------------------------------");
        System.out.println("Account holder name : " + name);
        System.out.println("Account number : " + accNo);
        System.out.println("Account balance is : " + bal);
        System.out.println("---------------------------------------------");
    }
}


public class BankOperation {
    public static void main(String[] args) {
        
    }
}