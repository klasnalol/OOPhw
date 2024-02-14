import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Borrowed {
    // Method to list all borrowed books
    public static void listBorrowedBooks(Connection conn, String tableName) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String query = String.format("SELECT * FROM %s", tableName);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getInt("borrow_id") + " ");
                System.out.print(rs.getInt("user_id") + " ");
                System.out.print(rs.getInt("book_id") + " ");
                System.out.print(rs.getDate("borrow_date") + " ");
                System.out.println(rs.getDate("return_date") + " ");
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

    // Method to borrow a book
    public static void borrowBook(Connection conn, int userId, int bookId, String borrowDate) throws SQLException {
        Statement statement = null;
        try {
            String query = String.format("INSERT INTO book_borrowings (user_id, book_id, borrow_date) VALUES (%d, %d, '%s')", userId, bookId, borrowDate);
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Book Borrowed Successfully");
            } else {
                System.out.println("Failed to borrow book");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    // Method to return a borrowed book
    public static void returnBook(Connection conn, int borrowId, String returnDate) throws SQLException {
        Statement statement = null;
        try {
            String query = String.format("UPDATE book_borrowings SET return_date='%s' WHERE borrow_id=%d", returnDate, borrowId);
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Book Returned Successfully");
            } else {
                System.out.println("Failed to return book");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
