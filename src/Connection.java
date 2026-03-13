import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {


    public static void connection() throws SQLException {
        //connection string
        var url = "jdbc:sqlite:C:\\Users\\ggord\\IdeaProjects\\neues_projekt\\chinook.db";

        try (var conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}