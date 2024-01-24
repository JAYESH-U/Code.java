
import java.sql.*;
import java.util.Scanner;

public class CreateDB {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_Name = "company";
    static final String USER = "root";
    static final String PASS = "jayesh2003";

    static final String CREATE_DB_SQL = "CREATE DATABASE IF NOT EXISTS company";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Connecting to Database ...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            createDatabase(stmt);
            stmt.executeUpdate("USE company");

            createTable(stmt);

            while (true) {
                System.out.println();
                System.out.print(
                        "1.Add Employee\n2.Add Department\n3.Display employees\n4.Display Departments\n5.Display Employee and their Eepartments\n6.Delete employee.\n7.Delete Department.\n8.Exit\nEnter Choice : ");
                int ch = sc.nextInt();

                if (ch == 1) {
                    insertEmpData(stmt, sc);
                } else if (ch == 2) {
                    insertDeptData(stmt, sc);
                } else if (ch == 3) {
                    displayEmpData(stmt);
                } else if (ch == 4) {
                    displayDeptData(stmt);
                } else if (ch == 5) {
                    displayEmpDept(stmt);
                } else if (ch == 6) {
                    deleteEmployee(stmt, sc);
                } else if (ch == 7) {
                    deleteDepartment(stmt, sc);
                } else if (ch == 8) {
                    break;
                }
            }

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
        sc.close();
    }

    public static void createDatabase(Statement stmt) throws SQLException {
        stmt.executeUpdate(CREATE_DB_SQL);
    }

    public static void createTable(Statement stmt) throws SQLException {
        String deptTable = "CREATE TABLE IF NOT EXISTS department ("
                + "deptId INTEGER AUTO_INCREMENT PRIMARY KEY, "
                + "dname TEXT, "
                + "budget REAL )";

        stmt.executeUpdate(deptTable);

        String employeeTable = "CREATE TABLE IF NOT EXISTS employees ("
                + "ssn INTEGER AUTO_INCREMENT PRIMARY KEY, "
                + "fname TEXT, "
                + "lname TEXT, "
                + "dept INTEGER,"
                + "FOREIGN KEY (dept) REFERENCES department(deptId) ON DELETE CASCADE)";

        stmt.executeUpdate(employeeTable);
    }

    public static void insertEmpData(Statement stmt, Scanner sc) throws SQLException {
        System.out.println();
        System.out.println("Enter details of employee : ");
        System.out.print("fName : ");
        String fname = sc.next();
        System.out.print("lname : ");
        String lname = sc.next();
        System.out.print("department number : ");
        int deptNo = sc.nextInt();

        String insertEmp = "INSERT INTO employees (fname, lname, dept) VALUES "
                + "('" + fname + "', '" + lname + "', " + deptNo + ")";

        stmt.executeUpdate(insertEmp);

    }

    public static void insertDeptData(Statement stmt, Scanner sc) throws SQLException {
        System.out.println();
        System.out.println("Enter details of department : ");
        System.out.print("dName : ");
        String dname = sc.next();
        System.out.print("budget : ");
        float budget = sc.nextFloat();

        String insertDept = "INSERT INTO department (dname, budget) VALUES "
                + "('" + dname + "', " + budget + ")";

        stmt.executeUpdate(insertDept);
        System.out.println("inserted dept : " + dname);

    }

    public static void displayEmpData(Statement stmt) throws SQLException {
        // a. Select the last name of all employees.
        String queryA = "SELECT * FROM Employees";

        ResultSet resultSetA = stmt.executeQuery(queryA);
        System.out.println("\nLast Names of all Employees : ");
        System.out.println("ssn\tfirstname\tlastname\tdepartment");
        while (resultSetA.next()) {
            System.out.print(resultSetA.getString("ssn") + "\t");
            System.out.print(resultSetA.getString("fname") + "\t\t");
            System.out.print(resultSetA.getString("lname") + "\t\t");
            System.out.print(resultSetA.getString("dept") + "\n");
        }
        System.out.println();
    }

    public static void displayDeptData(Statement stmt) throws SQLException {
        String query = "SELECT * FROM department";
        ResultSet resultSet = stmt.executeQuery(query);

        System.out.println("\nDepartment Details:");
        System.out.println("deptId\tname\tbudget");
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("deptId") + "\t");
            System.out.print(resultSet.getString("dname") + "\t");
            System.out.print(resultSet.getFloat("budget") + "\n");
        }
        System.out.println();
    }

    public static void displayEmpDept(Statement stmt) throws SQLException {
        String query = "SELECT E.fname, E.lname, D.dname, D.budget " +
                "FROM employees E " +
                "JOIN department D ON E.dept = D.deptId";

        ResultSet resultSet = stmt.executeQuery(query);
        System.out.println("\nEmployee and their departments : ");
        System.out.println("FirstNames\tLastNames\tDepartmentNames\tDepartmentBudget");
        while (resultSet.next()) {
            System.out.print(resultSet.getString("fname") + "\t\t");
            System.out.print(resultSet.getString("lname") + "\t\t");
            System.out.print(resultSet.getString("dname") + "\t\t");
            System.out.print(resultSet.getFloat("budget") + "\n");
        }
        System.out.println();
    }

    public static void deleteEmployee(Statement stmt, Scanner sc) throws SQLException {
        System.out.print("\nEnter Employee ssn : ");
        int id = sc.nextInt();
        String deleteEmployeeQuery = "DELETE FROM employees WHERE ssn = " + id;
        stmt.executeUpdate(deleteEmployeeQuery);
        System.out.println("Employee with ID " + id + " deleted.");
    }

    public static void deleteDepartment(Statement stmt, Scanner sc) throws SQLException {
        System.out.print("\nEnter Department Id : ");
        int id = sc.nextInt();
        String deleteDepartmentQuery = "DELETE FROM department WHERE deptId = " + id;
        stmt.executeUpdate(deleteDepartmentQuery);
        System.out.println("Department with ID " + id + " deleted.");
    }

}