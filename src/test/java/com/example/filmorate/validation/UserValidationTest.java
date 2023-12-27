package com.example.filmorate.validation;

import com.example.filmorate.exception.UserException;
import com.example.filmorate.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {

    private static final User rightUser = new User(1, "1093se@gmail.com", "BosSer", null,
            LocalDate.of(2000, Month.DECEMBER, 28));

    private static final User wrongUser1 = new User(1, "1093segmail.com", "S sd", "SER",
            LocalDate.of(2000, Month.DECEMBER, 28));
    private static final User wrongUser2 = new User(1, null, null, "SER",
            LocalDate.of(2050, Month.DECEMBER, 28));

    @Test
    void checkEmail() throws UserException {
        UserException thrown1 = assertThrows(UserException.class,
                () -> UserValidation.checkEmail(wrongUser1.getEmail()));
        assertTrue(thrown1.getMessage().contains("Email must contain '@'"));

        UserException thrown2 = assertThrows(UserException.class,
                () -> UserValidation.checkEmail(wrongUser2.getEmail()));
        assertTrue(thrown2.getMessage().contains("Email is null"));

        assertDoesNotThrow(() -> UserValidation.checkEmail(rightUser.getEmail()));

    }

    @Test
    void checkLogin() {
        UserException thrown1 = assertThrows(UserException.class,
                () -> UserValidation.checkLogin(wrongUser2.getLogin()));
        assertTrue(thrown1.getMessage().contains("Login is null"));

        UserException thrown2 = assertThrows(UserException.class,
                () -> UserValidation.checkLogin(wrongUser1.getLogin()));
        assertTrue(thrown2.getMessage().contains("Login mustn't contain whitespaces"));

        assertDoesNotThrow(() -> UserValidation.checkLogin(rightUser.getLogin()));
    }

    @Test
    void checkName() {
        assertDoesNotThrow(() -> UserValidation.checkName(rightUser));
        assertEquals("BosSer", rightUser.getName());
    }

    @Test
    void checkBirthday() {
        UserException thrown1 = assertThrows(UserException.class,
                () -> UserValidation.checkBirthday(wrongUser2.getBirthday()));
        assertTrue(thrown1.getMessage().contains("Birthday date can't be in the future"));
    }
}