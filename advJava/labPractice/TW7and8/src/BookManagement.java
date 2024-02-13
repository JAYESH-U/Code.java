package advJava.labPractice.TW7and8.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookManagement {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // MySQL JDBC driver
    static final String DB_URL = "jdbc:mysql://localhost:3306/"; // 3306 is the default port for MySQL
    static final String DB_NAME = "company";
    static final String USER = "root"; // Username and password
    static final String PASS = ""; // You should change these to your own
    static final String CREATE_DB_SQL = "CREATE DATABASE IF NOT EXISTS library";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create the database if it does not exist
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_DB_SQL);

            // Switch to the "company" database
            stmt.executeUpdate("USE library");

            // Create tables and insert sample data
            createTables(stmt); // ----------------------------- Uncomment this line to create tables and insert sample data

            
            while (true) {
                System.out.println();
                System.out.println("1.Add books\n2.Find books by author\n3.Delete books\n4.Display Books.\n5.Exit");
                System.out.print("Enter choice : ");
                Scanner sc = new Scanner(System.in);
                int ch = sc.nextInt();

                if(ch == 1){
                    insertBooks(stmt);
                } else if(ch == 2){
                    findBooksByAuthors(stmt);
                } else if(ch == 3){
                    deleteBooks(stmt);
                } else if(ch == 4){
                    displayBooks(stmt);
                } else if(ch == 5) {
                    break;
                } else {
                    System.out.println("Invalid choice!!");
                }
            }

            // Execute SQL queries
            // insertBooks(stmt); // ----------------------------- Uncomment this line to insert books
            // findBooksByAuthors(stmt); // ----------------------------- to find books by authors
            // deleteBooks(stmt); // ----------------------------- to delete books
            // displayBooks(stmt); // ----------------------------- to display books

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
        // Create Department table
        String createBookTable = "CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                "name TEXT, " +
                "author TEXT)";
        stmt.executeUpdate(createBookTable);
    }

    public static void insertBooks(Statement stmt) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter details of books : ");

        System.out.print("Name : ");
        String name = sc.next();

        System.out.print("Author : ");
        String author = sc.next();

        String insertEmp = "INSERT INTO books (name, author) VALUES "
                + "('" + name + "', '" + author + "')";

        stmt.executeUpdate(insertEmp);
    }

    public static void findBooksByAuthors(Statement stmt) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the author name to search for books: ");
        String author = sc.next();

        String query = "SELECT * FROM Books WHERE author = '" + author + "'";

        ResultSet resultSet = stmt.executeQuery(query);
        System.out.println("\nBooks and their authors : ");
        System.out.println("Id\t\tName\t\tAuthor");
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("id") + "\t\t");
            System.out.print(resultSet.getString("name") + "\t\t");
            System.out.print(resultSet.getString("author") + "\t\t");
            System.out.println();
        }
    }

    public static void deleteBooks(Statement stmt) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the book name to delete: ");
        String name = sc.next();

        String query = "DELETE FROM books WHERE name = '" + name + "'";

        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in deleting the book!!");
            System.out.println("There might be no book of this name!!");
        }
    }

    public static void displayBooks(Statement stmt) throws SQLException {
        String query = "SELECT * FROM books";

        ResultSet resultSet = stmt.executeQuery(query);
        System.out.println("\nBooks and their authors : ");
        System.out.println("Id\t\tName\t\tAuthor");
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("id") + "\t\t");
            System.out.print(resultSet.getString("name") + "\t\t");
            System.out.print(resultSet.getString("author") + "\t\t");
            System.out.println();
        }
    }
}
