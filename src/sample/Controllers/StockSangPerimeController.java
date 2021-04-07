package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Classes.SangStocke;
import sample.DB.DBCONNECTION;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StockSangPerimeController implements Initializable {


    @FXML
    TableView<SangStocke> tableSangPerime;

    @FXML
    TableColumn<SangStocke,Integer> numeroSac;

    @FXML
    TableColumn<SangStocke,String> GroupeSanguin;

    @FXML
    TableColumn<SangStocke,String> hopital;

    @FXML
    TableColumn<SangStocke,String> dateCollection;

    @FXML
    Button retourButton;


    public void retourButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) retourButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/gestionStock.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        numeroSac.setCellValueFactory(new PropertyValueFactory<SangStocke, Integer>("numeroSac"));
        hopital.setCellValueFactory(new PropertyValueFactory<SangStocke, String>("hopital"));
        GroupeSanguin.setCellValueFactory(new PropertyValueFactory<SangStocke, String>("groupeSanguin"));
        dateCollection.setCellValueFactory(new PropertyValueFactory<SangStocke, String>("dateCollect"));

        tableSangPerime.setItems(DBCONNECTION.getListeSangPerime ());
        tableSangPerime.setEditable(false);

    }
}
