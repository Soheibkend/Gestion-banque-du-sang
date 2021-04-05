package src.sample.Controllers;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import sample.Classes.*;

public class TraitementDmdDonController implements Initializable {
	
	 	@FXML
	    private TableView<DemandeSangAcc> tabDmdDonAcc;

	    @FXML
	    private TableColumn<DemandeSangAcc, String> col_numDmdAcc;

	    @FXML
	    private TableColumn<DemandeSangAcc, String> col_demandeurAcc;

	    @FXML
	    private TableColumn<DemandeSangAcc, String> col_dateDmdAcc;

	    @FXML
	    private TableView<DemandeSangRefus> tabDmdDonRef;

	    @FXML
	    private TableColumn<DemandeSangRefus, String> col_numDmdRef;

	    @FXML
	    private TableColumn<DemandeSangRefus, String> col_demandeurRef;

	    @FXML
	    private TableColumn<DemandeSangRefus, String> col_dateDmdRef;
	    
	    private Connection connection=null;
		private Statement stmt = null;
		private ResultSet rs = null;
		
		private ObservableList<DemandeSangAcc> listeDmdDonAcc = FXCollections.observableArrayList();
		private ObservableList<DemandeSangRefus> listeDmdDonRefus = FXCollections.observableArrayList();
	
    @FXML
    void Retourner(ActionEvent event) throws IOException {
 		Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/TraitementRequette.fxml"));
    	Scene scene = new Scene(root);
    	
    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void supprimerDmdDonAcc(ActionEvent event) {
    	DemandeSangAcc dmd = tabDmdDonAcc.getSelectionModel().getSelectedItem();
    	if(dmd == null) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("ERROR");
             alert.setHeaderText(null);
             alert.setContentText("Veuillez selectionner une demande de don existante !!");
             alert.showAndWait();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Information");
             alert.setHeaderText(null);
             alert.setContentText("Voulez vous réellement supprimer cette demande ?");
             alert.showAndWait();
             
             if(alert.getResult() == ButtonType.OK) {
            	 try {
					rs = stmt.executeQuery("delete from DemandeSangAcc where NumeroDemande = '"+dmd.getNumeroDemande()+"'");
				} catch (SQLException e) {
					e.printStackTrace();
				}
            	 
            	 Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	             alert2.setTitle("Information");
	             alert2.setHeaderText(null);
	             alert2.setContentText("Suppression faite avec succès !");
	             alert2.showAndWait();
	             
	            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/TraitementDmdDon.fxml"));
	 	    	Scene scene = new Scene(root);
	 	    	
	 	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	 	    	window.setScene(scene);
	 	    	window.show();
	             
             }
    	}
    }

    @FXML
    void supprimerDmdDonRefus(ActionEvent event) {
    	DemandeSangRefus dmd = tabDmdDonRef.getSelectionModel().getSelectedItem();
    	if(dmd == null) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("ERROR");
             alert.setHeaderText(null);
             alert.setContentText("Veuillez selectionner une demande de don existante !!");
             alert.showAndWait();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Information");
             alert.setHeaderText(null);
             alert.setContentText("Voulez vous réellement supprimer cette demande ?");
             alert.showAndWait();
             
             if(alert.getResult() == ButtonType.OK) {
            	 try {
					rs = stmt.executeQuery("delete from DemandeSangRefus where NumeroDemande = '"+dmd.getNumeroDemande()+"'");
				} catch (SQLException e) {
					e.printStackTrace();
				}
            	 
            	 Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	             alert2.setTitle("Information");
	             alert2.setHeaderText(null);
	             alert2.setContentText("Suppression faite avec succès !");
	             alert2.showAndWait();
	             
	            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/TraitementDmdDon.fxml"));
	 	    	Scene scene = new Scene(root);
	 	    	
	 	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	 	    	window.setScene(scene);
	 	    	window.show();
	             
             }
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            String dbURL = "jdbc:oracle:thin:@localhost:1521:SOHEIB";
            connection = DriverManager.getConnection(dbURL, "TPGL", "soheib");
            stmt = connection.createStatement();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// requette pout recuperer la liste des demandes de sang Acceptee de la BD
			rs = stmt.executeQuery("select * from DemandeSangAcc");
			while(rs.next()) {
				listeDmdDonAcc.add(new DemandeSangAcc(rs.getString("numeroDemande"),rs.getString("nomDemandeur"), rs.getString("nomDestinataire"), rs.getString("dateDemande"), rs.getString("GroupeSanguin"), rs.getString("NOMBRESAC"), rs.getString("REMARQUE"), rs.getString("Objectif"), rs.getString("dateAcc"))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		col_numDmdAcc.setCellValueFactory(new PropertyValueFactory<>("numeroDemande"));
		col_demandeurAcc.setCellValueFactory(new PropertyValueFactory<>("nomDemandeur"));
		col_dateDmdAcc.setCellValueFactory(new PropertyValueFactory<>("dateAcc"));
		
		tabDmdDonAcc.setItems(listeDmdDonAcc);
		
		try {
			// requette pout recuperer la liste des demandes de sang de la BD
			rs = stmt.executeQuery("select * from DemandeSangRefus");
			while(rs.next()) {
				listeDmdDonRefus.add(new DemandeSangRefus(rs.getString("numeroDemande"),rs.getString("nomDemandeur"), rs.getString("nomDestinataire"), rs.getString("dateDemande"), rs.getString("GroupeSanguin"), rs.getString("NOMBRESAC"), rs.getString("REMARQUE"), rs.getString("Objectif"), rs.getString("dateRefus"))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		col_numDmdRef.setCellValueFactory(new PropertyValueFactory<>("numeroRV"));
		col_demandeurRef.setCellValueFactory(new PropertyValueFactory<>("nomDemandeur"));
		col_dateDmdRef.setCellValueFactory(new PropertyValueFactory<>("dateRefus"));
		
		tabDmdDonRef.setItems(listeDmdDonRefus);
		
	}

}
