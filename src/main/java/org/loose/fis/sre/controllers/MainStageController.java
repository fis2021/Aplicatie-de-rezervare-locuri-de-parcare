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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.AddException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Mall;
import org.loose.fis.sre.services.MallService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import static org.loose.fis.sre.services.MallService.checkMallDoesNotAlreadyExist;

public class MainStageController implements  Initializable{

    @FXML
    private VBox VboxTable;

    @FXML
    private VBox VboxAddMall;

    @FXML
    private VBox VboxSearch;

    @FXML
    private HBox Mall1;

    @FXML
    private HBox Mall2;

    @FXML
    private Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18;

    @FXML
    private Button c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18;

    @FXML
    private TableView<Mall> Table = new TableView<>();

    @FXML
    private TableColumn<Mall, String> TableName;

    @FXML
    private TableColumn<Mall, String> TableAdress;

    @FXML
    private TableColumn<Mall, String> TableFloors;

    @FXML
    private TextField MallName;

    @FXML
    private TextField MallAdress;

    @FXML
    private TextField MallFloors;

    @FXML
    private TextField MallSearch;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableAdress.setCellValueFactory(new PropertyValueFactory<>("Adress"));
        TableFloors.setCellValueFactory(new PropertyValueFactory<>("Floors"));
        Table.setItems(getMalls());
    }

    private ObservableList<Mall> malluri = FXCollections.observableArrayList();
    private ArrayList<Mall> list = new ArrayList<>();

    private ObservableList<Mall> getMalls()  {
        for (Mall ma : MallService.GetRepository().find())
            list.add(ma);

        malluri.addAll(list);
        return malluri;
    }

    public void handleAddAction() {

        Mall m = new Mall();
        if(MallName.getText().equals("") || MallAdress.getText().equals("") || MallFloors.getText().equals("")){
            AddException.displayInvalid();
            return;
        }
        m.setName(MallName.getText());
        m.setAdress(MallAdress.getText());
        m.setFloors(MallFloors.getText());

        try {
            checkMallDoesNotAlreadyExist(MallName.getText());
            MallService.GetRepository().insert(m);
            Table.getItems().add(m);
        }catch (UsernameAlreadyExistsException e){
            AddException.displayInvalid();
        }

        MallName.clear();
        MallAdress.clear();
        MallFloors.clear();
    }

    public void handleActionDelete(){

        ObservableList<Mall> MallSelected , AllMalls;

        AllMalls = Table.getItems();
        MallSelected = Table.getSelectionModel().getSelectedItems();

        for(Mall i : MallSelected)
        {
            MallService.GetRepository().remove(i);
        }

        MallSelected.forEach(AllMalls::remove);
    }


    private int nr = 0;

    public int handleAddFloorAction(int nr) {

        if (MallSearch.getText().equals("")) {
            AddException.displayInvalid();
        }

        for (Mall mall : MallService.GetRepository().find()) {
            nr++;

            if (Objects.equals(mall.getName(), MallSearch.getText())) {
                MallSearch.clear();
                return nr;
            }
        }

        return 0;
    }

    public void Afisare1(){

        switch (handleAddFloorAction(nr)) {
            case 1 -> {
                VboxSearch.setVisible(false);
                Mall1.setVisible(true);
            }
            case 2 -> {
                VboxSearch.setVisible(false);
                Mall2.setVisible(true);
            }

            default -> System.out.println("Eroare afisare etaje.");
        }
    }

    public void AddMall(){
        VboxAddMall.setVisible(true);
        VboxTable.setVisible(false);
        VboxSearch.setVisible(false);
        Mall1.setVisible(false);
        Mall2.setVisible(false);
    }

    public void Home(){
        VboxAddMall.setVisible(false);
        VboxTable.setVisible(true);
        VboxSearch.setVisible(false);
        Mall1.setVisible(false);
        Mall2.setVisible(false);
    }

    public void SearchFloor(){
        VboxAddMall.setVisible(false);
        VboxTable.setVisible(false);
        VboxSearch.setVisible(true);
        Mall1.setVisible(false);
        Mall2.setVisible(false);
    }

    public static void display() {
        Stage window = new Stage();
        Parent root ;
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