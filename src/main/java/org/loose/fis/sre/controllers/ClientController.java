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
import org.loose.fis.sre.model.Mall;
import org.loose.fis.sre.model.Price;
import org.loose.fis.sre.services.MallService;
import org.loose.fis.sre.services.PriceService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClientController implements  Initializable{

    @FXML
    private VBox VboxTable;

    @FXML
    private VBox VboxSearch;

    @FXML
    private VBox VboxPlata;

    @FXML
    private VBox VboxPrices;

    @FXML
    private HBox Mall1;

    @FXML
    private HBox Mall2;

    @FXML
    private Button e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18;

    @FXML
    private Button g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14,g15,g16,g17,g18,h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13,h14,h15,h16,h17,h18;

    @FXML
    private TableView<Mall> Table = new TableView<>();

    @FXML
    private TableColumn<Mall, String> TableName;

    @FXML
    private TableColumn<Mall, String> TableAdress;

    @FXML
    private TableColumn<Mall, String> TableFloors;

    @FXML
    private TableView<Price> TablePrice = new TableView<>();

    @FXML
    private TableColumn<Price, String> NameMall;

    @FXML
    private TableColumn<Price, Integer> Price1Mall;

    @FXML
    private TableColumn<Price, Integer> Price2Mall;

    @FXML
    private TextField MallSearch;

    @FXML
    private TextField PIN;

    @FXML
    private Button SignOutClient;

    public Button SUBMIT;

    private static final int COD_CARD = 1234;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableAdress.setCellValueFactory(new PropertyValueFactory<>("Adress"));
        TableFloors.setCellValueFactory(new PropertyValueFactory<>("Floors"));
        Table.setItems(getMalls());

        NameMall.setCellValueFactory(new PropertyValueFactory<>("nume"));   ///trebuie setate ca numele campurilor din clasa respectiva
        Price1Mall.setCellValueFactory(new PropertyValueFactory<>("price1"));
        Price2Mall.setCellValueFactory(new PropertyValueFactory<>("price2"));
        TablePrice.setItems(getPrice());
    }

    private ObservableList<Mall> malluri = FXCollections.observableArrayList();
    private ArrayList<Mall> list = new ArrayList<>();

    private ObservableList<Mall> getMalls()  {
        for (Mall ma : MallService.GetRepository().find())
            list.add(ma);

        malluri.addAll(list);
        return malluri;
    }

    private ObservableList<Price> malluriPrice = FXCollections.observableArrayList();
    private ArrayList<Price> list2 = new ArrayList<>();

    private ObservableList<Price> getPrice()  {
        for (Price p : PriceService.getPriceRepository().find())
            list2.add(p);

        malluriPrice.addAll(list2);
        return malluriPrice;
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
                VboxPlata.setVisible(true);
            }
            case 2 -> {
                VboxSearch.setVisible(false);
                Mall2.setVisible(true);
                VboxPlata.setVisible(true);
            }
            default -> System.out.println("Eroare afisare etaje.");
        }
    }

    private void pas2(Button g1, Button g2, Button g3, Button g4, Button g5, Button g6, Button g7, Button g8, Button g9, Button g10, Button g11, Button g12, Button g13, Button g14, Button g15, Button g16, Button g17, Button g18, Button h1, Button h2, Button h3, Button h4, Button h5, Button h6, Button h7, Button h8, Button h9, Button h10, Button h11, Button h12, Button h13, Button h14, Button h15, Button h16, Button h17, Button h18) {
        pas(g1, g2, g3, g4, g5, g6, g7, g8, g9);
        pas(g10, g11, g12, g13, g14, g15, g16, g17, g18);
        pas(h1, h2, h3, h4, h5, h6, h7, h8, h9);
        pas(h10, h11, h12, h13, h14, h15, h16, h17, h18);
    }

    private void pas(Button g10, Button g11, Button g12, Button g13, Button g14, Button g15, Button g16, Button g17, Button g18) {
        g10.setOnMouseClicked(e -> g10.setStyle("-fx-background-color: #ad1010"));
        g11.setOnMouseClicked(e -> g11.setStyle("-fx-background-color: #ad1010"));
        g12.setOnMouseClicked(e -> g12.setStyle("-fx-background-color: #ad1010"));
        g13.setOnMouseClicked(e -> g13.setStyle("-fx-background-color: #ad1010"));
        g14.setOnMouseClicked(e -> g14.setStyle("-fx-background-color: #ad1010"));
        g15.setOnMouseClicked(e -> g15.setStyle("-fx-background-color: #ad1010"));
        g16.setOnMouseClicked(e -> g16.setStyle("-fx-background-color: #ad1010"));
        g17.setOnMouseClicked(e -> g17.setStyle("-fx-background-color: #ad1010"));
        g18.setOnMouseClicked(e -> g18.setStyle("-fx-background-color: #ad1010"));
    }

    public void Submit(){

        if(PIN.getText().equals(String.valueOf(COD_CARD))) {
            pas2(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18);
            pas2(g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16, g17, g18, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18);
            PIN.clear();
        }
        else {
            PIN.clear();
            AddException.displayInvalid();
        }
    }

    public void Home(){
        VboxTable.setVisible(true);
        VboxSearch.setVisible(false);
        Mall1.setVisible(false);
        Mall2.setVisible(false);
        VboxPlata.setVisible(false);
        VboxPrices.setVisible(false);
    }

    public void SearchFloor(){
        VboxTable.setVisible(false);
        VboxSearch.setVisible(true);
        Mall1.setVisible(false);
        Mall2.setVisible(false);
        VboxPlata.setVisible(false);
        VboxPrices.setVisible(false);
    }

    public void SearchPrices(){
        VboxTable.setVisible(false);
        VboxSearch.setVisible(false);
        Mall1.setVisible(false);
        Mall2.setVisible(false);
        VboxPlata.setVisible(false);
        VboxPrices.setVisible(true);
    }

    public void SignOut()
    {
        Stage stage = (Stage) SignOutClient.getScene().getWindow();
        stage.close();
    }

    public static void display() {
        Stage window = new Stage();
        Parent root ;
        try {
            root = FXMLLoader.load(MainStageController.class.getClassLoader().getResource("OverviewClient.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}