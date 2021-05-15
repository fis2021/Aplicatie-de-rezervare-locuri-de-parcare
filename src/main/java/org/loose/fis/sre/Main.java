package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.MallService;
import org.loose.fis.sre.services.PriceService;
import org.loose.fis.sre.services.UserService;
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
