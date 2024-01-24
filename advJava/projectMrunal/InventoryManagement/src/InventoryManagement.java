import java.sql.*;

public class InventoryManagement {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "inventory";
    static final String USER = "root";
    static final String PASS = "";
    static final String CREATE_DB_SQL = "CREATE DATABASE IF NOT EXISTS inventory";
    static final String CREATE_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS products (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "price DOUBLE NOT NULL)";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Create the database if it does not exist
            stmt.executeUpdate(CREATE_DB_SQL);

            // Switch to the "inventory" database
            stmt.executeUpdate("USE inventory");

            // Create the "products" table if it does not exist
            stmt.executeUpdate(CREATE_TABLE_SQL);

            // Sample operations
            addProduct(stmt, "Laptop", 1200.00);
            addProduct(stmt, "Printer", 200.00);

            displayProducts(stmt);

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private static void addProduct(Statement stmt, String name, double price) throws SQLException {
        String sql = "INSERT INTO products (name, price) VALUES ('" + name + "', " + price + ")";
        stmt.executeUpdate(sql);
    }

    private static void displayProducts(Statement stmt) throws SQLException {
        String sql = "SELECT * FROM products";
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");

            System.out.println("Product ID: " + id + ", Name: " + name + ", Price: $" + price);
        }
    }
}
