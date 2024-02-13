package advJava.labPractice.TW7and8.src;

import java.sql.*;
import java.util.*;

class Bank {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // MySQL JDBC driver
    static final String DB_URL = "jdbc:mysql://localhost:3306/"; // 3306 is the default port for MySQL
    static final String USER = "root"; // Username and password
    static final String PASS = "jayesh2003"; // You should change these to your own
    static final String CREATE_DB_SQL = "CREATE DATABASE IF NOT EXISTS bank";
    private Connection conn = null;
    private Statement stmt = null;

    Bank() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            System.out.println("Connecting to database...");
            stmt.executeUpdate(CREATE_DB_SQL);
            stmt.executeUpdate("USE bank");

            createTables(stmt);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTables(Statement stmt) throws SQLException {
        String createAccTable = "CREATE TABLE IF NOT EXISTS accounts ("
                + "Id INTEGER AUTO_INCREMENT PRIMARY KEY,"
                + "Name TEXT,"
                + "Password TEXT,"
                + "Balance REAL)";

        stmt.executeUpdate(createAccTable);
    }

    public void printAllAccounts() throws SQLException {
        String query = "SELECT * FROM accounts";
        ResultSet resultSet = stmt.executeQuery(query);

        System.out.println("\nId\t\tName\t\tPassword\t\tBalance");
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("Id") + "\t\t");
            System.out.print(resultSet.getString("Name") + "\t\t");
            System.out.print(resultSet.getString("Password") + "\t\t");
            System.out.print(resultSet.getString("Balance") + "\t\t");
            System.out.println();
        }
        System.out.println();
    }

    public void printDetails(Scanner sc) throws SQLException {
        System.out.print("Enter account holder name : ");
        String name = sc.next();
        String query = "SELECT * FROM accounts WHERE name = '" + name + "'";

        ResultSet resultSet = stmt.executeQuery(query);
        System.out.println("\nId\t\tName\t\tBalance");
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("Id") + "\t\t");
            System.out.print(resultSet.getString("Name") + "\t\t");
            System.out.print(resultSet.getString("Balance") + "\t\t");
            System.out.println();
        }
        System.out.println();
    }

    public void addAccount(Scanner sc) throws SQLException {
        System.out.println();
        System.out.println("Enter details of Account : ");

        System.out.print("Name : ");
        String name = sc.next();

        System.out.print("Password : ");
        String pass = sc.next();

        String insertAcc = "INSERT INTO accounts (Name, Password, Balance) VALUES "
                + "('" + name + "', '" + pass + "', '" + 0 + "')";

        stmt.executeUpdate(insertAcc);
        System.out.println("Account Inserted..");
    }

    public void deposit(Scanner sc) throws SQLException {
        System.out.println("Ener Bank details -> ");
        System.out.print("Enter Account Id : ");
        int id = sc.nextInt();

        System.out.print("Enter ammount to deposit : ");
        float amount = sc.nextFloat();

        String query = "UPDATE accounts SET Balance = balance +" + amount + " WHERE Id = " + id;

        stmt.executeUpdate(query);
        System.out.println("Account balance updated..");
    }

    public void withdraw(Scanner sc) throws SQLException {
        System.out.println("Ener Bank details -> ");
        System.out.print("Enter Account Id : ");
        int id = sc.nextInt();
        System.out.print("Enter Account password : ");
        String password = sc.next();

        System.out.print("Enter ammount to withdraw : ");
        float amount = sc.nextFloat();

        String query = "UPDATE accounts SET Balance = balance -" + amount
                + " WHERE Id = " + id + " and Password = '" + password + "'";

        stmt.executeUpdate(query);
        System.out.println("Account balance updated..");
    }

    synchronized void deposit(int id, Float amount) {
        String query = "UPDATE accounts SET Balance = balance +" + amount + " WHERE Id = " + id;

        try {
            stmt.executeUpdate(query);
            System.out.println("Account balance updated..");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println(ie);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized void withdraw(int id, String password, Float amount) {

        String query = "UPDATE accounts SET Balance = balance -" + amount
                + " WHERE Id = " + id + " and Password = '" + password + "'";

        try {
            stmt.executeUpdate(query);
            System.out.println("Account balance updated..");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println(ie);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}

// define threads here
class Deposit_thread extends Thread {
    Thread t;
    Bank BA;
    int id;
    float damt;
    Scanner sc;

    Deposit_thread(Bank BA, int id, float damt) {
        this.BA = BA;
        this.id = id;
        this.damt = damt;
        this.sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        BA.deposit(id, damt);
    }
}

class Withdraw_thread extends Thread {
    // Thread t;
    Bank BA;
    int id;
    String pass;
    float wamt;
    Scanner sc;

    Withdraw_thread(Bank BA, int id, String pass, float wamt) {
        this.BA = BA;
        this.id = id;
        this.pass = pass;
        this.wamt = wamt;
        this.sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        BA.withdraw(id, pass, wamt);
    }
}

public class BanlTransactionSynchronized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();

        while (true) {
            System.out.println();
            System.out.println("1.Print all Accounts");
            System.out.println("2.Print specific account details");
            System.out.println("3.Deposit");
            System.out.println("4.Withdraw");
            System.out.println("5.Add Account");
            System.out.println("6.Exit");
            int ch = sc.nextInt();

            try {
                if (ch == 1) {
                    b.printAllAccounts();
                } else if (ch == 2) {
                    b.printDetails(sc);
                } else if (ch == 3) {
                    // b.deposit(sc);
                    deposit(b, sc);
                } else if (ch == 4) {
                    // b.withdraw(sc);
                    withdraw(b, sc);
                } else if (ch == 5) {
                    b.addAccount(sc);
                } else if (ch == 6) {
                    sc.close();
                    break;
                } else {
                    System.out.println("Invalid choice.!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deposit(Bank b, Scanner sc) {
        System.out.print("id : ");
        int id = sc.nextInt();
        System.out.print("amount : ");
        float amount = sc.nextFloat();
        Deposit_thread dt = new Deposit_thread(b, id, amount);
        dt.start();
    }

    public static void withdraw(Bank b, Scanner sc) {
        System.out.print("id : ");
        int id = sc.nextInt();
        System.out.print("password : ");
        String pass = sc.next();
        System.out.print("amount : ");
        float amount = sc.nextFloat();
        Withdraw_thread wt = new Withdraw_thread(b, id, pass, amount);
        wt.start();
    }
}
