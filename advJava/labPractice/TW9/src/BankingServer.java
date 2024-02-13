

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BankingServer extends UnicastRemoteObject implements BankingInterface {
    private List<BankAccount> accounts;

    protected BankingServer() throws RemoteException {
        super();
        accounts = new ArrayList<>();
    }

    // Method to add a new account to the list
    public synchronized void addAccount(int accountNumber, double initialBalance) {
        BankAccount newAccount = new BankAccount(accountNumber, initialBalance);
        accounts.add(newAccount);
        System.out.println("New account created: Account Number - " + accountNumber + ", Initial Balance - $" + initialBalance);
    }

    @Override
    public synchronized void deposit(int accountNumber, double amount) throws RemoteException {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit of $" + amount + " to account " + accountNumber + " completed. New balance: $" + account.getBalance());
        } else {
            System.out.println("Account " + accountNumber + " not found for deposit");
        }
    }

    @Override
    public synchronized void withdraw(int accountNumber, double amount) throws RemoteException {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal of $" + amount + " from account " + accountNumber + " completed. New balance: $" + account.getBalance());
            } else {
                System.out.println("Insufficient funds for withdrawal from account " + accountNumber);
            }
        } else {
            System.out.println("Account " + accountNumber + " not found for withdrawal");
        }
    }

    @Override
    public synchronized double getBalance(int accountNumber) throws RemoteException {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Balance inquiry for account " + accountNumber + ": $" + account.getBalance());
            return account.getBalance();
        } else {
            System.out.println("Account " + accountNumber + " not found for balance inquiry");
            return 0;
        }
    }

    private BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            BankingServer bankingServer = new BankingServer();



            Naming.rebind("rmi://localhost/BankingService", bankingServer);

            System.out.println("Banking Server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
