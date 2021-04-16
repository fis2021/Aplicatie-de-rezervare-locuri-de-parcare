package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import org.loose.fis.sre.exceptions.*;
import org.loose.fis.sre.services.UserService;

public class RegisterController {

    @FXML
    private Button SignupRegister;

    @FXML
    private ChoiceBox ChoiceBoxRegister;

    @FXML
    private TextField UsernameRegister;

    @FXML
    private PasswordField PasswordRegister;

    @FXML
    private Button RegisterButon;

    @FXML
    public void initialize() {
        ChoiceBoxRegister.getItems().addAll("Client", "Administatror Mall");
    }

    @FXML
    public void handleRegisterAction() {
        try {

            int nr = 0;
            if((UsernameRegister.getText().equals("")) && !(PasswordRegister.getText().equals("")))
                nr = 1;

            if(!(UsernameRegister.getText().equals("")) && (PasswordRegister.getText().equals("")))
                nr = 2;

            if((UsernameRegister.getText().equals("")) && (PasswordRegister.getText().equals("")))
                nr = 3;

            if(!(UsernameRegister.getText().equals("")) && !(PasswordRegister.getText().equals("")))
            {
                nr = 4;
                UserService.addUser(UsernameRegister.getText(), PasswordRegister.getText(), (String) ChoiceBoxRegister.getValue());
            }

            switch (nr){
                case 1 :    ExceptieUsernameGol.display(); break;
                case 2 :    ExceptiePasswordGol.display(); break;
                case 3 :    ExceptieUsernameAndPasswordGoale.display(); break;
                case 4 :    ExceptieUsernameValid.displayValid(); break;
                default:
                    System.out.println("Eroare la exceptii Register.");
            }

        } catch (UsernameAlreadyExistsException e) {

            ExceptieUsernameInvalid.displayInvalid();
        }
    }


}
