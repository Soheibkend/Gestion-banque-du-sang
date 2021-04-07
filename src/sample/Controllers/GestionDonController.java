package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionDonController {

    @FXML
    Button retourButton;

    public void ajouterDonButtonClicked (ActionEvent event) throws IOException{
        Stage stage = (Stage) retourButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/ajouterDon.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void demandeSangButtonClicked (ActionEvent event) throws IOException{
        Stage stage = (Stage) retourButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/demandeSang.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void listeRVButtonClicked (ActionEvent event) throws IOException{
        Stage stage = (Stage) retourButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/ReceptionDmdRv.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void historiqueButtonClicked (ActionEvent event) throws IOException{
        Stage stage = (Stage) retourButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/historiqueDon.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }


    public void retourButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) retourButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/sample.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void traitementButtonClicked (ActionEvent event) throws IOException{
        Stage stage = (Stage) retourButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/TraitementRequette.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
