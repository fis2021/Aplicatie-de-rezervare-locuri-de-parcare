package org.loose.fis.sre.exceptions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ExceptieUsernameInvalid {

    public static void displayInvalid(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMaxWidth(400);

        Parent root = null;
        try {
            root = FXMLLoader.load(ExceptieUsernameInvalid.class.getClassLoader().getResource("ExceptieValidareNereusita.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();
    }
}
