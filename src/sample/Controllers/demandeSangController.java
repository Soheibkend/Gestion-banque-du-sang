package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB.DBCONNECTION;
import java.io.IOException;

public class demandeSangController {

    @FXML
    TextField numeroDemandeField;

    @FXML
    TextField nomDemandeurField;

    @FXML
    TextField nomRecepteurField;

    @FXML
    TextField dateDemandeField;

    @FXML
    TextField groupeSanguinField;

    @FXML
    TextField nombreSacField;

    @FXML
    TextField remarqueField;

    @FXML
    TextField objectifField;





  public void retourButtonClicked (ActionEvent event) throws IOException {
      Stage stage = (Stage) objectifField.getScene().getWindow();
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("/sample/Views/gestionDons.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      stage.setScene(scene);
  }


  public void ajouterDemandeButtonClicked (ActionEvent event) {
      if (DBCONNECTION.demandeSangExiste(numeroDemandeField.getText())){
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("");
          alert.setHeaderText(null);
          alert.setContentText("impossible d'ajouter etudiant existe deja");
          alert.showAndWait();
      }
      else {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Confirmation");
          alert.setHeaderText(null);
          alert.setContentText("voulez vous ajouter l'etudiant ?");
          alert.showAndWait();
          if (alert.getResult() == ButtonType.OK) {
              if (numeroDemandeField.getText().equals("")) {
                  Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                  alert2.setTitle("ERREUR");
                  alert2.setHeaderText(null);
                  alert2.setContentText("remplire les champs vide");
                  alert2.showAndWait();
              } else {

                  //DBCONNECTION.addDemandeSang(numeroDemandeField.getText(), nomDemandeurField.getText(),nomRecepteurField.getText(), .getText(), Integer.valueOf(groupeField.getText()));
                  Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                  alert1.setTitle("Felecitation!");
                  alert1.setHeaderText(null);
                  alert1.setContentText("ajout fait avec succes");
                  alert1.showAndWait();
              }
          }
      }
  }
}
