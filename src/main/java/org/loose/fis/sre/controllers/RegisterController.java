package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.loose.fis.sre.exceptions.RegistrationExceptii;
import org.loose.fis.sre.exceptions.LoginExceptii;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

public class RegisterController {

    @FXML
    private Button SignupRegister;

    @FXML
    private Button LoginRegister;

    @FXML
    private ChoiceBox<String> ChoiceBoxRegister;

    @FXML
    private TextField UsernameRegister;

    @FXML
    private TextField UsernameLogin;

    @FXML
    private PasswordField PasswordRegister;

    @FXML
    private PasswordField PasswordLogin;

    @FXML
    private Button RegisterButon;

    @FXML
    private Button LoginButon;

    @FXML
    private AnchorPane RegisterPane;

    @FXML
    private AnchorPane LoginPane;
    @FXML
    public void initialize() {
        ChoiceBoxRegister.getItems().addAll("Client", "Administatror Mall");
    }

    @FXML
    public void handleRegisterAction() {
        try {

            if (ChoiceBoxRegister.getValue() == null || (UsernameRegister.getText().equals("")) || (PasswordRegister.getText().equals("")))
                RegistrationExceptii.displayInvalid();
            else {
                UserService.addUser(UsernameRegister.getText(), PasswordRegister.getText(), ChoiceBoxRegister.getValue());
                RegistrationExceptii.displayValid();
            }

        } catch (UsernameAlreadyExistsException e) {
            RegistrationExceptii.displayInvalid();
        }
    }

    public void handleLoginAction() {
        try {

            if((UsernameLogin.getText().equals("")) || (PasswordLogin.getText().equals("")))
                LoginExceptii.displayInvalid();
            else {
                UserService.checkAccountInformations(UsernameLogin.getText(), PasswordLogin.getText());
            }

        } catch (Exception e) {
            LoginExceptii.displayInvalid();
        }
    }

    public void LoginPane(){
        LoginPane.setVisible(true);
        RegisterPane.setVisible(false);
    }

    public void RegisterPane(){
        LoginPane.setVisible(false);
        RegisterPane.setVisible(true);
    }
}