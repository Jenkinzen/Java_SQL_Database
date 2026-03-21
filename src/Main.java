import java.sql.Array;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws SQLException {
        DataAccess.getcustomerdata();
        System.out.println(Storage.customers_sorted_by_company.entrySet());


        UI.mainmenu();

    }








}



