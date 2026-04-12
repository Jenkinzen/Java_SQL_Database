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
        // - vermute die multiattributeprint functions kann man viel effektiver und kürzer coden, generell functions reviewen.
        // - InfoOutPutMenu überdenken, machts sinn? Menüführung fühlt sich weird an aber weiß nich wieso. - > eventuell erst input, dann fragen wo gesucht werden soll -> dann was angezeigt werden soll.
        // - SQL DATABASE mit Country-State-dings im Internet gefunden, verbinden und null State Column entries
        //   vergleichen und einfügen lassen.
        //   andere Tables der chinook DB im sinnigen Kontext in das Programm verknüpfen.
        UI.multiAttributePrintSortedByCustomer("0,1,2,3,4,5,6,7,8,9,10,11,12,13",Storage.all_customers);
        UI.multiAttributePrintSortedByAttributes("0,1,2,3,4,5,6,7,8,9,10,11,12,13",Storage.all_customers);
        System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\nMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        System.out.println(Storage.all_customers.get(0).getInfoDynamical(1));
        System.out.println(Service.listOfCustomersWithSearchHits(Storage.all_customers,"0,1,2,3,4,5,6,7,8,9,10,11,12,13","as"));
        UI.mainMenu();
    }








}



