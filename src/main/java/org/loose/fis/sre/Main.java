package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import org.loose.fis.sre.services.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        initDirectory();
        UserService.initDatabase();
        MallService.initDatabaseMall();
        PriceService.initDatabasePrice();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Register.fxml"));

        primaryStage.getIcons().add(new Image("images/ParkingIcon.png"));
        primaryStage.setTitle("Aplicatie de rezervare locuri de parcare");
        primaryStage.setScene(new Scene(root, 770, 532));
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
