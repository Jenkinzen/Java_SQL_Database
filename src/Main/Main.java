package Main;

import Customers.Customers;
import DataAccessAndConnection.DataAccess;
import Service.Service;
import Storage.Storage;
import UI.UI;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
        DataAccess.getcustomerdata();

        UI.mainMenu();
    }








}



