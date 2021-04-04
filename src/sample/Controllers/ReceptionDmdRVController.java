package src.sample.Controllers;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import sample.Classes.RV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ReceptionDmdRVController implements Initializable {

    @FXML
    private TableView<RV> TabDemandeRV;

    @FXML
    private TableColumn<RV, Integer> col_NumRV;

    @FXML
    private TableColumn<RV, String> col_NomDonneur;

    @FXML
    private TableColumn<RV, LocalDate> col_DateRV;

    @FXML
    private TableColumn<RV, String> col_grpSang;

    @FXML
    private TableColumn<RV, String> col_hopital;
    
    private Connection connection=null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	private ObservableList<RV> listeDmdRV = FXCollections.observableArrayList();

    @FXML
    private TextField rechercheField;

    @FXML
    void Rechercher(ActionEvent event) {
    	String DmdR = rechercheField.getText();
    	try {
			rs = stmt.executeQuery("select * from RV where nomDonneur = "+DmdR);
			
			ObservableList<RV> list = FXCollections.observableArrayList();
			if(rs.next()) {
				list.add(new RV(rs.getInt("numeroRV"),rs.getString("nomDonneur"), rs.getString("GroupeSanguin"), rs.getString("dateRV"), rs.getString("hopital")));
				TabDemandeRV.setItems(list);
			
			} else {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	             alert.setTitle("INFORMATION !");
	             alert.setHeaderText(null);
	             alert.setContentText("Demande R.V inexistante avec ce donneur !");
	             alert.showAndWait();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
    @FXML
    void AccepterDmd(ActionEvent event) throws IOException {
    	RV dmd = TabDemandeRV.getSelectionModel().getSelectedItem();
    	if(dmd == null) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("ERROR");
             alert.setHeaderText(null);
             alert.setContentText("Veuillez selectionner une demande existante !!");
             alert.showAndWait();
    	} else {
            	 try {
					rs = stmt.executeQuery("delete from RV where numeroRV = '"+dmd.getNumeroRV()+"'");
				} catch (SQLException e) {
					e.printStackTrace();
				}
	             
            	try {
					rs = stmt.executeQuery("insert into RVAcc values('"+dmd.getNumeroRV()+"', '"+dmd.getNomDonneur()+"', '"+dmd.getGroupeSanguin()+"', '"+dmd.getDate()+"', '"+dmd.getHopital()+"')");
				} catch (SQLException e) {
					e.printStackTrace();
				} 
            	 
	            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/ReceptionDmdRV.fxml"));
	 	    	Scene scene = new Scene(root);
	 	    	
	 	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	 	    	window.setScene(scene);
	 	    	window.show();
	             
             }
    }

    @FXML
    void RefuserDmd(ActionEvent event) throws IOException {
    	RV dmd = TabDemandeRV.getSelectionModel().getSelectedItem();
    	if(dmd == null) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("ERROR");
             alert.setHeaderText(null);
             alert.setContentText("Veuillez selectionner une demande existante !!");
             alert.showAndWait();
    	} else {
            	 try {
					rs = stmt.executeQuery("delete from RV where numeroRV = '"+dmd.getNumeroRV()+"'");
				} catch (SQLException e) {
					e.printStackTrace();
				}
	             
            	try {
					rs = stmt.executeQuery("insert into RVRefus values('"+dmd.getNumeroRV()+"', '"+dmd.getNomDonneur()+"', '"+dmd.getGroupeSanguin()+"', '"+dmd.getDate()+"', '"+dmd.getHopital()+"')");
				} catch (SQLException e) {
					e.printStackTrace();
				} 
            	 
	            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/ReceptionDmdRV.fxml"));
	 	    	Scene scene = new Scene(root);
	 	    	
	 	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	 	    	window.setScene(scene);
	 	    	window.show();
	             
             }
    }
	
    @FXML
    void Retourner(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/GestionDons.fxml"));
    	Scene scene = new Scene(root);
    	
    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	// connexion a la base de donnee
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            String dbURL = "jdbc:oracle:thin:@localhost:1521:SOHEIB";
            connection = DriverManager.getConnection(dbURL, "TPGL", "soheib");
            stmt = connection.createStatement();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// requette pout recuperer la liste des demandes de sang de la BD
			rs = stmt.executeQuery("select * from RV");
			while(rs.next()) {
				listeDmdRV.add(new RV(rs.getInt("numeroRV"),rs.getString("nomDonneur"), rs.getString("GroupeSanguin"), rs.getString("dateRV"), rs.getString("hopital"))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		col_NumRV.setCellValueFactory(new PropertyValueFactory<>("numeroRV"));
		col_NomDonneur.setCellValueFactory(new PropertyValueFactory<>("nomDonneur"));
		col_grpSang.setCellValueFactory(new PropertyValueFactory<>("groupeSanguin"));
		col_DateRV.setCellValueFactory(new PropertyValueFactory<>("date"));
		col_hopital.setCellValueFactory(new PropertyValueFactory<>("hopital"));
		
		TabDemandeRV.setItems(listeDmdRV);
	}
    
}
