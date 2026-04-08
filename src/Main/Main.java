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
        System.out.println(Storage.all_customers.size());
        System.out.println(Storage.all_customers.get(2).getInfoDynamical(2));
        System.out.println(Storage.all_customers.get(2).getInfoDynamical(2).get(0).contains("is"));
        //Find attribute in a specific column, give out chosen attributes
        UI.multiAttributePrint("1,2,3,4,5,6",Service.searchInColumnDynamical(Storage.all_customers,2,"as"));
        //give out every attribute of all customers
        UI.multiAttributePrint("1,2,3,4,5,6,7,8,9,10,11,12,13",Service.searchInColumnDynamical(Storage.all_customers,1,""));
        //search for one input in every column and give out the hits sorted by columns
        for(int i = 0; i < Storage.all_customers.size();i++){

        }
        UI.mainMenu();
    }








}



