package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB.DBCONNECTION;

import java.io.IOException;

public class AjouterDonController {

    @FXML
    Button retourButton;

    @FXML
    TextField nomDonneur;

    @FXML
    TextField nomMedecin;

    @FXML
    TextField hopital;

    @FXML
    TextField groupeSanguin;


    public void retourButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) retourButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/gestionDons.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void ajouterButtonClicked (ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("voulez vous ajouter ce don du sang ?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
                DBCONNECTION.addDon(nomDonneur.getText(), groupeSanguin.getText(), hopital.getText(),nomMedecin.getText());
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Felecitation!");
                alert1.setHeaderText(null);
                alert1.setContentText("ajout fait avec succes");
                alert1.showAndWait();
            }
        }


}
