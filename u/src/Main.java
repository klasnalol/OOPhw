import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DbFunctions db=new DbFunctions();
        Connection conn=db.connect_to_db("base","postgres","cringe");
        //tables.createBookTable(conn);
        //tables.createUserTable(conn);
        // tables.createBookBorrowingTable(conn);

        //boogs_do_smth.addBook(conn, "New Book Title", "New Book Author", "1234567890", true);
        boogs_do_smth.readData(conn, "books");
        boogs_do_smth.updateName(conn, "books", "Old Title", "New Title");
        boogs_do_smth.searchByName(conn, "books", "Search Title");
        boogs_do_smth.deleteRowByName(conn, "books", "Delete Title");

        users_bruh.readData(conn, "users");
        users_bruh.updateName(conn, "users", "Old Name", "New Name");
        users_bruh.searchByName(conn, "users", "Search Name");
        users_bruh.deleteRowByName(conn, "users", "Delete Name");
        //users_bruh.addUser(conn, "John Doe", "123 Main St");

        Borrowed.listBorrowedBooks(conn, "book_borrowings");
        //Borrowed.borrowBook(conn, 1, 2, "2024-02-15"); // User ID 1 borrows Book ID 2 on 2024-02-15
        //Borrowed.returnBook(conn, 1, "2024-02-20"); // Book borrowed with Borrow ID 1 is returned on 2024-02-20

        //db.createTable(conn,"employee");
        //db.insert_row(conn,"employee","Rajat","India");
        //db.update_name(conn,"employee","Rahul","Raj");
        //db.search_by_name(conn,"employee","abhishek");
        //db.delete_row_by_name(conn,"employee","abhishek");
        //db.delete_row_by_id(conn,"employee",4);
        //db.read_data(conn,"employee");
        //db.delete_table(conn,"employee");
	// write your code here

    }

}
