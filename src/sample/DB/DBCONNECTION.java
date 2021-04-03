package sample.DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.sql.*;
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
            rs = statement.executeQuery("select * FROM DEMANDESANG WHERE MATRICULE = '"+numeroDemande+"'");
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
            statement.executeQuery("INSERT INTO DEMANDESANG"+"  VALUES ('" +numeroDemande + "','"+nomDemandeur+"','"+ nomDestinataire+ "','"+ dateDemande+"','"+groupeSanguin+"',"+ nombreSac+",'"+ remarque+"','"+objectif+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}