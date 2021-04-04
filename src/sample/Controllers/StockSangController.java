package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Classes.SangStocke;
import sample.DB.DBCONNECTION;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StockSangController implements Initializable {

    @FXML
    TableView<SangStocke> tableStockSang;

    @FXML
    TableColumn<SangStocke,Integer> numeroSac;

    @FXML
    TableColumn<SangStocke,String> groupeSanguin;

    @FXML
    TableColumn<SangStocke,String> hopital;

    @FXML
    TableColumn<SangStocke,String> dateCollection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        numeroSac.setCellValueFactory(new PropertyValueFactory<SangStocke, Integer>("numeroSac"));
        hopital.setCellValueFactory(new PropertyValueFactory<SangStocke, String>("hopital"));
        groupeSanguin.setCellValueFactory(new PropertyValueFactory<SangStocke, String>("groupeSanguin"));
        dateCollection.setCellValueFactory(new PropertyValueFactory<SangStocke, String>("dateCollect"));

        tableStockSang.setItems(DBCONNECTION.getListeSangStocke ());
        tableStockSang.setEditable(false);

    }

    public void retourButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) tableStockSang.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/gestionStock.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
