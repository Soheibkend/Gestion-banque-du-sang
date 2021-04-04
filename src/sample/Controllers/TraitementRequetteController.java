package src.sample.Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TraitementRequetteController {
	
	 	@FXML
	    void Retourner(ActionEvent event) throws IOException {
	 		Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/GestionDons.fxml"));
	    	Scene scene = new Scene(root);
	    	
	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    }

	    @FXML
	    void TraitementDemandeDon(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/TraitementDmdDon.fxml"));
	    	Scene scene = new Scene(root);
	    	
	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    }

	    @FXML
	    void TraitementDemandeRV(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/TraitementDmdRV.fxml"));
	    	Scene scene = new Scene(root);
	    	
	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    }


}
