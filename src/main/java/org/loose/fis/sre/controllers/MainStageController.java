package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.AddException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Mall;
import org.loose.fis.sre.services.MallService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainStageController implements  Initializable{

    @FXML
    private VBox VboxTable;

    @FXML
    private TableView<Mall> Table = new TableView<>();

    @FXML
    private TableColumn<Mall, String> TableName;

    @FXML
    private TableColumn<Mall, String> TableAdress;

    @FXML
    private TableColumn<Mall, String> TableFloors;

    @FXML
    private VBox VboxAddMall;

    @FXML
    private TextField MallName;

    @FXML
    private TextField MallAdress;

    @FXML
    private TextField MallFloors;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableAdress.setCellValueFactory(new PropertyValueFactory<>("Adress"));
        TableFloors.setCellValueFactory(new PropertyValueFactory<>("Floors"));
        for (Mall m : MallService.GetRepository().find()) {
            list.add(m);
        }

        malluri.addAll(list);
        Table.getItems().addAll();
        Table.setItems(malluri);
    }

    private ObservableList<Mall> malluri = FXCollections.observableArrayList();

    private ArrayList<Mall> list = new ArrayList<>();

    public void handleLoginAction()  {
        try {
            MallService.addMall(MallName.getText(), MallAdress.getText(), MallFloors.getText());
        } catch (UsernameAlreadyExistsException e) {
            AddException.displayInvalid();
        }
    }

    public void AddMall(){
        VboxAddMall.setVisible(true);
        VboxTable.setVisible(false);
    }

    public void Home(){
        VboxAddMall.setVisible(false);
        VboxTable.setVisible(true);
    }

    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMaxWidth(400);

        Parent root = null;
        try {
            root = FXMLLoader.load(MainStageController.class.getClassLoader().getResource("Overview.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}