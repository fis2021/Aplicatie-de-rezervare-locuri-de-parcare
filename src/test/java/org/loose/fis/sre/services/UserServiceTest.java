package org.loose.fis.sre.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.loose.fis.sre.controllers.RegisterController;
import org.loose.fis.sre.exceptions.LoginExceptii;
import org.loose.fis.sre.exceptions.RegistrationExceptii;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;

import javax.validation.constraints.Null;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @Test
    @DisplayName("Username already exists test")
    void displayDatabaseIsInitialisedAndUsernameAlreadyExists(){
        UserService.initDatabase();
        assertThrows(UsernameAlreadyExistsException.class, () -> {
            UserService.addUser("test","test","Client");
            UserService.addUser("test","test","Client");
        });
    }
    @Test
    @DisplayName("Empty username/password field")
    void registerTestFields(){
        assertThrows(NullPointerException.class, () -> {
            UserService.addUser("", "test", "Client");
            UserService.addUser("test", "", "Client");
                });
    }
    @Test
    @DisplayName("Login username/password field")
    void loginTestFields(){
        assertThrows(NullPointerException.class, () -> {
            assertFalse(UserService.checkAccountInformations("test","test"));
        });
    }


}