package advJava.lab.TW7;

class BankAcct {
    String cust_name;
    int cust_accno;
    static float balance;

    BankAcct(String cust_name, int cust_accno, float balance) {
        this.cust_name = cust_name;
        this.cust_accno = cust_accno;
        this.balance = balance;
    }

    synchronized void deposit(String name, int damt) {
        balance += damt;
        System.out.println(name + " Deposited Rs. " + damt);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            System.out.println(ie);

        }
    }

    synchronized void withdraw(String name, int wamt) {
        if ((wamt <= balance) && (balance - wamt) > 1000) // checks
        {
            balance -= wamt;
            System.out.println("Amount of Rs. " + wamt + " successfully withdrawn by " + name);

            /*
             * Making the thread sleep for 1 second after
             * each withdrawal.
             */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Insufficient balance. Cannot withdraw");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }

    synchronized float check_balance() {
        return (balance);
    }
}// end of BankAccount class

class Deposit_thread extends Thread {
    Thread t;
    BankAcct BA;
    String name;
    int damt;

    Deposit_thread(String name, BankAcct BA, int damt) {
        this.BA = BA;
        this.name = name;
        this.damt = damt;
    }

    @Override
    public void run() {
        BA.deposit(name, damt);
        System.out.println("Updated balance is : " + BA.check_balance());
    }
} // end of Deposit_thread class

class Withdraw_thread extends Thread {
    // Thread t;
    BankAcct BA;
    String name;
    int wamt;

    Withdraw_thread(String name, BankAcct BA, int wamt) {
        this.BA = BA;
        this.name = name;
        this.wamt = wamt;
        // t.start();
    }

    @Override
    public void run() {
        BA.withdraw(name, wamt);
    }
} // end of Deposit_thread class

public class BankAccount {
    public static void main(String args[]) {
        BankAcct BA = new BankAcct("Rahul", 1000, 1000);

        Deposit_thread DT1 = new Deposit_thread("DT1", BA, 1000);
        Deposit_thread DT2 = new Deposit_thread("DT2", BA, 1000);
        Deposit_thread DT3 = new Deposit_thread("DT3", BA, 1000);
        Withdraw_thread WT1 = new Withdraw_thread("WT1", BA, 2000);
        Withdraw_thread WT2 = new Withdraw_thread("WT2", BA, 2000);
        Withdraw_thread WT3 = new Withdraw_thread("WT3", BA, 500);

        DT1.start();
        DT2.start();
        DT3.start();
        WT1.start();
        WT2.start();
        WT3.start();

    } // end of main
}// end of class
