import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class users_bruh {
    public static void readData(Connection conn, String tableName) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String query = String.format("SELECT * FROM %s", tableName);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("user_id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getString("address") + " ");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }

    // Method to update user name
    public static void updateName(Connection conn, String tableName, String oldName, String newName) throws SQLException {
        Statement statement = null;
        try {
            String query = String.format("UPDATE %s SET name='%s' WHERE name='%s'", tableName, newName, oldName);
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data Updated");
            } else {
                System.out.println("No data found to update");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    // Method to search for a user by name
    public static void searchByName(Connection conn, String tableName, String name) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String query = String.format("SELECT * FROM %s WHERE name='%s'", tableName, name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("user_id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getString("address"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }

    // Method to delete a user by name
    public static void deleteRowByName(Connection conn, String tableName, String name) throws SQLException {
        Statement statement = null;
        try {
            String query = String.format("DELETE FROM %s WHERE name='%s'", tableName, name);
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data Deleted");
            } else {
                System.out.println("No data found to delete");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    // Method to add a new user
    public static void addUser(Connection conn, String name, String address) throws SQLException {
        Statement statement = null;
        try {
            String query = String.format("INSERT INTO users (name, address) VALUES ('%s', '%s')", name, address);
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("User Added Successfully");
            } else {
                System.out.println("Failed to add user");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
