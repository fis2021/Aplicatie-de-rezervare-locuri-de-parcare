package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.RegistrationExceptii;
import org.loose.fis.sre.services.UserService;

public class RegisterController {

    @FXML
    private Button SignupRegister;

    @FXML
    private ChoiceBox<String> ChoiceBoxRegister;

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
            if(ChoiceBoxRegister.getValue() == null || (UsernameRegister.getText().equals(""))|| (PasswordRegister.getText().equals("")))
                RegistrationExceptii.displayInvalid();
            else{
                UserService.addUser(UsernameRegister.getText(), PasswordRegister.getText(), ChoiceBoxRegister.getValue());
                RegistrationExceptii.displayValid();
            }
        } catch (UsernameAlreadyExistsException e) {
            RegistrationExceptii.displayInvalid();
        }
    }