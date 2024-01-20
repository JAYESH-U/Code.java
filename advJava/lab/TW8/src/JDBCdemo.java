import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "company";
    static final String USER = "root";
    static final String PASS = "";
    static final String CREATE_DB_SQL = "CREATE DATABASE IF NOT EXISTS company";

    public static void main(String[] args) {
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
            stmt.executeUpdate("USE company");

            // Create tables and insert sample data
            // createTables(conn); //----------------------------- Uncomment this line to create tables and insert sample data

            // Execute SQL queries
            executeQueries(conn);

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

    private static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        // Create Department table
        String createDepartmentTableSQL = "CREATE TABLE IF NOT EXISTS Department (" +
                "code INTEGER PRIMARY KEY, " +
                "Name TEXT, " +
                "Budget REAL)";
        stmt.executeUpdate(createDepartmentTableSQL);

        // Create Employees table
        String createEmployeesTableSQL = "CREATE TABLE IF NOT EXISTS Employees (" +
                "SSN INTEGER PRIMARY KEY, " +
                "Name TEXT, " +
                "LastName TEXT, " +
                "Department INTEGER, " +
                "FOREIGN KEY (Department) REFERENCES Department(code))";
        stmt.executeUpdate(createEmployeesTableSQL);

        // Insert sample data into Department table
        String insertDepartmentDataSQL = "INSERT INTO Department (code, Name, Budget) VALUES " +
                "(1, 'HR', 50000.0), " +
                "(2, 'IT', 80000.0), " +
                "(3, 'Finance', 70000.0)";
        stmt.executeUpdate(insertDepartmentDataSQL);

        // Insert sample data into Employees table
        String insertEmployeesDataSQL = "INSERT INTO Employees (SSN, Name, LastName, Department) VALUES " +
                "(101, 'John', 'Doe', 1), " +
                "(102, 'Jane', 'Smith', 2), " +
                "(103, 'Mike', 'Johnson', 3)";
        stmt.executeUpdate(insertEmployeesDataSQL);

        stmt.close();
    }

    private static void executeQueries(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        // a. Select the last name of all employees.
        String queryA = "SELECT LastName FROM Employees";

        ResultSet resultSetA = stmt.executeQuery(queryA);
        System.out.println("a. Last Names of all Employees:");
        while (resultSetA.next()) {
            System.out.println(resultSetA.getString("LastName"));
        }
        System.out.println();

        // b. Select the name and last name of each employee, along with the name and
        // budget of the employee's department.
        String queryB = "SELECT E.Name, E.LastName, D.Name AS DepartmentName, D.Budget " +
                "FROM Employees E " +
                "JOIN Department D ON E.Department = D.code";

        ResultSet resultSetB = stmt.executeQuery(queryB);
        System.out.println("b. Employee Names, Last Names, Department Names, and Department Budgets:");
        while (resultSetB.next()) {
            System.out.println("Name: " + resultSetB.getString("Name") +
                    ", Last Name: " + resultSetB.getString("LastName") +
                    ", Department: " + resultSetB.getString("DepartmentName") +
                    ", Budget: " + resultSetB.getDouble("Budget"));
        }
        System.out.println();

        // c. Select all the data of employees, including each employee's department's
        // data.
        String queryC = "SELECT E.*, D.* " +
                "FROM Employees E " +
                "JOIN Department D ON E.Department = D.code";

        ResultSet resultSetC = stmt.executeQuery(queryC);
        System.out.println("c. All Employee Data along with their Department Data:");
        while (resultSetC.next()) {
            System.out.println("SSN: " + resultSetC.getInt("SSN") +
                    ", Name: " + resultSetC.getString("Name") +
                    ", Last Name: " + resultSetC.getString("LastName") +
                    ", Department: " + resultSetC.getInt("Department") +
                    ", Department Name: " + resultSetC.getString("Name") +
                    ", Budget: " + resultSetC.getDouble("Budget"));
        }

        stmt.close();
    }
}
