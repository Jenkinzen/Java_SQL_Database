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
        UI.mainMenu();
    }








}



