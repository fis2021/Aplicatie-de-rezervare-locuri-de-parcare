package org.loose.fis.sre.exceptions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationExceptii {

    public static void displayInvalid(){
        Stage window = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(RegistrationExceptii.class.getClassLoader().getResource("InvalidRegistrationException.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void displayValid(){
        Stage window = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(RegistrationExceptii.class.getClassLoader().getResource("ValidRegistrationException.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();
    }


}
