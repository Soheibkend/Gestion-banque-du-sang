package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Classes.CollectSang;
import sample.DB.DBCONNECTION;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoriqueDonControllers implements Initializable {

    @FXML
    TableView<CollectSang> TableHistorique;

    @FXML
    TableColumn<CollectSang,String> nomDonneur;

    @FXML
    TableColumn<CollectSang,String> hopital;

    @FXML
    TableColumn<CollectSang,String> dateDon;

    @FXML
    TableColumn<CollectSang,String> nomMedecin;

    @FXML
    TableColumn<CollectSang,String> groupeSanguin;

    @FXML
    TextField rechercheField;


    public void rechercheButttonClicked (ActionEvent event) {
        TableHistorique.setItems(DBCONNECTION.getListeDonneur(rechercheField.getText()));
    }

    public void retourButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) rechercheField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/gestionDons.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nomDonneur.setCellValueFactory(new PropertyValueFactory<CollectSang, String>("nomDonateur"));
        hopital.setCellValueFactory(new PropertyValueFactory<CollectSang, String>("hopital"));
        groupeSanguin.setCellValueFactory(new PropertyValueFactory<CollectSang, String>("groupeSanguin"));
        nomMedecin.setCellValueFactory(new PropertyValueFactory<CollectSang, String>("nomMedecin"));
        dateDon.setCellValueFactory(new PropertyValueFactory<CollectSang, String>("dateCollection"));

        TableHistorique.setItems(DBCONNECTION.getListeDonneurComplete());
        TableHistorique.setEditable(false);
    }
}
