package advJava.labPractice.TW7and8.src;

import java.sql.*;
import java.util.Scanner;;

public class BankTransaction {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // MySQL JDBC driver
    static final String DB_URL = "jdbc:mysql://localhost:3306/"; // 3306 is the default port for MySQL
    static final String USER = "root"; // Username and password
    static final String PASS = ""; // You should change these to your own
    static final String CREATE_DB_SQL = "CREATE DATABASE IF NOT EXISTS bank";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            System.out.println("Connecting to database...");
            stmt.executeUpdate(CREATE_DB_SQL);
            stmt.executeUpdate("USE bank");

            createTables(stmt);

            while (true) {
                System.out.println();
                System.out.println("1.Print all Accounts");
                System.out.println("2.Print specific account details");
                System.out.println("3.Deposit");
                System.out.println("4.Withdraw");
                System.out.println("5.Add Account");
                System.out.println("6.Exit");
                int ch = sc.nextInt();

                if (ch == 1) {
                    printAllAccounts(stmt);
                } else if (ch == 2) {
                    printDetails(stmt, sc);
                } else if (ch == 3) {
                    deposit(stmt, sc);
                } else if (ch == 4) {
                    withdraw(stmt, sc);
                } else if (ch == 5) {
                    addAccount(stmt, sc);
                } else if (ch == 6) {
                    break;
                } else {
                    System.out.println("Invalid choice.!!!");
                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    public static void createTables(Statement stmt) throws SQLException {
        String createAccTable = "CREATE TABLE IF NOT EXISTS accounts ("
                + "Id INTEGER AUTO_INCREMENT PRIMARY KEY,"
                + "Name TEXT,"
                + "Password TEXT,"
                + "Balance REAL)";

        stmt.executeUpdate(createAccTable);
    }

    public static void printAllAccounts(Statement stmt) throws SQLException {
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

    public static void printDetails(Statement stmt, Scanner sc) throws SQLException {
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

    public static void addAccount(Statement stmt, Scanner sc) throws SQLException {
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

    public static void deposit(Statement stmt, Scanner sc) throws SQLException {
        System.out.println("Ener Bank details -> ");
        System.out.print("Enter Account Id : ");
        int id = sc.nextInt();

        System.out.print("Enter ammount to deposit : ");
        float amount = sc.nextFloat();

        String query = "UPDATE accounts SET Balance = balance +" + amount + " WHERE Id = " + id;

        stmt.executeUpdate(query);
        System.out.println("Account balance updated..");
    }

    public static void withdraw(Statement stmt, Scanner sc) throws SQLException {
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
}
