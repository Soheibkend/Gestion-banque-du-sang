package sample.DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import sample.Classes.CollectSang;
import sample.Classes.SangStocke;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//"DESKTOP-HHPM41M"
public class DBCONNECTION {

    private static final String HOST = "";
    private static final int PORT = 1521;
    private static final String DB_NAME = "SOHEIB";
    private static final String USERNAME = "TPGL";
    private static final String PASSWORD = "soheib";
    public static ResultSet rs = null;
    public static Statement statement;
    private static Connection connection;


    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String dbURL = "jdbc:oracle:thin:@localhost:1521:SOHEIB";
            connection = DriverManager.getConnection(dbURL, "TPGL", "soheib");
            statement = connection.createStatement();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean demandeSangExiste(String numeroDemande){

        try {
            Connection con = getConnection();
            rs = statement.executeQuery("select * FROM DEMANDESANG WHERE NUMERODEMANDE = '"+numeroDemande+"'");
            if (rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addDemandeSang (String numeroDemande, String nomDemandeur, String nomDestinataire, String dateDemande, String groupeSanguin, int nombreSac, String remarque, String objectif) {
        try {
            statement.executeQuery("INSERT INTO DEMANDESANG"+"  VALUES ('" +numeroDemande + "','"+nomDemandeur+"','"+ nomDestinataire+ "','"+ dateDemande+"','"+groupeSanguin+"',"+ nombreSac+",'"+ remarque+"','"+objectif+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addDon (String nomDonneur,String groupeSanguin , String hopital, String nomMedecin) {
        try {
            Connection con = getConnection();

            statement.executeQuery("INSERT INTO COLLECTSANG"+" Values ('" +nomDonneur + "','"+hopital+"','"+ groupeSanguin+ "','"+ nomMedecin+"','"+ LocalDate.now().toString()+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<CollectSang> getListeDonneur (String nom) {
        try {
            Connection con = getConnection();
            ObservableList<CollectSang> Liste = FXCollections.observableArrayList();
            rs = statement.executeQuery("Select * FROM COLLECTSANG WHERE NOMDONATEUR = '" + nom + "'");
            while (rs.next()) {
                Liste.add(new CollectSang(rs.getString("NOMDONATEUR"), rs.getString("HOPITAL"), rs.getString("GROUPESANGUIN"), rs.getString("NOMMEDECIN"), rs.getString("DATECOLLECTION")));
            }
            return Liste;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<CollectSang> getListeDonneurComplete () {
        try {
            Connection con = getConnection();
            ObservableList<CollectSang> Liste = FXCollections.observableArrayList();
            rs = statement.executeQuery("Select * FROM COLLECTSANG ");
            while (rs.next()) {
                Liste.add(new CollectSang(rs.getString("NOMDONATEUR"), rs.getString("HOPITAL"), rs.getString("GROUPESANGUIN"), rs.getString("NOMMEDECIN"), rs.getString("DATECOLLECTION")));
            }
            return Liste;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<SangStocke> getListeSangStocke () {
        try {
            Connection con = getConnection();
            ObservableList<SangStocke> Liste = FXCollections.observableArrayList();
            rs = statement.executeQuery("Select * FROM SANGSTOCKE ");
            while (rs.next()) {
                Liste.add(new SangStocke(rs.getString("GROUPESANGUIN"), rs.getInt("NUMEROSAC"), rs.getString("DATECOLLECTION"), rs.getString("HOPITAL")));
            }
            return Liste;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ObservableList<SangStocke> getListeSangPerime () {
        try {
            Connection con = getConnection();
            ObservableList<SangStocke> Liste = FXCollections.observableArrayList();

            rs = statement.executeQuery("Select * FROM SANGSTOCKE WHERE SYSDATE >= TO_DATE( DATECOLLECTION, 'YYYY-MM-DD')+ 45");
            while (rs.next()) {
                Liste.add(new SangStocke(rs.getString("GROUPESANGUIN"), rs.getInt("NUMEROSAC"), rs.getString("DATECOLLECTION"), rs.getString("HOPITAL")));
            }
            return Liste;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}