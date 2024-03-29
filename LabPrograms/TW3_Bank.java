package LabPrograms;
import java.util.Scanner;

class Bank {
    int accNumber;
    String name, address, accType;
    double accBal;
    static int count = 0;

    Bank() {
        accNumber = ++count;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Name : ");
        name = in.nextLine();
        System.out.print("Enter Address : ");
        address = in.nextLine();
        System.out.print("Enter account type : ");
        accType = in.nextLine();
        System.out.print("Enter account Balance : ");
        accBal = in.nextDouble();
    }

    Bank(String name, String address, String accType, double accBal) {
        accNumber = ++count;
        this.name = name;
        this.address = address;
        this.accType = accType;
        this.accBal = accBal;
    }

    void computeInterest(int time) {
        double interest;
        if ("sb".equals(accType)) {
            interest = 0.05 * accBal * time;
            System.out.println("Interest earned for SB account is : " + interest);
        } else if ("rd".equals(accType)) {
            interest = 0.063 * accBal * time;
            System.out.println("Interest earned for RD account is : " + interest);
        } else if ("fd".equals(accType)) {
            interest = 0.0765 * accBal * time;
            System.out.println("Interest earned for FD account is : " + interest);
        } else {
            System.out.println("invalid account type...!!!");
        }
    }

    void deposit(double amount) {
        accBal += amount;
        System.out.println("Account balance is : " + accBal);
    }

    void withdraw(double amount) {
        if ((accBal - amount) < 1000) {
            System.out.println("Insufficient Balance...!!!");
        } else {
            accBal -= amount;
            System.out.println("Account balance is : " + accBal);
        }
    }
}
public class TW3_Bank {
    public static void main(String[] args) {
        Bank b1 = new Bank();
        Bank b2 = new Bank("Jayesh","Belagavi","rd",10000);
        Bank b3 = new Bank();

        b1.computeInterest(1);
        b2.computeInterest(1);
        b3.computeInterest(1);
        b1.deposit(500);
        b1.withdraw(1500);
        b2.deposit(100000);
        b2.withdraw(1000);
        b3.deposit(2000);
        b3.withdraw(3000);
    }
}
