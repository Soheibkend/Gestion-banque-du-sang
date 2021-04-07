package sample.Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TraitementRequetteController {

	@FXML
	Button retourButton;
	
	 	@FXML
	    void Retourner(ActionEvent event) throws IOException {
			Stage stage = (Stage) retourButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/sample/Views/GestionDons.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
	    }

	    @FXML
	    void TraitementDemandeDon(ActionEvent event) throws IOException {

			Stage stage = (Stage) retourButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/sample/Views/TraitementDmdDon.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
	    }

	    @FXML
	    void TraitementDemandeRV(ActionEvent event) throws IOException {

			Stage stage = (Stage) retourButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/sample/Views/TraitementDmdRV.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
	    }


}
