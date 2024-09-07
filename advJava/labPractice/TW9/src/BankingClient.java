
import java.rmi.Naming;
import java.util.Scanner;

public class BankingClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object from RMI registry
            BankingInterface bankingService = (BankingInterface) Naming.lookup("rmi://localhost/BankingService");

            // Use bankingService for deposit, withdrawal, and balance inquiry
            Scanner scanner = new Scanner(System.in);

            int accountNumber;
            double initialBalance = 0;

            System.out.println("Enter account number: ");
            accountNumber = scanner.nextInt();

            // Example: Assume the client knows the initial balance to deposit
            System.out.println("Enter initial balance to deposit: ");
            initialBalance = scanner.nextDouble();
            // Call addAccount to add the account on the server
            bankingService.addAccount(accountNumber, initialBalance);
            System.out.println("Account with initial deposit created.");

            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Balance Inquiry");
                System.out.println("4. Exit");
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        bankingService.deposit(accountNumber, depositAmount);
                        System.out.println("Deposit completed.");
                        break;

                    case 2:
                        System.out.println("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        bankingService.withdraw(accountNumber, withdrawalAmount);
                        System.out.println("Withdrawal completed.");
                        break;

                    case 3:
                        double balance = bankingService.getBalance(accountNumber);
                        System.out.println("Current balance for account " + accountNumber + ": $" + balance);
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }

            } while (choice != 4);
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
