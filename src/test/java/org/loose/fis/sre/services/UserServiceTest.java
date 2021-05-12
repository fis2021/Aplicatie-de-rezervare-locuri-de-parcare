package org.loose.fis.sre.services;

import org.dizitart.no2.exceptions.InvalidIdException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.loose.fis.sre.controllers.MainStageController;
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
    @Test
    @DisplayName("Adaugare Dublicate")
    void addMallDuplicateTest(){
        assertThrows(UsernameAlreadyExistsException.class, () -> {
            MallService.initDatabaseMall();
            MallService.addMall("Petrea","Papagalul","2");
            MallService.addMall("Petrea","Papagalul","2");
        });
    }
    @Test
    @DisplayName("Adaugare mall Username field gol")
    void addMallEmptyUsername(){
        assertThrows(InvalidIdException.class, () -> {
            MallService.addMall("","Papagalul","2");
        });
    }
    @Test
    @DisplayName("Adaugare mall Password field gol")
    void addMallEmptyPassword(){
        assertThrows(NullPointerException.class, () -> {
            MallService.addMall("Petrea","","2");
        });
    }
    @Test
    @DisplayName("Adaugare mall Floor field gol")
    void addMallEmptyFloor(){
        assertThrows(UsernameAlreadyExistsException.class, () -> {
            MallService.addMall("Petrea","Papagalul","");
        });
    }
}