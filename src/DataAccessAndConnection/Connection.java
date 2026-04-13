package DataAccessAndConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {


    public static java.sql.Connection connection(String url) throws SQLException {

        return DriverManager.getConnection(url);
    }
}