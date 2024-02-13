import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankingInterface extends Remote {
    void addAccount(int accountNumber, double initialBalance) throws RemoteException;

    void deposit(int accountNumber, double amount) throws RemoteException;

    void withdraw(int accountNumber, double amount) throws RemoteException;

    double getBalance(int accountNumber) throws RemoteException;
}
