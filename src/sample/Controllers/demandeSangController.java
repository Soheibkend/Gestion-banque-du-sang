package sample.Controllers;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import src.sample.DB.DBCONNECTION;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.models.DemandeSang;
import sample.Classes.demandeSang;

public class demandeSangController implements Initializable {

	 @FXML
	    private TableView<demandeSang> TabDmdOrganisationDons;

	    @FXML
	    private TableColumn<demandeSang, String> Demandeur;

	    @FXML
	    private TableColumn<demandeSang, String> NomDest;

	    @FXML
	    private TableColumn<demandeSang, LocalDate> DateDmd;
	    
	    @FXML
	    private TableColumn<demandeSang, String> grpSang;

	    @FXML
	    private TableColumn<demandeSang, String> objectif;
	    
	    @FXML
	    private TextField demandeur;

	    @FXML
	    private TextField nomDestinataire;

	    @FXML
	    private TextField Objectif;

	    @FXML
	    private DatePicker dateDemande;
	    
	    @FXML
	    private TextField GroupeSang;
	    
	    @FXML
	    private TextField rechercheField;
	    
	    @FXML
	    private TextField Control_num;
	    
	    @FXML
	    private TextField Rmq;

	    @FXML
	    private TextField NbSac;
	    
	    private Connection connection=null;
		private Statement stmt = null;
		private ResultSet rs = null;
		
		private ObservableList<demandeSang> listeDmdSang = FXCollections.observableArrayList();


  public void Retourner (ActionEvent event) throws IOException {
      Stage stage = (Stage) objectifField.getScene().getWindow();
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("/sample/Views/gestionDons.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      stage.setScene(scene);
  }
  
  @FXML
  void Rechercher(ActionEvent event) {
  	String DmdR = rechercheField.getText();
  	try {
			rs = stmt.executeQuery("select * from DemandeSang where nomdemandeur = "+DmdR);
			
			ObservableList<demandeSang> list = FXCollections.observableArrayList();
			if(rs.next()) {
				list.add(new demandeSang(rs.getInt("numeroDemande"), rs.getString("nomdemandeur"), rs.getString("nomDestinataire"), rs.getDate("dateDemande").toLocalDate(), rs.getString("GroupeSanguin"), rs.getInt("NOMBRESAC"), rs.getString("REMARQUE"), rs.getString("Objectif")));
				TabDmdOrganisationDons.setItems(list);
			
			} else {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	             alert.setTitle("INFORMATION !");
	             alert.setHeaderText(null);
	             alert.setContentText("Demande organisation inexistante avec ce demandeur !");
	             alert.showAndWait();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
  }


  public void AjouterDmd (ActionEvent event) {
      if (DBCONNECTION.demandeSangExiste(Control_num.getText())){
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("");
          alert.setHeaderText(null);
          alert.setContentText("impossible d'ajouter !\n Demande de Sang existante deja");
          alert.showAndWait();
      }
      else {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Confirmation");
          alert.setHeaderText(null);
          alert.setContentText("voulez vous ajouter ce demande de sang ?");
          alert.showAndWait();
          if (alert.getResult() == ButtonType.OK) {
              if (Control_num.getText().equals("")) {
                  Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                  alert2.setTitle("ERREUR");
                  alert2.setHeaderText(null);
                  alert2.setContentText("remplire les champs vide");
                  alert2.showAndWait();
              } else {

                  DBCONNECTION.addDemandeSang(Control_num.getText(), demandeur.getText(),nomDestinataire.getText(), ""+dateDemande.getValue(), GroupeSang.getText(), Integer.parseInt(NbSac.getText()),Rmq.getText(), Objectif.getText());
                  Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                  alert1.setTitle("Felecitation!");
                  alert1.setHeaderText(null);
                  alert1.setContentText("ajout fait avec succes");
                  alert1.showAndWait();
              }
          }
      }
  }
  
  @FXML
  void AccepterDmd(ActionEvent event) throws IOException {
  	demandeSang dmd = TabDmdOrganisationDons.getSelectionModel().getSelectedItem();
  	if(dmd == null) {
  		Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("ERROR");
           alert.setHeaderText(null);
           alert.setContentText("Veuillez selectionner une demande existante !!");
           alert.showAndWait();
  	} else {
          	 try {
					rs = stmt.executeQuery("delete from DemandeSang where numeroDemande = "+dmd.getControl_num());
				} catch (SQLException e) {
					e.printStackTrace();
				}
	             
          	try {
					rs = stmt.executeQuery("insert into DemandeSangAcc values("+dmd.getControl_num()+", '"+dmd.getDemandeur()+"', '"+dmd.getNomDestinataire()+"', '"+dmd.getDateDemande()+"', '"+dmd.getGrpSang()+"' , '"+dmd.getNombreSac()+"', '"+dmd.getRemarque()+"', '"+dmd.getObjectif()+"','"+LocalDate.now()+"')");
				} catch (SQLException e) {
					e.printStackTrace();
				} 
          	 
	            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/demandeSang.fxml"));
	 	    	Scene scene = new Scene(root);
	 	    	
	 	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	 	    	window.setScene(scene);
	 	    	window.show();
	             
           }
  	}

  @FXML
  void RefuserDmd(ActionEvent event) throws IOException {
  	demandeSang dmd = TabDmdOrganisationDons.getSelectionModel().getSelectedItem();
  	if(dmd == null) {
  		Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("ERROR");
           alert.setHeaderText(null);
           alert.setContentText("Veuillez selectionner une demande existante !!");
           alert.showAndWait();
  	} else {
          	 try {
					rs = stmt.executeQuery("delete from DemandeSang where numeroDemande = "+dmd.getControl_num());
				} catch (SQLException e) {
					e.printStackTrace();
				}
          	 
          	 try {
					rs = stmt.executeQuery("insert into DemandeSangRefus values("+dmd.getControl_num()+", '"+dmd.getDemandeur()+"', '"+dmd.getNomDestinataire()+"', '"+dmd.getDateDemande()+"', '"+dmd.getGrpSang()+"' , '"+dmd.getNombreSac()+"', '"+dmd.getRemarque()+"', '"+dmd.getObjectif()+"','"+LocalDate.now()+"')");
				} catch (SQLException e) {
					e.printStackTrace();
				} 
	             
	            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/demandeSang.fxml"));
	 	    	Scene scene = new Scene(root);
	 	    	
	 	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	 	    	window.setScene(scene);
	 	    	window.show();
	             
           }
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
 			rs = stmt.executeQuery("select * from DemandeSang");
 			while(rs.next()) {
 				listeDmdSang.add(new demandeSang(rs.getString("numeroDemande"), rs.getString("nomdemandeur"), rs.getString("nomDestinataire"), rs.getString("dateDemande"), rs.getString("GroupeSanguin"), rs.getInt("NOMBRESAC"), rs.getString("REMARQUE"), rs.getString("Objectif"))
 						);
 			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		} 
 		
 		Demandeur.setCellValueFactory(new PropertyValueFactory<>("demandeur"));
 		NomDest.setCellValueFactory(new PropertyValueFactory<>("nomDestinataire"));
 		DateDmd.setCellValueFactory(new PropertyValueFactory<>("dateDemande"));
 		grpSang.setCellValueFactory(new PropertyValueFactory<>("GrpSang"));
 		objectif.setCellValueFactory(new PropertyValueFactory<>("Objectif"));
 		
 		TabDmdOrganisationDons.setItems(listeDmdSang);
 	}

}
