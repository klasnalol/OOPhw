import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class tables {
    public static void createBookTable(Connection conn) throws SQLException {
        createTable(conn, "books", "book_id SERIAL PRIMARY KEY, title VARCHAR(200), author VARCHAR(200), isbn VARCHAR(20), available BOOLEAN");
    }

    public static void createUserTable(Connection conn) throws SQLException {
        createTable(conn, "users", "user_id SERIAL PRIMARY KEY, name VARCHAR(200), address VARCHAR(200)");
    }

    public static void createBookBorrowingTable(Connection conn) throws SQLException {
        createTable(conn, "book_borrowings", "borrow_id SERIAL PRIMARY KEY, user_id INT, book_id INT, borrow_date DATE, return_date DATE, FOREIGN KEY (user_id) REFERENCES users(user_id), FOREIGN KEY (book_id) REFERENCES books(book_id)");
    }

    private static void createTable(Connection conn, String tableName, String columns) throws SQLException {
        Statement statement = null;
        try {
            String query = "CREATE TABLE IF NOT EXISTS " + tableName + "(" + columns + ")";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table " + tableName + " Created");
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
