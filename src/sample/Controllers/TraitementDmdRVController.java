package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import sample.Classes.DemandeSangAcc;
import sample.Classes.DemandeSangRefus;
import sample.Classes.RVAcc;
import sample.Classes.RVRefus;
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

public class TraitementDmdRVController implements Initializable {
	
	 	@FXML
	    private TableView<RVAcc> tabRVAcc;

	    @FXML
	    private TableColumn<RVAcc, String> col_numRVAcc;

	    @FXML
	    private TableColumn<RVAcc, String> col_nomDonneurAcc;

	    @FXML
	    private TableColumn<RVAcc, String> col_dateRVAcc;

	    @FXML
	    private TableView<RVRefus> tabRVRef;

	    @FXML
	    private TableColumn<RVRefus, String> col_numRVRefus;

	    @FXML
	    private TableColumn<RVRefus, String> col_nomRef;

	    @FXML
	    private TableColumn<RVRefus, String> col_dateRef;

	    private Connection connection=null;
		private Statement stmt = null;
		private ResultSet rs = null;
		
		private ObservableList<sample.Classes.RVAcc> listeDmdRVAcc = FXCollections.observableArrayList();
		private ObservableList<sample.Classes.RVRefus> listeDmdRVRefus = FXCollections.observableArrayList();

    @FXML
    void Retourner(ActionEvent event) throws IOException {
 		Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/TraitementRequette.fxml"));
    	Scene scene = new Scene(root);
    	
    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void supprimerRVAcc(ActionEvent event) throws IOException{
    	RVAcc rv = tabRVAcc.getSelectionModel().getSelectedItem();
    	if(rv == null) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("ERROR");
             alert.setHeaderText(null);
             alert.setContentText("Veuillez selectionner un R.V existant !!");
             alert.showAndWait();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Information");
             alert.setHeaderText(null);
             alert.setContentText("Voulez vous r�ellement supprimer ce R.V ?");
             alert.showAndWait();
             
             if(alert.getResult() == ButtonType.OK) {
            	 try {
					rs = stmt.executeQuery("delete from RVAcc where NumeroRV = '"+rv.getNumeroRV()+"'");
				} catch (SQLException e) {
					e.printStackTrace();
				}
            	 
            	 Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	             alert2.setTitle("Information");
	             alert2.setHeaderText(null);
	             alert2.setContentText("Suppression faite avec succ�s !");
	             alert2.showAndWait();
	             
	            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/TraitementDmdRV.fxml"));
	 	    	Scene scene = new Scene(root);
	 	    	
	 	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	 	    	window.setScene(scene);
	 	    	window.show();
	             
             }
    	}

    }

    @FXML
    void supprimerRVRefus(ActionEvent event) throws IOException{
    	RVRefus rv = tabRVRef.getSelectionModel().getSelectedItem();
    	if(rv == null) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("ERROR");
             alert.setHeaderText(null);
             alert.setContentText("Veuillez selectionner un R.V existant !!");
             alert.showAndWait();
    	} else {
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Information");
             alert.setHeaderText(null);
             alert.setContentText("Voulez vous r�ellement supprimer ce R.V ?");
             alert.showAndWait();
             
             if(alert.getResult() == ButtonType.OK) {
            	 try {
					rs = stmt.executeQuery("delete from RVRefus where NumeroRV = '"+rv.getNumeroRV()+"'");
				} catch (SQLException e) {
					e.printStackTrace();
				}
            	 
            	 Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	             alert2.setTitle("Information");
	             alert2.setHeaderText(null);
	             alert2.setContentText("Suppression faite avec succ�s !");
	             alert2.showAndWait();
	             
	            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/TraitementDmdRV.fxml"));
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
			// requette pout recuperer la liste des demandes de sang de la BD
			rs = stmt.executeQuery("select * from RVAcc");
			while(rs.next()) {
				listeDmdRVAcc.add(new RVAcc(rs.getString("numeroRV"),rs.getString("nomDonneur"), rs.getString("dateRV"), rs.getString("GroupeSanguin"),  rs.getString("hopital"))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		col_numRVAcc.setCellValueFactory(new PropertyValueFactory<>("numeroRV"));
		col_nomDonneurAcc.setCellValueFactory(new PropertyValueFactory<>("nomDonneur"));
		col_dateRVAcc.setCellValueFactory(new PropertyValueFactory<>("dateRV"));

		tabRVAcc.setItems(listeDmdRVAcc);
		
		try {
			// requette pout recuperer la liste des demandes de sang de la BD
			rs = stmt.executeQuery("select * from RVRefus");
			while(rs.next()) {
				listeDmdRVRefus.add(new RVRefus(rs.getString("numeroRV"),rs.getString("nomDonneur"), rs.getString("GroupeSanguin"), rs.getString("dateDemande"), rs.getString("hopital"))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		col_numRVRefus.setCellValueFactory(new PropertyValueFactory<>("numeroRV"));
		col_nomRef.setCellValueFactory(new PropertyValueFactory<>("nomDonneur"));
		col_dateRef.setCellValueFactory(new PropertyValueFactory<>("dateRV"));

		tabRVRef.setItems(listeDmdRVRefus);
		
	}

}
