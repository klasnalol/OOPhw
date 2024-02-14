import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class boogs_do_smth {
    public static void readData(Connection conn, String tableName) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String query = String.format("SELECT * FROM %s", tableName);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("book_id") + " ");
                System.out.print(rs.getString("title") + " ");
                System.out.print(rs.getString("author") + " ");
                System.out.println(rs.getString("isbn") + " ");
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

    public static void updateName(Connection conn, String tableName, String oldName, String newName) throws SQLException {
        Statement statement = null;
        try {
            String query = String.format("UPDATE %s SET title='%s' WHERE title='%s'", tableName, newName, oldName);
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

    public static void searchByName(Connection conn, String tableName, String name) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String query = String.format("SELECT * FROM %s WHERE title='%s'", tableName, name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("book_id") + " ");
                System.out.print(rs.getString("title") + " ");
                System.out.println(rs.getString("author") + " ");
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

    public static void deleteRowByName(Connection conn, String tableName, String name) throws SQLException {
        Statement statement = null;
        try {
            String query = String.format("DELETE FROM %s WHERE title='%s'", tableName, name);
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
    public static void addBook(Connection conn, String title, String author, String isbn, boolean available) throws SQLException {
        Statement statement = null;
        try {
            String query = String.format("INSERT INTO books (title, author, isbn, available) VALUES ('%s', '%s', '%s', %b)", title, author, isbn, available);
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Book Added Successfully");
            } else {
                System.out.println("Failed to add book");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
